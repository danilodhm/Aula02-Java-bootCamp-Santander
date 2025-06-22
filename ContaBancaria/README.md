# 💳 Sistema de Conta Bancária em Java

Este projeto consiste em um programa em Java que simula uma **conta bancária** com um menu interativo para o usuário realizar operações.  

## 📝 Funcionalidades

✅ Consultar saldo da conta  
✅ Consultar limite do cheque especial  
✅ Depositar dinheiro na conta  
✅ Sacar dinheiro (usando o saldo e, se necessário, o cheque especial)  
✅ Pagar boleto (funciona como um saque)  
✅ Verificar se a conta está usando o cheque especial  
✅ Encerrar o programa através do menu  

---

## 📌 Regras do sistema

- A conta bancária possui um saldo e um limite de cheque especial.
- O limite do cheque especial é definido no momento da criação da conta, **com base no valor depositado inicialmente**:
  - Se o valor inicial for **R$ 500,00 ou menos**, o limite do cheque especial será de **R$ 50,00**.
  - Se o valor inicial for **acima de R$ 500,00**, o limite será de **50% do valor depositado**.
- Quando o cheque especial é utilizado, será cobrada uma taxa de **20% sobre o valor usado**, que será debitada assim que houver saldo disponível na conta.

---

## 🚀 Como funciona o menu interativo

Ao executar o programa, será exibido um menu como o exemplo abaixo:

[GITHUB](https://github.com/digitalinnovationone/exercicios-java-basico/blob/main/exercicios/3%20-%20Java%20e%20a%20Arte%20da%20Abstra%C3%A7%C3%A3o%20com%20Classes%20e%20Encapsulamento.md)