1. Tabela hash com endereçamento em separado

Utilize a classe Jogador especificada e desenvolvida em prática anterior.
Crie uma tabela hash com endereçamento em separado. Em seguida, faça
a inserção dos registros correspondentes a alguns jogadores conforme a entrada
padrão. A chave de pesquisa será a altura do jogador. Por fim, pesquise se
alguns registros estão cadastrados na tabela hash, mostrando suas respectivas
posições nessa tabela (endereços efetivos).

A função de transformação que deve ser aplicada é: ((altura do jogador) mod
tamanho da tabela hash), onde o tamanho da tabela hash é 37.

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
jogador que deve ser inserido na tabela hash, na ordem em que são
apresentados.

Após a palavra FIM, inicia-se a segunda parte da entrada padrão, que também é
composta por várias linhas, sendo que cada uma possui uma string indicando o
nome do jogador que deve ser pesquisado na tabela hash. A última linha dessa
parte também terá a palavra FIM.

A saída padrão será composta por várias linhas, uma para cada pesquisa
realizada na tabela hash. Cada linha deve apresentar a posição de cada jogador
procurado na tabela hash (endereço efetivo); e, no final, as palavras SIM ou
NAO, indicando se cada um dos jogadores pesquisados existe ou não na tabela
hash.

Além disso, crie um arquivo de log na pasta corrente com o nome
matrícula_hashSeparado.txt com uma única linha contendo: seu número de
matrícula, tempo de execução de seu algoritmo (em milissegundos) e número de
comparações realizadas durante o processamento das pesquisas. Todas as
informações desse arquivo de log devem ser separadas por uma tabulação ‘\t’.