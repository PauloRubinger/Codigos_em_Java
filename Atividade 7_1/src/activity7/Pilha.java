package activity7;

public class Pilha {
    
    private Jogador pilha[];
    private int topo;

    public Pilha() {

    }

    public Pilha(int tamanho) {

        pilha = new Jogador[tamanho];
        topo = 0;
    }

    public boolean pilhaCheia() {

        if (topo == pilha.length) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pilhaVazia() {

        if (topo == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void empilhar(Jogador novo) throws Exception{

        if (!pilhaCheia()) {
            pilha[topo] = novo;
            topo++;
        } else {
            throw new Exception("Não foi possível empilhar: a pilha está cheia!");
        }
    }

    public Jogador desempilhar() throws Exception{

        Jogador desempilhado;

        if (!pilhaVazia()) {
            topo--;
            desempilhado = pilha[topo];
            return desempilhado;
        } else {
            throw new Exception("Não foi possível desempilhar: a pilha está vazia!");
        }
    }

    public void mostrar() throws Exception{

        Jogador jogador;

        if (!pilhaVazia()) {
            for (int i = 0; i < topo; i++) {
                jogador = pilha[i];
                System.out.print("[" + i + "] ");
                jogador.imprimir();
            }
        } else {
            throw new Exception("Não foi possível mostrar a pilha: a pilha está vazia!");
        }
    }
}
