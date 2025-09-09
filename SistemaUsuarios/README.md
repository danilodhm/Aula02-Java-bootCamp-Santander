[GITHUB EXERCICIO BASE](https://github.com/digitalinnovationone/exercicios-java-basico/blob/main/exercicios/4%20-%20Heran%C3%A7a%20e%20Polimorfismo%20em%20Java%20.md)

# Sistema de Usuários - Hierarquia de Classes

Este projeto implementa um sistema de usuários com diferentes tipos de perfis, utilizando uma hierarquia de classes para Gerente, Vendedor e Atendente. Cada tipo de usuário possui atributos e métodos específicos, conforme os requisitos do sistema.

## Hierarquia de Usuários

### Classe Base: Usuario

- **Atributos**:
  - Nome
  - Login
  - Email
  - Senha
  - isCargo (define o tipo/cargo do usuário)
- **Métodos**:
  - Getters e setters para os atributos
  - Métodos para login e alteração de dados

Implementação: [`models.users.Usuario`](src/models/users/Usuario.java)

---

### Gerente

- **Atributos**:
  - Nome
  - Email
  - Senha
  - isCargo (sempre "GERENTE", equivalente a "administrador" verdadeiro)
- **Métodos**:
  - Gerar relatório financeiro ([`models.ControleDeVendas.GerarRelatorioFinanceiro`](src/models/ControleDeVendas.java))
  - Consultar vendas ([`models.ControleDeVendas.ConsultarVendas`](src/models/ControleDeVendas.java))
  - Realizar login ([`services.Login.logar`](src/services/Login.java))
  - Realizar logoff ([`services.Login.Logoff`](src/services/Login.java))
  - Alterar dados ([`services.EditarPerfil.MenuEditarPerfil`](src/services/EditarPerfil.java))
  - Alterar senha ([`services.EditarPerfil.MenuEditarPerfil`](src/services/EditarPerfil.java))
  - Alterar cargo de outros usuários ([`models.users.Gerente.AlterarCargo`](src/models/users/Gerente.java))

Implementação: [`models.users.Gerente`](src/models/users/Gerente.java)

---

### Vendedor

- **Atributos**:
  - Nome
  - Email
  - Senha
  - isCargo (sempre "VENDEDOR", equivalente a "administrador" falso)
  - Quantidade de vendas (calculado a partir dos produtos vendidos)
- **Métodos**:
  - Realizar venda ([`models.users.Vendedor.Vender`](src/models/users/Vendedor.java)) (incrementa o número de vendas)
  - Consultar vendas ([`models.users.Vendedor.MyVendas`](src/models/users/Vendedor.java))
  - Realizar login ([`services.Login.logar`](src/services/Login.java))
  - Realizar logoff ([`services.Login.Logoff`](src/services/Login.java))
  - Alterar dados ([`services.EditarPerfil.MenuEditarPerfil`](src/services/EditarPerfil.java))
  - Alterar senha ([`services.EditarPerfil.MenuEditarPerfil`](src/services/EditarPerfil.java))

Implementação: [`models.users.Vendedor`](src/models/users/Vendedor.java)

---

### Atendente

- **Atributos**:
  - Nome
  - Email
  - Senha
  - isCargo (sempre "ATENDENTE", equivalente a "administrador" falso)
  - Valor em caixa (controlado por métodos estáticos)
- **Métodos**:
  - Receber pagamentos ([`models.users.Atendente.ReceberPagamento`](src/models/users/Atendente.java)) (exibe e incrementa o valor em caixa)
  - Fechar o caixa ([`models.users.Atendente.FecharCaixa`](src/models/users/Atendente.java))
  - Abrir o caixa ([`models.users.Atendente.AbrirCaixa`](src/models/users/Atendente.java))
  - Realizar login ([`services.Login.logar`](src/services/Login.java))
  - Realizar logoff ([`services.Login.Logoff`](src/services/Login.java))
  - Alterar dados ([`services.EditarPerfil.MenuEditarPerfil`](src/services/EditarPerfil.java))
  - Alterar senha ([`services.EditarPerfil.MenuEditarPerfil`](src/services/EditarPerfil.java))

Implementação: [`models.users.Atendente`](src/models/users/Atendente.java)

---

## Estrutura do Projeto

- [`src/models/users/Usuario.java`](src/models/users/Usuario.java): Classe base para todos os usuários.
- [`src/models/users/Gerente.java`](src/models/users/Gerente.java): Implementação do Gerente.
- [`src/models/users/Vendedor.java`](src/models/users/Vendedor.java): Implementação do Vendedor.
- [`src/models/users/Atendente.java`](src/models/users/Atendente.java): Implementação do Atendente.
- [`src/services/EditarPerfil.java`](src/services/EditarPerfil.java): Métodos para alteração de dados e senha.
- [`src/services/Login.java`](src/services/Login.java): Métodos de login e logoff.
- [`src/models/ControleDeVendas.java`](src/models/ControleDeVendas.java): Métodos de relatório financeiro e consulta de vendas.
- [`src/models/Produto.java`](src/models/Produto.java): Produtos vendidos e controle de vendas.

## Como Executar

1. Compile o projeto Java.
2. Execute a classe principal [`App`](src/App.java).
3. Siga as instruções no menu para acessar as funcionalidades de cada tipo de usuário.

---

## Observações

- O atributo "administrador" é representado pelo campo `isCargo` nas classes de usuário.
- O sistema utiliza listas estáticas para armazenar usuários e produtos.
- Métodos de alteração de dados e senha estão centralizados em [`services.EditarPerfil`](src/services/EditarPerfil.java).
- O valor em caixa do Atendente é controlado por métodos estáticos e o status do caixa.



