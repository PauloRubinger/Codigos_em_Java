package heapsort;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        Jogador jogador = new Jogador();
        Heapsort heapSort = new Heapsort();
        ArrayList<Jogador> arrayOfPlayers;

        try {
            arrayOfPlayers = jogador.leitura();
            arrayOfPlayers = heapSort.sort(arrayOfPlayers);

            for (int i = 0; i < arrayOfPlayers.size(); i++) {
                arrayOfPlayers.get(i).imprimir();
            }
    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}