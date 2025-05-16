# Jogo Sudoku em Java

Este é um jogo de Sudoku implementado em Java com interface gráfica usando Swing, seguindo princípios de Orientação a Objetos.

## Estrutura do Projeto

O projeto está organizado em várias classes, cada uma com sua responsabilidade específica:

- `Cell.java`: Representa uma célula individual do Sudoku
- `Board.java`: Gerencia o tabuleiro e suas regras
- `SudokuGenerator.java`: Responsável por gerar novos puzzles
- `SudokuUI.java`: Gerencia a interface gráfica e interações do usuário

## Requisitos

- Java Development Kit (JDK) 8 ou superior
- Um ambiente de desenvolvimento Java (como VS Code, Eclipse, IntelliJ) ou linha de comando

## Como Executar

1. Compile todos os arquivos Java:
```bash
javac src/*.java
```

2. Execute o jogo:
```bash
java -cp src SudokuUI
```

## Como Jogar

1. O jogo inicia automaticamente com um novo puzzle
2. Digite números de 1 a 9 nas células vazias
3. As células em cinza são as iniciais e não podem ser modificadas
4. Use os botões na parte inferior:
   - "Novo Jogo": Inicia um novo puzzle
   - "Verificar": Verifica se sua solução está correta
   - "Resolver": Mostra a solução completa

## Regras do Sudoku

1. Cada linha deve conter os números de 1 a 9 sem repetição
2. Cada coluna deve conter os números de 1 a 9 sem repetição
3. Cada bloco 3x3 deve conter os números de 1 a 9 sem repetição

## Dicas

- Use o mouse ou Tab para navegar entre as células
- Digite apenas números de 1 a 9
- Células em vermelho indicam números incorretos após verificação
- Use "Verificar" frequentemente para saber se está no caminho certo

## Características da Implementação

- Orientação a Objetos com separação clara de responsabilidades
- Interface gráfica intuitiva usando Swing
- Geração aleatória de puzzles com solução única
- Validação em tempo real das entradas do usuário
- Feedback visual para células incorretas
- Diferentes níveis de dificuldade ajustáveis
