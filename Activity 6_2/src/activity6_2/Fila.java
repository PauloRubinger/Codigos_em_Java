package activity6_2;

public class Fila {

    private Celula frente;
    private Celula tras;

    public Fila() {
        Celula sentinela = new Celula();
        frente = sentinela;
        tras = sentinela;
    }

    public boolean filaVazia() {
        if (frente == tras) {
            return true;
        } else {
            return false;
        }
    }

    public void enfileirar(Jogador jogador) throws Exception{
        
        Celula novaCelula = new Celula(jogador);
        tras.setProximo(novaCelula);
        tras = novaCelula;
    }

    public Jogador desenfileirar() throws Exception{

        Celula celulaDesenfileirada;
        Celula proximaCelula;

        if (!filaVazia()) {
            celulaDesenfileirada = frente.getProximo();
			proximaCelula = celulaDesenfileirada.getProximo();
			frente.setProximo(proximaCelula);
            if (celulaDesenfileirada == tras) { // se a célula retirada for a última célula da fila
                tras = frente;
            }
            return celulaDesenfileirada.getItens();
        } else {
            throw new Exception("Não foi possível desenfileirar: a fila está vazia!");
        }
    }

    public double obterMediaAltura() throws Exception{

        double somaAltura = 0;
        double mediaAltura;
        Jogador jogador;
    
        int numJogadores = 0; // contador de jogadores
    
        if (!filaVazia()) {
            Celula aux;
            aux = frente.getProximo();
    
            while (aux != null) {
                jogador = aux.getItens();
                somaAltura += jogador.getAltura();
                numJogadores++;
                aux = aux.getProximo();
            }
    
            mediaAltura = (somaAltura / numJogadores);
            System.out.println(Math.round(mediaAltura));
    
            return mediaAltura;
        } else {
            throw new Exception ("Não foi possível calcular a média de altura: a fila está vazia!");
        }
    }

    public void mostrar() throws Exception{

        Celula aux;
        int i = 0;

        if (!filaVazia()) {
            aux = frente.getProximo();

            while (aux != null) {
                System.out.print("[" + i + "] ");
                aux.getItens().imprimir();
                aux = aux.getProximo();
                i++;
            }
        } else {
            throw new Exception ("Não foi possível mostrar a fila: a fila está vazia!");
        }
    }
}