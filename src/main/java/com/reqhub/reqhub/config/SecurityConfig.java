package com.reqhub.reqhub.config;

import com.reqhub.reqhub.repository.AuthorityRepository; // Importe esta classe
import com.reqhub.reqhub.repository.UsuarioRepository;
import com.reqhub.reqhub.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UsuarioRepository usuarioRepository;
    private final AuthorityRepository authorityRepository; // Declare o AuthorityRepository

    public SecurityConfig(UsuarioRepository usuarioRepository, AuthorityRepository authorityRepository) { // Modifique o construtor
        this.usuarioRepository = usuarioRepository;
        this.authorityRepository = authorityRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(usuarioRepository, passwordEncoder(), authorityRepository); // Passe o authorityRepository
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/", "/auths/login", "/auths/cadastrar", "/css/**", "/img/**", "/js/**").permitAll()
                    .requestMatchers("/atendente/**").hasRole("ADMIN")
                    .requestMatchers("/users/**", "/ordens/**").hasAnyRole("USER", "ADMIN")
                    .anyRequest().authenticated()
            )
            .formLogin(form ->
                form
                    .loginPage("/auths/login")
                    .loginProcessingUrl("/auths/login")
                    .successHandler((request, response, authentication) -> {
                        boolean isAdmin = authentication.getAuthorities().stream()
                            .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));

                        if (isAdmin) {
                            response.sendRedirect("/atendente/home-atendente");
                        } else {
                            response.sendRedirect("/users/homeL");
                        }
                    })
                    .failureUrl("/auths/login?error")
                    .permitAll()
            )
            .logout(logout ->
                logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/auths/login?logout")
                    .permitAll()
            )
            .exceptionHandling(exception ->
                exception
                    .accessDeniedPage("/access-denied")
            );

        return http.build();
    }
}