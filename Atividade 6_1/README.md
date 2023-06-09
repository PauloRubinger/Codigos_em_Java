1. Fila circular implementada por meio de vetor

Utilize a classe Jogador especificada e desenvolvida em prática anterior.
Crie uma fila circular, implementada por meio de vetor, de objetos da classe
Jogador. Essa fila deve conseguir armazenar simultaneamente até cinco
jogadores. Ou seja, essa fila deve apresentar cinco posições úteis. Neste
exercício, faremos enfileiramentos e desenfileiramentos de itens na fila.
Os métodos de sua fila circular devem operar conforme descrito a seguir,
respeitando-se parâmetros e tipos de retorno:
• Sua classe Fila deverá ter dois construtores.
• void enfileirar (Jogador jogador): enfileira um objeto do tipo Jogador.
• Jogador desenfileirar (): desenfileira e retorna o jogador da frente da
fila.
• void mostrar (): para todos os objetos do tipo Jogador presentes na fila,
exibe a posição do objeto na fila seguida dos valores de seus atributos
(observe o formato de cada linha da saída esperada).
• double obterMediaAltura (): calcula e retorna a média das alturas dos
jogadores presentes na fila.

Seu programa deve ler um arquivo-texto chamado jogadores.txt que, no
VERDE, localiza-se na pasta /tmp. Você deve preencher um vetor de objetos
da classe Jogador com os dados dos diversos jogadores da NBA informados
nesse arquivo. Atenção para os dados de entrada, pois em alguns registros
faltam valores e esses devem ser substituídos pela string “nao informado”, na
saída padrão.

Cada uma das linhas presentes no arquivo indica os dados de um jogador,
separados pelo símbolo ‘,’. Esses dados são, nessa ordem:
- id do jogador;
- nome do jogador;
- sua altura;
- seu peso;
- universidade que o jogador representa;
- ano de nascimento do jogador;
- nome da cidade em que o jogador nasceu;
- estado em que o jogador nasceu.

Depois, seu programa deve processar a entrada padrão, que é dividida em duas
partes. A primeira contém, em cada linha, uma string indicando o id do
jogador que deve ser inicialmente enfileirado na fila de jogadores, na ordem
em que são apresentados.

Após a palavra FIM, inicia-se a segunda parte da entrada padrão.
A primeira linha dessa segunda parte da entrada padrão apresenta um
número inteiro n indicando a quantidade de jogadores que serão em
seguida enfileirados ou desenfileirados. Nas próximas n linhas, tem-se n
comandos de enfileiramento ou desenfileiramento que devem ser
processados neste exercício. Cada uma dessas linhas tem uma palavra de
comando, conforme descrito a seguir:
• I: enfileirar;
• R: desenfileirar.

No caso dos comandos de enfileiramento, temos também uma string indicando
o id do jogador que deve ser enfileirado na fila de jogadores.
Observe que, quando, no momento de execução da operação enfileirar, a fila
estiver cheia, antes de enfileirar um jogador será necessário desenfileirar outro.
A saída padrão será um número inteiro correspondente à média
arredondada das alturas dos jogadores presentes na fila, após cada
enfileiramento.

Além disso, a saída padrão também apresenta uma linha para cada jogador
desenfileirado (apenas para os jogadores que foram desenfileirados por meio
do processamento do comando “R”), sendo que essa informação será constituída
pela string “(R)” seguida do nome desse jogador.

Em seguida, teremos, ainda na saída padrão, os atributos relativos aos jogadores
armazenados na fila após o processamento de todas as operações de
enfileiramento e desenfileiramento (observe o formato de cada linha da
saída esperada).