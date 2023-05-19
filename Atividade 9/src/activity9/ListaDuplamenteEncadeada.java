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

        Celula aux;
        Celula novaCelula;

        if (posicao >= 0 && posicao <= tamanho) {
            if (posicao <= tamanho/2) {
                aux = primeiro;
                for (int i = 0; i < posicao; i++) {
                    aux = aux.getProximo();
                }
                novaCelula = new Celula(jogador);
                novaCelula.setProximo(aux.getProximo());
                aux.setProximo(novaCelula);
                novaCelula.setAnterior(aux);
                aux.setAnterior(novaCelula);
                tamanho++;
            } else {
                aux = ultimo;
                for (int i = tamanho; i > posicao; i--) {
                    aux = aux.getAnterior();
                }
                novaCelula = new Celula(jogador);
                novaCelula.setProximo(aux.getProximo());
                aux.setProximo(novaCelula);
                novaCelula.setAnterior(aux);
                aux.setAnterior(novaCelula);

                if (posicao == tamanho) {
                    ultimo = novaCelula;
                }
                tamanho++;
            }
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

    public Jogador remover(int posicao) throws Exception {

        Celula aux;
        Celula removido;

        if (!listaVazia()) {
            if (posicao >= 0 && posicao < tamanho) {
                aux = primeiro;
                for (int i = 0; i < posicao; i++) {
                    aux = aux.getProximo();
                }
                removido = aux.getProximo();
                aux.setProximo(removido.getProximo());
                aux.setAnterior(removido.getAnterior());
                removido.setProximo(null);
                removido.setAnterior(null);
                
                if (removido == ultimo) {
                    ultimo = aux;
                }
                
                tamanho--;
                return removido.getItem();
            } else {
                throw new Exception("Não foi possível remover o elemento da lista: a posição informada é inválida!");
            }
        } else {
            throw new Exception("Não foi possível remover o elemento da lista: a lista está vazia!");
        }
    }

    public Jogador removerFim() throws Exception {

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