# 📚 Hub Request – Sistema de Gerenciamento de Requisições

## Dados do Cliente

* **Título do Projeto:** Hub Request – Sistema de Gerenciamento de Requisições
* **Cliente:** Fracieli Soares de Oliveira
* **CNPJ/CPF:** 042563141/99
* **Contato:** (66) 99913-3490
* **Email:** [francielisoaresbeautystudio@gmail.com](mailto:francielisoaresbeautystudio@gmail.com)

## Equipe de Desenvolvimento

| Nome                               | Curso                                 | Disciplina |
| ---------------------------------- | ------------------------------------- | ---------- |
| André Lucas Martins Ezequiel       | Ciência da Computação                 | ARA 00110  |
| Beatriz Colombo de Oliveira        | Análise e Desenvolvimento de Sistemas | ARA 00110  |
| Jennifer de Oliveira               | Ciência da Computação                 | ARA 00110  |
| Pedro Henrique da Silva dos Santos | Ciência da Computação                 | ARA 00110  |

**Professor Orientador:** Kesede Rodrigues Julio

## 1. Introdução

O cliente identificou a necessidade de melhorar o processo de abertura e gerenciamento de chamados técnicos de TI, que atualmente é realizado de forma desorganizada, majoritariamente via e-mail ou telefone, dificultando o controle e acompanhamento das solicitações.
Para resolver este problema, será desenvolvido o Hub Request, um sistema de Help Desk especializado para o setor de Tecnologia da Informação (TI), permitindo a abertura de chamados, sugestões de melhorias e o acompanhamento do status das solicitações de maneira prática e centralizada.
O sistema contará com diferentes perfis de usuário (administradores e atendentes), integrando funcionalidades como cadastro de usuários, gerenciamento de ordens de serviço e controle de setores.
A solução será implementada utilizando Java 21 com Spring Boot, PostgreSQL para persistência de dados, Thymeleaf no front-end, além de Bootstrap para a construção de uma interface web responsiva.
Impacto: O ReqHub trará mais agilidade, organização e rastreabilidade ao processo de suporte técnico da empresa, reduzindo falhas de comunicação e melhorando a eficiência no atendimento de TI.


## 2. Objetivo

Desenvolver o sistema HubRequest para centralizar, organizar e otimizar o processo de abertura, gestão e acompanhamento de chamados técnicos de TI.
O objetivo principal é substituir o atual método informal (e-mails, ligações e mensagens soltas) por uma plataforma única, eficiente e de fácil utilização, melhorando o controle, a comunicação e a rastreabilidade dos atendimentos 

Com o ReqHub, espera-se:

* Reduzir o tempo de resposta para solicitações de TI.
* Facilitar a gestão de demandas e a priorização dos atendimentos.
* Proporcionar uma visão clara do status de cada chamado para usuários e atendentes.
  
## 3. Escopo

O escopo do projeto ReqHub abrange as funcionalidades e requisitos principais que serão implementados no sistema, bem como as limitações e o que não será abordado nesta versão.

### Requisitos Principais::

* 1.	Cadastro e Autenticação de Usuários:
     
 O sistema permitirá o cadastro de usuários com informações essenciais como nome, e-mail, ramal, senha e setor. A autenticação será realizada por e-mail e senha, permitindo que o usuário acesse as funcionalidades do sistema de acordo com sua função (usuário ou administrador).

* 2. Gestão de chamados técnicos (PENDENTE, CONCLUÍDO, NÃO\_ATENDIDO)

O sistema permitirá que os usuários abram chamados técnicos fornecendo um assunto (título) e uma descrição detalhada do problema ou solicitação. Esses chamados poderão ser classificados com três status: PENDENTE, CONCLUIDO e NAO_ATENDIDO. A gestão desses chamados será realizada através de um painel de controle acessível aos administradores, que poderão alterar o status dos chamados e atribuir responsáveis. 

* 3. Central de Requisições

 Uma funcionalidade adicional será a central de requisição, onde os usuários poderão pesquisar problemas e soluções já registrados no sistema antes de abrirem um novo chamado. Isso ajudará a reduzir a duplicação de chamados e a otimizar o tempo de resolução.

### Limitações do Projeto (O que NÃO será Implementado)::

* Integração com sistemas externos: Não será feita a integração com sistemas de notificação externos, como e-mails automáticos ou notificações via WhatsApp.
* Suporte a anexos: O sistema não permitirá o envio de arquivos (como imagens ou documentos) junto aos chamados.
* Aplicativo Mobile: O sistema será acessado exclusivamente via interface web, não havendo versão para dispositivos móveis.****
* Notificações Automáticas: O sistema não contará com envio automático de notificações sobre o status dos chamados, nem com alertas por e-mail.

## 4. Backlogs do Produto

* 1.	Tela para o Usuário Abrir Chamado
Descrição: Interface que permite ao usuário criar um novo chamado, inserindo informações como descrição do problema.

* 2. Tela para Consultar Chamado

Descrição: Interface para o usuário visualizar o status e os detalhes de todos chamado abertos por ele.

* 3. Central de Requisições para Pesquisar Chamados Similares

