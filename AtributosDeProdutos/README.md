# 🧾 Calculadora de Tributos de Produtos

Este projeto tem como objetivo calcular o valor dos tributos de produtos com base em seu tipo. A estrutura utiliza os princípios de Programação Orientada a Objetos (POO) com foco na extensibilidade e reutilização de código.

## ✅ Tipos de Produtos e Percentual de Tributo

Cada produto possui um método que retorna o valor do imposto baseado no tipo:

| Tipo de Produto         | Percentual de Tributo |
|-------------------------|------------------------|
| Alimentação             | 1%                    |
| Saúde e Bem-Estar       | 1.5%                  |
| Vestuário               | 2.5%                  |
| Cultura                 | 4%                    |

## 🧠 Estrutura do Código

O código define uma classe interface `Produto` com um método abstrato para cálculo de imposto `calculo()`, que é sobrescrito por class record específicas de cada tipo de produto.


[GITHUB EXERCICIO 2](https://github.com/digitalinnovationone/exercicios-java-basico/blob/main/exercicios/5%20-%20Dominando%20Interfaces%20e%20Lambda%20em%20Java.md)