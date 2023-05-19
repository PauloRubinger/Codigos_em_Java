1. Lista duplamente encadeada

Utilize a classe Jogador especificada e desenvolvida em prática anterior.
Crie uma lista duplamente encadeada de objetos da classe Jogador.
Neste exercício, faremos inserções e remoções de itens na lista e, após o
processamento de todas as operações, mostraremos seus elementos.

Os métodos de sua lista duplamente encadeada devem operar conforme descrito
a seguir, respeitando-se parâmetros e tipos de retorno:
• Sua classe ListaDuplamenteEncadeada deverá ter, pelo menos, um
construtor.
• void inserirInicio (Jogador jogador): insere um objeto do tipo Jogador
na primeira posição da lista.
• void inserir (Jogador jogador, int posicao): insere um jogador na posição
da lista indicada pelo parâmetro posicao, desse método; onde 0 <=
posicao <= n, sendo n o número de jogadores já inseridos na estrutura.
• void inserirFim (Jogador jogador): insere um objeto da classe Jogador
na última posição da lista.
• Jogador removerInicio(): remove e retorna o primeiro jogador da lista.
• Jogador remover(int posicao): remove e retorna o objeto Jogador
armazenado na posição da lista indicada pelo parâmetro posicao, desse
método; onde 0 <= posicao < n, sendo n o número de jogadores já
inseridos na estrutura.
• Jogador removerFim(): remove e retorna o último Jogador da lista.
• void mostrar (): para todos os objetos do tipo Jogador presentes na
lista, exibe a posição do objeto na lista seguida dos valores de seus
atributos (observe o formato de cada linha da saída esperada).

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
jogador que deve ser inserido no final da lista de jogadores, na ordem em que
são apresentados.

Após a palavra FIM, inicia-se a segunda parte da entrada padrão.
A primeira linha dessa segunda parte da entrada padrão apresenta um
número inteiro n indicando a quantidade de jogadores que serão em
seguida inseridos ou removidos da lista. Nas próximas n linhas, tem-se n
comandos de inserção ou remoção que devem ser processados neste
exercício. Cada uma dessas linhas tem uma palavra de comando, conforme
descrito a seguir:
• II: inserir no início;
• I* inserir em uma determinada posição;
• IF: inserir no final;
• RI: remover do início;
• R*: remover de uma determinada posição; e
• RF: remover do final.

No caso dos comandos de inserção, temos também uma string indicando o id
do jogador que deve ser inserido na lista de jogadores.
No caso dos comandos de inserção e remoção “em uma determinada
posição”, temos também um inteiro indicando essa posição. No comando de
inserção, a posição fica imediatamente após a palavra de comando. Lembre-se
que o primeiro item da lista encontra-se na posição 0.

A saída padrão deve apresentar uma linha para cada jogador removido,
sendo que essa informação será constituída pela string “(R)” seguida do atributo
nome do jogador retirado da lista.
Em seguida, teremos, ainda na saída padrão, os atributos relativos aos jogadores
presentes na lista duplamente encadeada após o processamento de
todas as operações de inserção e remoção (observe o formato de cada
linha da saída esperada).