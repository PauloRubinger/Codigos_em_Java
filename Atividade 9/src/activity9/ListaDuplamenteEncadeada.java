package activity9;

public class ListaDuplamenteEncadeada {

    private Celula primeiro;
    private Celula ultimo;
    private int tamanho;

    public ListaDuplamenteEncadeada() {

        Celula sentinela = new Celula();

        primeiro = sentinela;
        ultimo = sentinela;
        tamanho = 0;
    }

    public boolean listaVazia() {

        if (primeiro == ultimo) {
            return true;
        } else {
            return false;
        }
    }

    public void inserirInicio(Jogador jogador) throws Exception {

        Celula novaCelula;

        novaCelula = new Celula(jogador);
        novaCelula.setProximo(primeiro.getProximo());
        primeiro.getProximo().setAnterior(novaCelula);;
        primeiro.setProximo(novaCelula);
        tamanho++;
    }
    
    public void inserir(Jogador jogador, int posicao) throws Exception {

        Celula anterior;
        Celula proximaCelula;
        Celula novaCelula;

        if (posicao >= 0 && posicao <= tamanho) {
            anterior = primeiro;
            for (int i = 0; i < posicao; i++) {
                anterior = anterior.getProximo();
            }
            novaCelula = new Celula(jogador);
            proximaCelula = anterior.getProximo();
            anterior.setProximo(novaCelula);
            novaCelula.setProximo(proximaCelula);

            if (posicao == tamanho) {
                ultimo = novaCelula;
            }

            tamanho++;
        } else {
            throw new Exception("Não foi possível inserir o elemento na lista: a posição informada é inválida!");
        }
    }

    public void inserirFim(Jogador jogador) throws Exception {

        Celula novaCelula;
        
        novaCelula = new Celula(jogador);
        ultimo.setProximo(novaCelula);
        novaCelula.setAnterior(ultimo);
        ultimo = novaCelula;
        tamanho++;
    }

    public Jogador removerInicio() throws Exception {

        Celula removido;

        if (!listaVazia()) {
            removido = primeiro.getProximo();
            primeiro.setProximo(removido.getProximo());
            tamanho--;
            return removido.getItem();
        } else {
            throw new Exception("Não foi possível remover o elemento da lista: a lista está vazia!");
        }
    }

    public Jogador remover(int posicao) throws Exception{

        Celula anterior;
        Celula removida;
        Celula proximaCelula;

        if (!listaVazia()) {
            if (posicao >= 0 && posicao < tamanho) {
                anterior = primeiro;
                for (int i = 0; i < posicao; i++) {
                    anterior = anterior.getProximo();
                }
                removida = anterior.getProximo();
                proximaCelula = removida.getProximo();
                anterior.setProximo(proximaCelula);
                removida.setProximo(null);

                if (removida == ultimo) {
                    ultimo = anterior;
                }
                
                tamanho--;
                return removida.getItem();
            } else {
                throw new Exception("Não foi possível remover o elemento da lista: a posição informada é inválida!");
            }
        } else {
            throw new Exception("Não foi possível remover o elemento da lista: a lista está vazia!");
        }
    }

    public Jogador removerFim() throws Exception{

        Celula removido;
        Celula penultimo;

        if (!listaVazia()) {
            removido = ultimo;
            penultimo = ultimo.getAnterior();
            penultimo.setProximo(null);
            removido.setAnterior(null);
            ultimo = penultimo;
            tamanho--;
            return removido.getItem();
        } else {
            throw new Exception("Não foi possível remover o elemento da lista: a lista está vazia!");
        }
    }

    public void mostrar() throws Exception {

        Celula aux;
        int i = 0;

        if (!listaVazia()) {
            aux = primeiro.getProximo();
            while (aux != null) {
                System.out.print("[" + i + "] ");
                aux.getItem().imprimir();
                aux = aux.getProximo();
                i++;
            }
        } else {
            throw new Exception("Não foi possível mostrar a lista: a lista está vazia!");
        }
    }
}