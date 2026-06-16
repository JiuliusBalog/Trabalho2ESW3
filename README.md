Este foi o nosso segundo trabalho em grupo na disciplina de Engenharia de Software 3, nele, criamos um sistema de Jogo da Velha utilizando Java, além da categorização BCE para uma melhor representação das responsabilidades no sistema.

Categorização BCE é um padrão arquitetural que divide todas as classes do sistema em 3 categorias
- Boundary: que são as classes que interagem diretamente com o usuário;
- Control: que são as classes que processam as requisições feitas pela Boundary;
- Entity: que são classes que carregam as regras de negócio e servem para armazenar informações.

Temos as seguintes classes com suas respectivas ações:

JogoUI (Boundary)
Essa classe representa a Boundary, e como tal, ela realiza ações como: a captura do nome de ambos os jogadores, suas respectivas peças, suas jogadas no tabuleiro, além de mostrar o próprio tabuleiro em si, mostrando onde cada peça está posicionada e os possíveis locais livres.

JogoUC
Essa classe representa a Control, essa classe é como se fosse o cérebro do sistema, ela verifica grande parte das leituras da UI, se uma jogada é válida tendo em vista sua posição, verifica se a peça escolhida pelo usuário é X ou O e não algum outro caractére, verifica se algum dos jogadores já ganhou a partida tendo em vista a posição das peças e etc. Além disso, essa classe determina o início, o fim, e se for da vontade dos jogadores, o recomeço, onde todos os parâmetros são zerados e uma nova partida é iniciada.

As 3 classes a seguir são classes que representam a Entity, que são:

Jogador
Utilizada para guardar o nome e a peça de determinado jogador

Peça
Utilizada para guardar o símbolo da peça, no caso, X ou O

Tabuleiro
Utilizada para guardar as posições do próprio tabuleiro em si, além de "limpar" a mesa ao final de cada partida

Por fim, temos uma última classe chamada Main, ela é uma classe diferente, tendo em vista que ela tem como função, carregar o Loop principal para do jogo, ou seja, ela é quem define a ordem das coisas, quando ocorre a leitura dos jogadores, quando ocorre a leitura das peças, além do próprio gerenciamento do jogo (exemplo: se a Control descobrir que a partida acabou, seja porquê todos os espaços foram ocupados ou porquê houve um vencedor, ele muda o Status do jogo de "EmAndamento" para "Vitória" ou "Empate" encerrando o loop na Main).
