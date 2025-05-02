# Hub Request – Sistema de Gerenciamento de Requisições

## Informações do Projeto

**Cliente**: Fracieli Soares de Oliveira  
**CNPJ/CPF**: 042563141/99  
**Contato**: 66999133490  
**Email do contato**: francielisoaresbeautystudio@gmail.com  

### Equipe

| Nome Completo                              | Curso                                   | Disciplina |
|--------------------------------------------|-----------------------------------------|------------|
| André Lucas Martins Ezequiel              | Ciência da Computação                  | ARA 00110  |
| Beatriz Colombo de Oliveira               | Análise e Desenvolvimento de Sistemas   | ARA 00110  |
| Jennifer de Oliveira                      | Ciência da Computação                  | ARA 00110  |
| Pedro Henrique da Silva dos Santos       | Ciência da Computação                  | ARA 00110  |

**Professor Orientador**: Kesede Rodrigues Julio

## Contexto e Problema

O cliente identificou a necessidade de melhorar o processo de abertura e gerenciamento de chamados técnicos de TI, que atualmente é realizado de forma desorganizada, majoritariamente via e-mail ou telefone, dificultando o controle e acompanhamento das solicitações.

## Solução Proposta

Para resolver este problema, será desenvolvido o **Hub Request**, um sistema de Help Desk especializado para o setor de Tecnologia da Informação (TI). O sistema permitirá a abertura de chamados, sugestões de melhorias e o acompanhamento do status das solicitações de maneira prática e centralizada.

O sistema contará com diferentes perfis de usuário (administradores e atendentes), integrando funcionalidades como cadastro de usuários, gerenciamento de ordens de serviço e controle de setores.

## Tecnologias Utilizadas

A solução será implementada utilizando as seguintes tecnologias:
- **Java 21** com **Spring Boot** para o backend.
- **PostgreSQL** para persistência de dados.
- **Thymeleaf** para o front-end.
- **Bootstrap** para a construção de uma interface web responsiva.

## Impacto

O **Hub Request** trará mais agilidade, organização e rastreabilidade ao processo de suporte técnico da empresa, reduzindo falhas de comunicação e melhorando a eficiência no atendimento de TI.

## Objetivo

Desenvolver o sistema **Hub Request** para centralizar, organizar e otimizar o processo de abertura, gestão e acompanhamento de chamados técnicos de TI. O objetivo principal é substituir o atual método informal (e-mails, ligações e mensagens soltas) por uma plataforma única, eficiente e de fácil utilização, melhorando o controle, a comunicação e a rastreabilidade dos atendimentos internos.

### Resultados Esperados
- Reduzir o tempo de resposta para solicitações de TI.
- Facilitar a gestão de demandas e a priorização dos atendimentos.
- Proporcionar uma visão clara do status de cada chamado para usuários e atendentes.
- Oferecer relatórios gerenciais que auxiliem na tomada de decisões do setor de TI.

## Escopo do Projeto

O escopo do projeto **Hub Request** abrange as funcionalidades e requisitos principais que serão implementados no sistema, bem como as limitações e o que não será abordado nesta versão.

### Requisitos Principais

1. **Cadastro e Autenticação de Usuários**  
   O sistema permitirá o cadastro de usuários com informações essenciais como nome, e-mail, ramal, senha e setor. A autenticação será realizada por e-mail e senha, permitindo que o usuário acesse as funcionalidades do sistema de acordo com sua função (usuário ou administrador).

2. **Gestão de Chamados Técnicos**  
   O sistema permitirá que os usuários abram chamados técnicos fornecendo um assunto (título) e uma descrição detalhada do problema ou solicitação. Esses chamados poderão ser classificados com três status: **PENDENTE**, **CONCLUÍDO** e **NÃO ATENDIDO**. A gestão desses chamados será realizada através de um painel de controle acessível aos administradores, que poderão alterar o status dos chamados e atribuir responsáveis.

3. **Central de Requisição**  
   Uma funcionalidade adicional será a central de requisição, onde os usuários poderão pesquisar problemas e soluções já registrados no sistema antes de abrirem um novo chamado. Isso ajudará a reduzir a duplicação de chamados e a otimizar o tempo de resolução.

### Limitações do Projeto (O que NÃO será Implementado)

- **Integração com sistemas externos**: Não será feita a integração com sistemas de notificação externos, como e-mails automáticos ou notificações via WhatsApp.
- **Suporte a anexos**: O sistema não permitirá o envio de arquivos (como imagens ou documentos) junto aos chamados.
- **Aplicativo Mobile**: O sistema será acessado exclusivamente via interface web, não havendo versão para dispositivos móveis.
- **Notificações Automáticas**: O sistema não contará com envio automático de notificações sobre o status dos chamados, nem com alertas por e-mail.

## Cronograma do Projeto

| Sprint | Período                    | Atividades Principais                                      | Pontos | Resultados Esperados                                      |
|--------|----------------------------|------------------------------------------------------------|--------|----------------------------------------------------------|
| Sprint 2 | 25/04/2025 - 02/05/2025 | Configurar ambiente (Eclipse, Java 21, PostgreSQL, Git)     | 17     | Ambiente configurado, projeto clonado e estudado.         |
| Sprint 3 | 05/05/2025 - 18/05/2025 | Modelagem (DER), Gestão de Status (backend), Readme.md      | 18     | DER concluído, status implementado, documentação iniciada.|
| Sprint 4 | 19/05/2025 - 01/06/2025 | Banco de dados, Gestão de Status (frontend), testes         | 21     | Banco implementado, status completo, testes iniciais.     |
| Sprint 5 | 02/06/2025 - 15/06/2025 | Painel de Admin, documentação, testes                      | 19     | Painel implementado, documentação avançada, testes feitos.|
| Sprint 6 | 16/06/2025 - 29/06/2025 | Gestão de Setores/Usuários, Relatórios (backend), slides    | 20     | Setores/usuários e relatórios iniciados, slides prontos.  |
| Sprint 7 | 30/06/2025 - 13/07/2025 | Relatórios (frontend), testes finais, apresentação          | 20     | MVP testado, relatórios completos, apresentado na FENETEC.|

### Notas
- **Feriados**: 01/05/2025 (Sprint 2, 1 semana), 19/06/2025 (Sprint 6, 9 dias úteis).
- **Total**: 115 pontos, média de ~19 pontos por sprint.
- **Escopo**: Configuração, modelagem, implementação de Gestão de Status (REQ-4), Painel de Admin (REQ-6), Setores/Usuários (REQ-7), Relatórios (REQ-8), testes, documentação, e apresentação.
