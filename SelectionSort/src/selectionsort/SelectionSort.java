package selectionsort;

import java.util.ArrayList;
import java.io.*;

public class SelectionSort {

    int comp = 0;
    int changes = 0;

    public SelectionSort() {

    }

    public ArrayList<Jogador> sort(ArrayList<Jogador> arrayOfPlayers) {
        for (int i = 0; i < (arrayOfPlayers.size() - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < arrayOfPlayers.size(); j++) {
                if (arrayOfPlayers.get(menor).getNome().compareTo(arrayOfPlayers.get(j).getNome()) > 0) {
                    menor = j;
                    comp++;
                }
            }
            Jogador temp = arrayOfPlayers.get(i);
            arrayOfPlayers.set(i, arrayOfPlayers.get(menor));
            arrayOfPlayers.set(menor, temp);
            changes++;
        }
        return arrayOfPlayers;
    }

    // Criação do arquivo de log conforme pedido no enunciado para analisar o número de comparações e trocas feitas pelo método de ordenação, além do tempo de execução
    public void arquivoLog(long startTime, long endTime) throws Exception{

        FileWriter file = new FileWriter("794310_selecao.txt");
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
