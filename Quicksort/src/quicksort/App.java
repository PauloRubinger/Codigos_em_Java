package quicksort;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        Jogador jogador = new Jogador();
        Quicksort quicksort = new Quicksort();
        ArrayList<Jogador> arrayOfPlayers;

        try {
            arrayOfPlayers = jogador.leitura();

            long startTime = System.currentTimeMillis();
            arrayOfPlayers = quicksort.sort(arrayOfPlayers);
            long endTime = System.currentTimeMillis();

            quicksort.arquivoLog(startTime, endTime);

            for (int i = 0; i < arrayOfPlayers.size(); i++) {
                arrayOfPlayers.get(i).imprimir();
            }
    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}