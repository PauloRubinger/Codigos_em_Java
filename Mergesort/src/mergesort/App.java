package mergesort;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        Jogador jogador = new Jogador();
        Mergesort mergesort = new Mergesort();
        ArrayList<Jogador> arrayOfPlayers;

        try {
            arrayOfPlayers = jogador.leitura();

            int esq = 0;
            int dir = arrayOfPlayers.size() - 1;

            long startTime = System.currentTimeMillis();
            arrayOfPlayers = mergesort.mergesort(arrayOfPlayers, esq, dir);
            long endTime = System.currentTimeMillis();

            mergesort.arquivoLog(startTime, endTime);

            for (int i = 0; i < arrayOfPlayers.size(); i++) {
                arrayOfPlayers.get(i).imprimir();
            }
    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
