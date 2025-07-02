# 🎟️ Sistema de Ingressos de Cinema em Java

Este projeto implementa uma hierarquia de classes em Java para representar diferentes tipos de ingressos de cinema: ingresso normal, meia entrada e ingresso família.

## 📌 Objetivo

O objetivo é demonstrar o uso de **herança**, **polimorfismo** e **sobrescrita de métodos** em Java, aplicando regras específicas de cálculo do valor dos ingressos.

---

## 🧱 Estrutura de Classes

### 🧾 `Ingresso`
Classe base que contém:
- Valor base do ingresso
- Nome do filme
- Tipo de áudio (`Dublado` ou `Legendado`)
- Método `getValorReal()` que retorna o valor do ingresso
- Método `exibirDetalhes()` para imprimir informações

### 🎫 `MeiaEntrada`
Herdeira de `Ingresso`, sobrescreve `getValorReal()` para retornar **metade do valor original**.

### 👨‍👩‍👧‍👦 `IngressoFamilia`
Herdeira de `Ingresso`, adiciona:
- Número de pessoas
- Cálculo de valor total multiplicado pelo número de pessoas
- Aplica **5% de desconto** se houver mais de 3 pessoas

---

## ✅ Exemplo de Uso

```java
public class Main {
    public static void main(String[] args) {
        Ingresso normal = new Ingresso(20.0, "Matrix", "Legendado");
        MeiaEntrada meia = new MeiaEntrada(20.0, "Matrix", "Legendado");
        IngressoFamilia familia = new IngressoFamilia(20.0, "Matrix", "Legendado", 4);

        normal.exibirDetalhes();
        meia.exibirDetalhes();
        familia.exibirDetalhes();
    }
}
```

[GITHUB EXERCICIO](https://github.com/danilodhm/Aula02-Java-bootCamp-Santander/blob/exercicio-funcao-relogio/FuncoesRelogio/README.md)