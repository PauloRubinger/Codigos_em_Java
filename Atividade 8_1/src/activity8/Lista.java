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

    public void inserirInicio(Jogador jogador) throws Exception{

        if (!listaCheia()) {
            for (int i = ultimo; i > primeiro; i--) {
                lista[i] = lista[i - 1];
            }
            lista[primeiro] = jogador;
            ultimo++;
            tamanho++;
        } else {
            throw new Exception("Não foi possível inserir o elemento na lista: a lista está cheia!");
        }
    }

    public void inserir(Jogador jogador, int posicao) throws Exception{

        if (!listaCheia()) {
            if (posicao >= 0 && posicao <= tamanho) {
                for (int i = ultimo; i > posicao; i--) {
                    lista[i] = lista[i - 1];
                }
                lista[posicao] = jogador;
                ultimo++;
                tamanho++;
            } else {
                throw new Exception("Não foi possível inserir o elemento na lista: a posição informada é inválida!");
            }
        } else {
            throw new Exception("Não foi possível inserir o elemento na lista: a lista está cheia!");
        }
    }

    public void inserirFim(Jogador jogador) throws Exception{

        if (!listaCheia()) {
            lista[ultimo] = jogador;
            ultimo++;
            tamanho++;
        } else {
            throw new Exception("Não foi possível inserir o elemento na lista: a lista está cheia!");
        }
    }

    public Jogador removerInicio() throws Exception{

        Jogador removido;

        if (!listaVazia()) {
            removido = lista[primeiro];
            for (int i = ultimo; i > primeiro; i--) {
                lista[i - 1] = lista[i];
            }
            ultimo--;
            tamanho--;
            return removido;
        } else {
            throw new Exception("Não foi possível remover o elemento da lista: a lista está vazia!");
        }
    }

    public Jogador remover(int posicao) throws Exception{

        Jogador removido;

        if (!listaVazia()) {
            if (posicao >= 0 && posicao <= tamanho) {
                removido = lista[posicao];
                for (int i = posicao; i < ultimo; i++) {
                    lista[i] = lista[i + 1];
                }
                ultimo--;
                tamanho--;
                return removido;
            } else {
                throw new Exception("Não foi possível remover o elemento da lista: a posição informada é inválida!");
            }
        } else {
            throw new Exception("Não foi possível remover o elemento da lista: a lista está vazia!");
        }
    }

    public Jogador removerFim() throws Exception{

        Jogador removido;

        if (!listaVazia()) {
            removido = lista[ultimo];
            ultimo--;
            tamanho--;
            return removido;
        } else {
            throw new Exception("Não foi possível remover o elemento da lista: a lista está vazia!");
        }
    }

    public void mostrar() throws Exception{

        Jogador jogador;

        if (!listaVazia()) {
            for (int i = primeiro; i < tamanho; i++) {
                System.out.print("[" + i + "]");
                jogador = lista[i];
                jogador.imprimir();
            }
        } else {
            throw new Exception("Não foi possível mostrar a lista: a lista está vazia!");
        }
    }
}