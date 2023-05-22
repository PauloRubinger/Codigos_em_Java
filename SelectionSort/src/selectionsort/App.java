package selectionsort;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        Jogador jogador = new Jogador();
        SelectionSort selectionSort = new SelectionSort();
        ArrayList<Jogador> arrayOfPlayers;

        try {
            arrayOfPlayers = jogador.leitura();

            long startTime = System.currentTimeMillis();
            arrayOfPlayers = selectionSort.sort(arrayOfPlayers);
            long endTime = System.currentTimeMillis();
            
            selectionSort.arquivoLog(startTime, endTime);

            for (int i = 0; i < arrayOfPlayers.size(); i++) {
                arrayOfPlayers.get(i).imprimir();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}