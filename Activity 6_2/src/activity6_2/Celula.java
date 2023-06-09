package activity6_2;

public class Celula {

    private Jogador itens;
    private Celula proximo;

    public Celula(Jogador novo) {
        itens = novo;
        proximo = null;
    }

    public Celula() {
        itens = new Jogador();
        proximo = null;
    }

    public Jogador getItens() {
        return itens;
    }

    public void setItens(Jogador itens) {
        this.itens = itens;
    }

    public Celula getProximo() {
        return proximo;
    }

    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }
}