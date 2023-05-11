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
        
        Jogador temp = lista[0];
        lista[0] = jogador;

        if (listaCheia() == false) {
            for (int i = 0; i < lista.length; i++) {
                
            }
        }
    }

}