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
        this.tamanho = tamanho;
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

}