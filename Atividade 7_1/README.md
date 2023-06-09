1. Pilha implementada por meio de vetor

Utilize a classe Jogador especificada e desenvolvida em prática anterior.
Crie uma pilha, implementada por meio de vetor, de objetos da classe Jogador.
Lembre-se que, na verdade, temos um vetor de referências para objetos do tipo
Jogador.

Neste exercício, faremos inserções e remoções de itens na pilha e, após o
processamento de todas as operações, mostraremos seus elementos.
Os métodos de sua pilha devem operar conforme descrito a seguir, respeitandose parâmetros e tipos de retorno:
• Sua classe Pilha deverá ter dois construtores.
• void empilhar (Jogador jogador): empilha um objeto do tipo Jogador.
• Jogador desempilhar (): desempilha e retorna o Jogador do topo da
pilha.
• void mostrar (): a partir do fundo da pilha, para todos os objetos do tipo
Jogador presentes na pilha, exibe a posição do objeto na pilha seguida
dos valores de seus atributos (observe o formato de cada linha da saída
esperada).

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
jogador que deve ser empilhado na pilha de jogadores, na ordem em que são
apresentados.

Após a palavra FIM, inicia-se a segunda parte da entrada padrão.
A primeira linha dessa segunda parte da entrada padrão apresenta um
número inteiro n indicando a quantidade de jogadores que serão em
seguida empilhados ou desempilhados. Nas próximas n linhas, tem-se n
comandos de empilhamento ou desempilhamento que devem ser
processados neste exercício. Cada uma dessas linhas tem uma palavra de
comando, conforme descrito a seguir:
• I: empilhar;
• R: desempilhar.

No caso dos comandos de empilhamento, temos também uma string indicando
o id do jogador que deve ser empilhado na pilha de jogadores.
A saída padrão deve apresentar uma linha para cada jogador
desempilhado, sendo que essa informação será constituída pela string “(R)”
seguida do atributo nome do jogador retirado da pilha.

Em seguida, teremos, ainda na saída padrão, os atributos relativos aos jogadores
presentes na pilha após o processamento de todas as operações de
empilhamento e desempilhamento (observe o formato de cada linha da
saída esperada).