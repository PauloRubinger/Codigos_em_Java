package activity8;

public class Lista {

    private Jogador[] lista;
    private int primeiro;
    private int ultimo;
    private int tamanho;

    public Lista() {

    }

    public Lista(int tamanho) {

        lista = new Jogador[tamanho];
        primeiro = 0;
        ultimo = 0;
        tamanho = 0;
    }

    public boolean listaVazia() {

        if (primeiro == ultimo) {
            return true;
        } else {
            return false;
        }
    }

    public boolean listaCheia() {

        if (ultimo == lista.length) {
            return true;
        } else {
            return false;
        }
    }

    public void inserirInicio(Jogador jogador) {

        if (listaCheia() == false) {
            for (int i = ultimo; i > 0; i--) {
                lista[i] = lista[i - 1];
            }
            lista[0] = jogador;
        }
        ultimo++;
        tamanho++;
    }

    public void inserir(Jogador jogador, int posicao) throws Exception{

        if (listaCheia() == false) {
            if (posicao >= 0 && posicao <= tamanho) {
                for (int i = ultimo; i > posicao; i--) {
                        lista[i] = lista[i - 1];
                    }
                lista[posicao] = jogador;
                ultimo++;
                tamanho++;
            } else {
                throw new Exception("Não foi possível inserir o elemento na lista: a posição informada é inválida!");
            }
        } else {
            throw new Exception("Não foi possível inserir o elemento na lista: a lista está cheia!");
        }
    }
    

}