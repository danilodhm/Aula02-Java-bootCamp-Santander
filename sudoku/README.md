# Sudoku Console Game

## Descrição
Este projeto implementa um **Sudoku** jogável no console em Java, utilizando uma arquitetura modular que separa a lógica do jogo, a representação do tabuleiro e a interface do usuário.  

O jogo permite iniciar um Sudoku, inserir ou remover números, visualizar o tabuleiro, verificar status e finalizar a partida.

---

## Estrutura do Projeto



br.com.dio
│
├── Main.java              # Interface do usuário e fluxo principal do jogo
├── util/
│   └── BoardTemplate.java # Template visual do tabuleiro
└── model/
    ├── Board.java         # Lógica do tabuleiro e manipulação das células
    ├── Space.java         # Representação de cada célula
    └── GameStatusEnum.java # Enum com status do jogo



---

## Funcionalidades Atuais

### Main.java
- Menu interativo no console com as seguintes opções:
  1. Iniciar um novo jogo
  2. Colocar um número
  3. Remover um número
  4. Visualizar o jogo atual
  5. Verificar status do jogo
  6. Limpar o tabuleiro
  7. Finalizar o jogo
  8. Sair do programa
- Validação básica de entrada (0–8 para linhas/colunas, 1–9 para valores)
- Controle de células fixas e editáveis

### Board.java
- Representa o tabuleiro como `List<List<Space>>`
- Métodos:
  - `getStatus()` → retorna `NON_STARTED`, `INCOMPLETE` ou `COMPLETE`
  - `hasErrors()` → indica se há erros comparando valores inseridos com os esperados
  - `changeValue()` e `clearValue()` → manipulam células editáveis
  - `reset()` → limpa todas as células (atualmente limpa também as fixas)
  - `gameIsFinished()` → verifica se o jogo foi completado corretamente

### Space.java
- Representa cada célula do Sudoku
- Campos:
  - `expected` → valor correto
  - `actual` → valor inserido pelo jogador (`null` se vazio)
  - `fixed` → se a célula é inicial/fixa
- Impede alteração de células fixas

### GameStatusEnum.java
- Enum com status do jogo:
  - `NON_STARTED` → não iniciado
  - `INCOMPLETE` → em andamento
  - `COMPLETE` → concluído
- Cada estado possui um label em português

### BoardTemplate.java
- Template de exibição do tabuleiro no console
- Usa placeholders `%s` para preencher 81 células
- Visual do tabuleiro dividido em blocos 3x3

---

## Pontos Positivos

- Código modular e organizado
- Uso de abstrações (`Board` e `Space`) facilita manutenção
- Menu funcional e direto
- Tabuleiro visualmente estruturado no console

---

## Melhorias Sugeridas

### Robustez e Segurança
- Tratar entradas inválidas (atualmente `scanner.nextInt()` quebra o programa se digitar letras)
- Validar índices antes de acessar `List` para evitar `IndexOutOfBoundsException`

### Refatoração e Legibilidade
- Criar constante `BOARD_SIZE` em vez de usar `9` em vários locais
- Evitar repetição de checagem de null para `board` (ex.: criar `checkBoardInitialized()`)
- Modularizar `BoardTemplate` para facilitar manutenção

### Jogabilidade
- Diferenciar valores fixos e inseridos com cores (ANSI)
- Mensagens mais amigáveis no console
- Adicionar sugestões de jogadas, dicas limitadas e pontuação
- Implementar temporizador
- Salvar e carregar progresso do jogo
- Validar regras reais do Sudoku (linhas, colunas e blocos 3x3)

---

## Próximos Passos

1. Refatorar `Main.java` para entrada robusta e melhor UX  
2. Ajustar `Board.reset()` para preservar valores fixos  
3. Otimizar `getStatus()` em `Board.java`  
4. Refatorar `BoardTemplate` para modularidade  
5. Adicionar novos recursos de jogabilidade (dicas, pontuação, temporizador, validação completa de Sudoku)  

---

## Execução

Para executar o jogo:

1. Compile todos os arquivos Java:
```bash
javac -d out src/br/com/dio/**/*.java
```

2. Execute a classe principal:

```bash
java -cp out br.com.dio.Mai
```


