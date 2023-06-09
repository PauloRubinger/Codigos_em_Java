package activity7_2;

public class Pilha {
    
    private Celula fundo;
    private Celula topo;

    public Pilha() {

        Celula sentinela;

        sentinela = new Celula();
        fundo = sentinela;
        topo = sentinela;
    }

    public boolean pilhaVazia() {

        if (topo == fundo) {
            return true;
        } else {
            return false;
        }
    }

    public void empilhar(Jogador novo) {

        Celula novaCelula;

        novaCelula = new Celula(novo);
        novaCelula.setProximo(topo);
        topo = novaCelula;
    }

    public Jogador desempilhar() throws Exception{

        Celula desempilhada;

        if (!pilhaVazia()) {
            desempilhada = topo;
            topo = topo.getProximo();
            desempilhada.setProximo(null);
            return desempilhada.getJogador();
        } else {
            throw new Exception("Não foi possível desempilhar: a pilha está vazia!");
        }
    }

    public void mostrar() throws Exception{

        Celula aux = topo;
        Pilha pilhaInvertida = new Pilha();
        int i = 0;

        if (!pilhaVazia()) {

            while (aux != fundo) {
                pilhaInvertida.empilhar(aux.getJogador());
                aux = aux.getProximo();
            }

            while (!pilhaInvertida.pilhaVazia()) {
                Jogador desempilhado = pilhaInvertida.desempilhar();
                System.out.print("[" + i + "] ");
                desempilhado.imprimir();
                i++;
            }
        } else {
            throw new Exception("Não foi possível mostrar a pilha: a pilha está vazia!");
        }
    }
}
