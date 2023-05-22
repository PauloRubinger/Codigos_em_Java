package mergesort;

import java.util.ArrayList;
import java.io.*;

public class Mergesort {

    int comp = 0;
    int changes = 0;
    
    public Mergesort() {
        
    }

    public ArrayList<Jogador> mergesort(ArrayList<Jogador> arrayOfPlayers, int esq, int dir) {

        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesort(arrayOfPlayers, esq, meio);
            mergesort(arrayOfPlayers, meio + 1, dir);
            intercalar(arrayOfPlayers, esq, meio, dir);
        }
        return arrayOfPlayers;
    }

    public void intercalar(ArrayList<Jogador> arrayOfPlayers, int esq, int meio, int dir) {

        int n1, n2, i, j, k;

        //Definir tamanho dos dois subarrays
        n1 = meio - esq + 1;
        n2 = dir - meio;

        ArrayList<Jogador> a1 = new ArrayList<Jogador>(n1);
        ArrayList<Jogador> a2 = new ArrayList<Jogador>(n2);

        //Inicializar primeiro subarray
        for (i = 0; i < n1; i++) {
            a1.add(i, arrayOfPlayers.get(esq + i));
        }

        //Inicializar segundo subarray
        for (j = 0; j < n2; j++) {
            a2.add(j, arrayOfPlayers.get(meio + j + 1));
        }

        //Intercalação propriamente dita
        for (i = j = 0, k = esq; (i < n1 && j < n2); k++) {

            if (a1.get(i).getUniversidade().compareTo(a2.get(j).getUniversidade()) < 0 || ((a1.get(i).getUniversidade().compareTo(a2.get(j).getUniversidade()) == 0) && (a1.get(i).getNome().compareTo(a2.get(j).getNome()) < 0))) {
                arrayOfPlayers.set(k, a1.get(i++));
                // Comparações considerando pior caso
                comp += 3;
                changes++;
            } else {
                arrayOfPlayers.set(k, a2.get(j++));
                comp++;
                changes++;
            }
        }
    
        if (i == n1) {
            for (; k <= dir; k++) {
                arrayOfPlayers.set(k, a2.get(j++));
                changes++;
            }
        }
        else {
            for (; k <= dir; k++) {
                arrayOfPlayers.set(k, a1.get(i++));
                changes++;
            }
        }
    }
    
    // Criação do arquivo de log conforme pedido no enunciado para analisar o número de comparações e trocas feitas pelo método de ordenação, além do tempo de execução
    public void arquivoLog(long startTime, long endTime) throws Exception{

        FileWriter file = new FileWriter("794310_mergesort.txt");
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
