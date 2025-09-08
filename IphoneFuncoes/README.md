# Projeto Java - Bootcamp Santander 2025

Este projeto demonstra a aplicação de conceitos fundamentais de Java, como orientação a objetos, interfaces e implementação de serviços, simulando funcionalidades de um smartphone: reprodutor musical, aparelho telefônico e navegador de internet.

## Estrutura do Projeto

- **src/interfaces/**  
  Contém as interfaces que definem os contratos das funcionalidades:
  - [`AparelhoTelefonico.java`](interfaces/AparelhoTelefonico.java): Métodos para realizar e atender chamadas, além de iniciar e encerrar correio de voz.
  - [`ReprodutorMusical.java`](interfaces/ReprodutorMusical.java): Métodos para tocar, pausar e selecionar músicas.
  - [`NavegarInternet.java`](interfaces/NavegarInternet.java): Métodos para exibir páginas, adicionar novas abas e atualizar páginas.

- **src/services/**  
  Implementações das interfaces, simulando o funcionamento dos serviços:
  - [`Telefone.java`](services/Telefone.java): Implementa [`AparelhoTelefonico`](interfaces/AparelhoTelefonico.java).
  - [`Reprodutor.java`](services/Reprodutor.java): Implementa [`ReprodutorMusical`](interfaces/ReprodutorMusical.java).
  - [`NavegadorInternet.java`](services/NavegadorInternet.java): Implementa [`NavegarInternet`](interfaces/NavegarInternet.java).
  - [`Chamadas.java`](services/Chamadas.java): Gerencia chamadas telefônicas.
  - [`Functions.java`](services/Functions.java): Funções utilitárias para integração dos serviços.

- **src/Main.java**  
  Classe principal para execução e testes das funcionalidades.

## Funcionalidades

### Reprodutor Musical

Implementado em [`Reprodutor.java`](services/Reprodutor.java) e definido pela interface [`ReprodutorMusical`](interfaces/ReprodutorMusical.java):

- `tocar()`: Inicia a reprodução de uma música.
- `pausar()`: Pausa a música em execução.
- `selecionarMusica(String musica)`: Seleciona uma música para tocar.

### Aparelho Telefônico

Implementado em [`Telefone.java`](services/Telefone.java) e definido pela interface [`AparelhoTelefonico`](interfaces/AparelhoTelefonico.java):

- `ligar(String numero)`: Realiza uma chamada para o número informado.
- `atender()`: Atende uma chamada recebida.
- `iniciarCorreioVoz()`: Inicia o correio de voz.

### Navegador de Internet

O Navegador de internet tem um serviço do JavaFx onde abre o navegador, para acessar o link solicitado.

Implementado em [`NavegadorInternet.java`](services/NavegadorInternet.java) e definido pela interface [`NavegarInternet`](interfaces/NavegarInternet.java):

- `exibirPagina(String url)`: Exibe a página da web informada.
- `adicionarNovaAba()`: Abre uma nova aba no navegador.
- `atualizarPagina()`: Atualiza a página atual.

## Como Executar

1. Compile os arquivos Java:
   ```sh
   javac src/Main.java

   ```
   

   
[GITHUB EXERCICIO](https://github.com/digitalinnovationone/trilha-java-basico/tree/main/desafios/poo)
