package com.reqhub.reqhub.config;

import com.reqhub.reqhub.domain.Authority;
import com.reqhub.reqhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> usuarioRepository.findByEmail(username)
            .map(usuario -> {
                String[] roles = usuario.getAuthorities()
                    .stream()
                    .map(Authority::getAuthority)
                    .toArray(String[]::new);
                return org.springframework.security.core.userdetails.User
                    .withUsername(usuario.getEmail())
                    .password(usuario.getSenha())
                    .roles(roles)
                    .build();
            })
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desativado para testes
            .authorizeHttpRequests(authorizeRequests -> 
                authorizeRequests
                    .requestMatchers("/", "/auths/cadastrar", "/auths/login", "/css/**", "/img/**", "/js/**").permitAll() // URLs públicas
                    .requestMatchers("/users/**").hasRole("ADMIN")
                    .requestMatchers("/authorities/**").hasRole("ADMIN")
                    .requestMatchers("/home").hasAnyRole("USER", "ADMIN")
                    .anyRequest().authenticated()
            )
            .formLogin(form -> 
                form
                    .loginPage("/auths/login") // Página de login
                    .loginProcessingUrl("/authenticate")
                    .defaultSuccessUrl("/home", true) // Aqui você pode mudar para '/auths/login' se preferir
                    .failureUrl("/auths/login?error") // Define explicitamente a URL de falha
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
