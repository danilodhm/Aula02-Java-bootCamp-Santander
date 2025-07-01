# ⏰ Sistema de Relógios Internacionais em Java

Este projeto implementa uma hierarquia de classes para representar diferentes tipos de relógios (por exemplo, brasileiro e americano), respeitando suas regras específicas de formatação de hora.

## 🧱 Estrutura do Projeto

### 🔹 Classe Abstrata: `Clock`

A classe base `Clock` representa um relógio genérico. Ela define os atributos e métodos essenciais:

#### Atributos:
- `hour` (int): valor de 0 a 23
- `minute` (int): valor de 0 a 59
- `second` (int): valor de 0 a 59

#### Métodos:
- `setHour(int hour)`: define a hora (com validação)
- `setMinute(int minute)`: define os minutos (com validação)
- `setSecond(int second)`: define os segundos (com validação)
- `getTime()`: retorna a hora formatada como `HH:MM:SS` (formato a ser implementado pela subclasse)
- `Clock convert(Clock other)`: método **abstrato** — cada classe filha define como converter outro relógio para si mesma

---

### 🔹 `BRClock` (Relógio Brasileiro)

- Formato: **24 horas**
- Implementação do método `getTime()` no formato `HH:MM:SS`
- O método `convert(Clock other)` copia os valores de hora, minuto e segundo do relógio recebido.

---

### 🔹 `USClock` (Relógio Americano)

- Formato: **12 horas com AM/PM**
- Implementa `getTime()` retornando a hora no formato `HH:MM:SS AM/PM`
- O método `convert(Clock other)` também copia os valores de hora, minuto e segundo, mas exibe no formato de 12 horas.

---

## 📦 Exemplo de Uso

```java
Clock brlclock = new BRClock();
brlclock.setSecond(00);
brlclock.setMinute(00);
brlclock.setHour(14);

System.out.println(brlclock.getTime());                    // 14:00:00
System.out.println(new USClock().convert(brlclock).getTime());  // 02:00:00 PM

```


[GITHUB](https://github.com/digitalinnovationone/exercicios-java-basico/blob/main/exercicios/4%20-%20Heran%C3%A7a%20e%20Polimorfismo%20em%20Java%20.md)
