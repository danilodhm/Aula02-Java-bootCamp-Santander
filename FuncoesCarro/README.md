# 🚗 Simulador de Carro em Java

Este projeto implementa um simulador de carro em Java com diversas funções básicas de um veículo.  
O código possui um menu interativo para controlar o carro e realizar as operações disponíveis.

---

## 🎮 Funcionalidades

O carro pode realizar as seguintes operações:

- ✅ Ligar o carro
- ✅ Desligar o carro
- ✅ Acelerar
- ✅ Diminuir a velocidade
- ✅ Virar para esquerda ou direita
- ✅ Verificar velocidade atual
- ✅ Trocar a marcha

---

## ⚙ Regras do funcionamento

- O carro **inicia desligado**, em ponto morto (**marcha 0**) e com **velocidade 0 km/h**.
- Com o carro desligado **nenhuma função além de ligar é permitida**.
- **Acelerar:** aumenta a velocidade em 1 km/h (máximo de 120 km/h).
- **Diminuir velocidade:** reduz a velocidade em 1 km/h (mínimo de 0 km/h).
- O carro possui **6 marchas**, e não é permitido **pular marchas** na troca (exemplo: não pode ir da 1ª direto para a 3ª).
- O carro deve respeitar os limites de velocidade por marcha:

| Marcha | Velocidade permitida |
|--------|---------------------|
| 0 (ponto morto) | 0 km/h (não pode acelerar) |
| 1ª marcha | 0 km/h até 20 km/h |
| 2ª marcha | 21 km/h até 40 km/h |
| 3ª marcha | 41 km/h até 60 km/h |
| 4ª marcha | 61 km/h até 80 km/h |
| 5ª marcha | 81 km/h até 100 km/h |
| 6ª marcha | 101 km/h até 120 km/h |

- **Virar para esquerda/direita:** só é permitido se a velocidade estiver entre **1 km/h e 40 km/h**.
- **Desligar o carro:** só pode ser feito se estiver em ponto morto (**marcha 0**) e com **velocidade 0 km/h**.

---

## 🚀 Como rodar o projeto

1️⃣ Compile o arquivo:
```bash
javac Main.java

```

## Link do exercicio

[GITHUB](https://github.com/digitalinnovationone/exercicios-java-basico/blob/main/exercicios/3%20-%20Java%20e%20a%20Arte%20da%20Abstra%C3%A7%C3%A3o%20com%20Classes%20e%20Encapsulamento.md)