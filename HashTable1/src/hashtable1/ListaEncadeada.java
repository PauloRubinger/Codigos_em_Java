package hashtable1;

public class ListaEncadeada {

    private Celula primeiro;
    private Celula ultimo;
    private int tamanho;
    public static int comp;

    public ListaEncadeada() {

        Celula sentinela = new Celula();

        primeiro = sentinela;
        ultimo = sentinela;
        tamanho = 0;
        comp = 0;
    }

    public int getComp() {
        return comp;
    }

    public void setComp(int comp) {
        ListaEncadeada.comp = comp;
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
        novaCelula.setProximo(null);
        ultimo = novaCelula;
        tamanho++;
    }

    public Jogador removerInicio() throws Exception {

        Jogador removido;

        if (!listaVazia()) {
            primeiro = primeiro.getProximo();
            removido = primeiro.getItem();
            primeiro.setProximo(primeiro.getProximo());
            tamanho--;
            return removido;
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

        Jogador removido;
        Celula anterior;

        if (!listaVazia()) {
            removido = ultimo.getItem();
            anterior = primeiro;
            for (int i = 0; i < tamanho - 1; i++) {
                anterior = anterior.getProximo();
            }
            anterior.setProximo(null);
            ultimo = anterior;
            tamanho--;
            return removido;
        } else {
            throw new Exception("Não foi possível remover o elemento da lista: a lista está vazia!");
        }
    }

    public Jogador search(Jogador player) {

        Celula aux = primeiro.getProximo();

        comp++;
        while (aux != null) {
            comp++;
            if (aux.getItem() == player) {
                return aux.getItem();
            }
            aux = aux.getProximo();
        }

        return null;
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