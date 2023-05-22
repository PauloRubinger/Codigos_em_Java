package quicksort;

import java.util.ArrayList;
import java.io.*;

public class Quicksort {

    int comp = 0;
    int changes = 0;

    public Quicksort() {

    }

    public ArrayList<Jogador> sort(ArrayList<Jogador> arrayOfPlayers) {

        int esq = 0;
        int dir = arrayOfPlayers.size() - 1;

        quicksort(arrayOfPlayers, esq, dir);

        return arrayOfPlayers;
    }
    
    private void quicksort(ArrayList<Jogador> arrayOfPlayers, int esq, int dir) {
                
        int part;
        if (esq < dir){
            part = particao(arrayOfPlayers, esq, dir);
            quicksort(arrayOfPlayers, esq, part - 1);
            quicksort(arrayOfPlayers, part + 1, dir);
        }
    }
                    
    private int particao(ArrayList<Jogador> arrayOfPlayers, int inicio, int fim) {
            
        Jogador pivot = arrayOfPlayers.get(fim);
        int part = inicio - 1;

        for (int i = inicio; i < fim; i++) {
            if (arrayOfPlayers.get(i).getEstadoNascimento().compareTo(pivot.getEstadoNascimento()) < 0 || ((arrayOfPlayers.get(i).getEstadoNascimento().compareTo(pivot.getEstadoNascimento()) == 0) && arrayOfPlayers.get(i).getNome().compareTo(pivot.getNome()) < 0)) {
                part++;
                swap(arrayOfPlayers, part, i);
                // Comparações considerando pior caso
                comp += 3;
            }
        }
        part++;
        swap(arrayOfPlayers, part, fim);
        return (part);
    }
        
    private void swap(ArrayList<Jogador> arrayOfPlayers, int i, int j) {
              
        Jogador temp = arrayOfPlayers.get(i);
        arrayOfPlayers.set(i, arrayOfPlayers.get(j));
        arrayOfPlayers.set(j, temp);
        changes++;
    }

    // Criação do arquivo de log conforme pedido no enunciado para analisar o número de comparações e trocas feitas pelo método de ordenação, além do tempo de execução
    public void arquivoLog(long startTime, long endTime) throws Exception{

        FileWriter file = new FileWriter("794310_quicksort.txt");
        PrintWriter log = new PrintWriter(file);
        long timeElapsed = endTime - startTime;
        
        log.printf("794310");
        log.printf("\tTempo de execução(ms):" + timeElapsed);
        log.printf("\tComparações feitas:" + comp);
        log.printf("\tMovimentações feitas:" + changes);

        log.close();
        file.close();
    }
}
