package hashtable1;

public class Celula {
    
    private Jogador item;
    private Celula proximo;

    public Celula() {
        item = new Jogador();
        proximo = null;
    }

    public Celula(Jogador jogador) {
        item = jogador;
        proximo = null;
    }

    public Jogador getItem() {
        return item;
    }

    public void setItem(Jogador jogador) {
        this.item = jogador;
    }

    public Celula getProximo() {
        return proximo;
    }

    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }
}
