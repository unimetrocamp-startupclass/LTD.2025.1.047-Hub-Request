# ReqHub - Sistema de Gerenciamento de Solicitações

Aqui está a versão ajustada do seu texto:  

**Bem-vindo ao ReqHub!** Um sistema de **Help Desk** desenvolvido para otimizar a gestão de solicitações e melhorias dentro da empresa. Com o ReqHub, os usuários podem relatar problemas, sugerir melhorias e acompanhar o status de suas solicitações de forma prática e eficiente, eliminando a necessidade de comunicação por e-mail. O sistema conta com diferentes perfis de usuários, como administradores e atendentes, garantindo funcionalidades específicas para cada necessidade.  

Se precisar de mais ajustes, é só me avisar! 😊
## Funcionalidades

- **Cadastro de Usuários:**
  - Usuários comuns podem se cadastrar fornecendo nome, email, ramal e setor.
  - Administradores têm um cadastro restrito, autenticado por um código de acesso (`******`), e não precisam de email, ramal ou setor (valores padrão são aplicados).

- **Gerenciamento de Ordens:**
  - Criação de ordens (chamados) com descrição e status (ex.: "PENDENTE", "RESOLVIDA").
  - Associação de ordens a usuários específicos.
  - Consulta de ordens abertas para encontrar o usuário responsável.

- **Administração:**
  - Interface para administradores acessarem o sistema via login.
  - Gestão de setores e usuários pelo admin.

- **Frontend:**
  - Interface web com páginas HTML usando Thymeleaf e estilização com Bootstrap.
  - Formulários interativos para cadastro e criação de ordens, enviando dados em formato JSON via AJAX.

## Tecnologias Utilizadas

- **Backend:**
  - Java com Spring Boot
  - Spring Data JPA para persistência de dados
  - Banco de dados PostgreSQL
- **Frontend:**
  - Thymeleaf para renderização de templates
  - Bootstrap 5.3.2 para estilização
  - JavaScript com Fetch API para requisições assíncronas
- **Ferramentas:**
  - Maven para gerenciamento de dependências
  - Git para controle de versão


## Pré-requisitos

- Java 21
- Maven 3.6+
- PostgreSQL 14
- IDE (ex.: Eclipse, IntelliJ) opcional

## Configuração

1. **Clone o repositório:**
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd reqhub ```````



---

### Como usar
- Copie esse texto num arquivo chamado `README.md` na raiz do seu projeto.
- Substitua `<URL_DO_REPOSITORIO>` pelo link real do seu repositório Git, se tiver.
- Ajuste os detalhes (ex.: nome do sistema, funcionalidades específicas) se necessário.


