# 📘 README – Sistema Bancário em Java

## 🏦 Sobre o Projeto
Este é um sistema bancário simples feito em **Java**, com foco em **orientação a objetos (POO)**.  
Ele simula clientes, contas, operações financeiras e relatórios de um banco.  

O projeto é ideal para estudo de **herança, polimorfismo, abstração e encapsulamento**.

---

## ⚙️ Estrutura do Projeto
O sistema contém as seguintes classes:

- **Banco.java** → Gerencia contas e clientes (adicionar, remover, procurar e relatórios).
- **Cliente.java** → Representa um cliente do banco.
- **Conta.java** → Classe abstrata para contas (contém lógica comum).
- **ContaCorrente.java** → Conta com limite de saque diário.
- **ContaPoupanca.java** → Conta com rendimento automático (juros).
- **IConta.java** → Interface que define operações básicas (sacar, depositar, transferir, extrato).
- **Transacao.java** → Representa cada movimentação financeira (depósito, saque, transferência, rendimento).
- **Main.java** → Classe principal com **menu interativo** para simular operações no banco.

---

## 🚀 Funcionalidades
✔ Criar cliente com **Conta Corrente** ou **Conta Poupança**  
✔ Depositar em uma conta  
✔ Sacar dinheiro (respeitando limite da Conta Corrente)  
✔ Transferir entre contas  
✔ Gerar extrato detalhado com histórico de transações  
✔ Aplicar rendimento automático na Poupança  
✔ Relatório geral do banco (todas as contas + saldo total)  
✔ **Menu interativo (console)** para navegar no sistema  

---

## 📂 Estrutura de Pastas
/src
├── Banco.java
├── Cliente.java
├── Conta.java
├── ContaCorrente.java
├── ContaPoupanca.java
├── IConta.java
├── Transacao.java
└── Main.java



---

## 🖥️ Como Executar
1. Compile os arquivos `.java`:
   ```sh
   javac *.java
2. Execute a classe `Main`:
   ```sh
   java Main


## === MENU BANCO Banco GPT ===
1. Criar Cliente e Conta Corrente
2. Criar Cliente e Conta Poupança
...
Escolha: 1
Nome do cliente: Ana
Conta adicionada: Ana Nº 1
