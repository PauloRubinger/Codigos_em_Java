package activity9;

public class Celula {
    
    private Jogador item;
    private Celula anterior;
    private Celula proximo;

    public Celula() {
        item = new Jogador();
        proximo = null;
        anterior = null;
    }

    public Celula(Jogador jogador) {
        item = jogador;
        proximo = null;
        anterior = null;
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

    public Celula getAnterior() {
        return this.anterior;
    }

    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }
}