Descrição: Funcionalidade que permite buscar chamados com características semelhantes (por palavras-chave ou filtros) para evitar duplicidade ou auxiliar na resolução.

* 4.	Painel de Gestão para Administradores
Descrição: Painel administrativo para visualizar todos os chamados abertos, com opções para filtrar, responder e gerenciar o status dos chamados.

* 5.	Aba para a Criar Setores
	Descrição: Interface para administradores criarem e gerenciarem setores.

* 6.	Editar Conta do Usuário
  Descrição: Funcionalidade que permite ao usuário atualizar suas informações pessoais, como nome, e-mail e senha.

Excelente! Aqui está a seção do **cronograma** formatada para o `README.md` no GitHub, incluindo a nova estrutura, pontos e observações:

---

##  5. Cronograma

| Sprint   | Período                 | Atividades Principais                                                                                                                                                                                                                            | Pontos | Resultados Esperados                                                                                              |
| -------- | ----------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------ | ----------------------------------------------------------------------------------------------------------------- |
| Sprint 2 | 25/04/2025 - 02/05/2025 | Configurar ambiente (Eclipse, Java 21, PostgreSQL, Git); Iniciar DER; Preencher Readme.md (6. Materiais e Métodos); Planejar Sprint 3.                                                                                                           | 17     | Ambiente pronto, DER iniciado, Readme.md atualizado, Sprint 3 planejado.                                          |
| Sprint 3 | 05/05/2025 - 18/05/2025 | Criar telas e APIs do usuário; Finalizar DER; Implementar banco de dados; Atualizar Readme.md; Planejar Sprint 4; Preparar slides para Semana de Tecnologia.                                                                                     | 18     | Telas e APIs do usuário prontas, DER e banco implementados, Readme.md atualizado, Sprint 4 planejado.             |
| Sprint 4 | 19/05/2025 - 01/06/2025 | Criar telas e APIs do administrador; Codificar MVP; Preparar banner para Fenetec; Ajustes finais; Testes iniciais; Atualizar Readme.md (7, 8, 9); Form Reação; Planejar Sprint 5; Adicionar MVP ao LinkedIn; Apresentar na Semana de Tecnologia. | 21     | Telas e APIs do admin prontas, MVP codificado, banner pronto, testes feitos, Readme.md atualizado, MVP divulgado. |
| Sprint 5 | 02/06/2025 - 15/06/2025 | Testes finais do MVP; Participar da Fenetec 2025.1; Atualizar Readme.md (10c. Fenetec); Finalizar documentação; Codar ajustes finais; Planejar entregas finais.                                                                                  | 19     | MVP testado, Fenetec concluída, documentação e Readme.md finalizados, ajustes prontos, entregas planejadas.       |


## 6. Materiais e Métodos

### Tecnologias Utilizadas

| Tecnologia  | Categoria           | Descrição                                       |
| ----------- | ------------------- | ----------------------------------------------- |
| Figma       | Design/Modelagem    | Protótipos e MER                                |
| Freepik     | Recursos Visuais    | Imagens para interfaces e banner                |
| Bootstrap   | Biblioteca Frontend | Estilização responsiva de formulários e tabelas |
| Spring Boot | Backend             | API REST, controle de usuários e chamados       |
| PostgreSQL  | Banco de Dados      | Persistência dos dados                          |
| pgAdmin     | Gerenciador BD      | Acesso e manipulação do banco PostgreSQL        |

## 7. Resultados

### 7.1. Tela de Início
![Tela de Início](img/Home.jpg)
> Página inicial do sistema com acesso rápido às funcionalidades principais.

---

### 7.2. Tela de Login
![Tela de Login](img/tela_de_login.jpg)
> Interface de autenticação para acesso seguro ao sistema.

---

### 7.3. Tela de Abertura de Requisição
![Tela de Abertura de Requisição](img/tele_abertura_chamado.jpg)
> Formulário para abrir uma nova requisição de serviço.

---

### 7.4. Tela "Olha Minhas Orden"
![Tela Olha Minhas Orden](img/minhas_ordens.jpg)
> Tela para acompanhar e visualizar todas as requisições feitas pelo usuário.

---

### 7.5. Central de Requisições
![Central de Requisições](img/central-requisições.jpg)
> Tela principal para gerenciamento das requisições em andamento.


## 8. Conclusão

> \[Descrever o impacto positivo do sistema e melhorias futuras previstas.]

## 9. Homologação do MVP

> \[Inserir fotos, legendas e lista de presença.]

## 10. Divulgação

### LinkedIn

> \[Inserir link e print do perfil do projeto no LinkedIn.]

### Seminário de Projetos de Software

> \[Inserir link do vídeo da apresentação e fotos do evento.]

### FENETEC

> \[Inserir link do vídeo da apresentação na feira e fotos do evento.]

## 11. Carta de Apresentação

> \[Inserir a carta conforme no documento.]

## 12. Carta de Autorização

> \[Inserir versão preenchida da carta de autorização.]

## 13. Relato Individual do Processo

> \[Cada integrante deve inserir um breve relato pessoal.]

---

Se quiser, posso gerar esse `README.md` em formato de arquivo para você baixar. Deseja que eu faça isso?
