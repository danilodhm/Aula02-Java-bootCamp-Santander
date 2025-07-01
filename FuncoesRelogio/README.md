# Sistema de Relógios Internacionais em Java

Este projeto implementa uma **hierarquia de classes em Java** para representar relógios de diferentes regiões do mundo. Ele segue princípios básicos de **POO (Programação Orientada a Objetos)** com o uso de herança, encapsulamento e polimorfismo.

## Objetivo

Criar uma estrutura reutilizável de relógios que permita representar diferentes formatos de exibição de hora (por exemplo, formato brasileiro 24h e formato americano 12h), respeitando as regras do funcionamento real de um relógio.

---

## Hierarquia de Classes

### 🔹 `Relogio` (Classe Pai - Abstrata)

Essa é a classe base que representa um relógio genérico. Contém:

- **Atributos privados**:
  - `hora` (0 a 23)
  - `minuto` (0 a 59)
  - `segundo` (0 a 59)

- **Métodos públicos**:
  - Getters e setters com validação dos valores (ex: não permite hora > 23, minuto > 59, etc.)
  - `getHoraCompleta()` → Retorna a hora formatada no padrão `HH:MM:SS`
  - Método **abstrato**: `ajustarHorario(Relogio outroRelogio)` → Deverá ser implementado pelas classes filhas, e será responsável por ajustar a hora de um relógio a partir de outro relógio qualquer.

---

### 🔹 `RelogioBrasileiro` (Extende `Relogio`)

- Utiliza o formato **24 horas**
- Implementa o método `ajustarHorario` para copiar a hora, minuto e segundo de outro relógio.
- Exibe a hora normalmente como `HH:MM:SS` no padrão brasileiro.

---

### 🔹 `RelogioAmericano` (Extende `Relogio`)

- Utiliza o formato **12 horas** (AM/PM)
- O método `getHoraCompleta()` exibe as horas no formato: `HH:MM:SS AM/PM`
- O método `ajustarHorario` também ajusta a hora com base em outro relógio, mantendo a lógica de 12 horas.

---

## Exemplo de Uso

```java
Clock brlclock = new BRClock();
brlclock.setSecond(00);
brlclock.setMinute(00);
brlclock.setHour(14);

System.out.println(brlclock.getTime());

System.out.println(new USClock().convert(brlclock).getTime());
```


[GITHUB](https://github.com/digitalinnovationone/exercicios-java-basico/blob/main/exercicios/4%20-%20Heran%C3%A7a%20e%20Polimorfismo%20em%20Java%20.md)