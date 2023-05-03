package activity6;

public class Fila {

    private Jogador[] fila;
    private int frente;
    private int tras;
    private int tamanho;

    public Fila() {

    }

    public Fila(int tamanho) {

        fila = new Jogador[tamanho];
        frente = 0;
        tras = 0;
        this.tamanho = tamanho;
    }

    public boolean filaVazia() {

        if (frente == tras) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean filaCheia() {

        if (((tras + 1) % tamanho) == (frente % tamanho)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void enfileirar(Jogador jogador) throws Exception{
        
        int position;

        if (!filaCheia()) {
            position = tras % tamanho;
            fila[position] = jogador;
            tras++;
        } else {
            desenfileirar();
            enfileirar(jogador);
        }
    }

    public Jogador desenfileirar() throws Exception{

        Jogador desenfileirado;
        int position;

        if (!filaVazia()) {
            position = frente % tamanho;
            desenfileirado = fila[position];
            frente++;
            return desenfileirado;
        } else {
            throw new Exception("Não foi possível desenfileirar: a fila está vazia!");
        }
    }

    public double obterMediaAltura() throws Exception{

        int position;
        double somaAltura = 0;
        double mediaAltura;
        Jogador jogador;

        if (!filaVazia()) {
            for (int i = frente; i < tras; i++) {
                position = i % tamanho;
                jogador = fila[position];
                somaAltura += jogador.getAltura();
            }
        } else {
            throw new Exception("Não foi possível calcular a média de altura: a fila está vazia!");
        }

        mediaAltura = (somaAltura/(tras - frente));
        System.out.println(Math.round(mediaAltura));

        return mediaAltura;
    }

    public void mostrar() throws Exception{

        int position;
        Jogador jogador;

        if(!filaVazia()) {
            for (int i = frente; i < tras; i++) {
                position = i % tamanho;
                jogador = fila[position];
                System.out.print("[" + (position - 2) + "] ");
                jogador.imprimir();
            }
        } else {
            throw new Exception("A fila está vazia!");
        }
    }
}