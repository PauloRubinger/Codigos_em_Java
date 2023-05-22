package selectionsort;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        Jogador jogador = new Jogador();
        SelectionSort mergesort = new SelectionSort();
        ArrayList<Jogador> arrayOfPlayers;

        try {
            arrayOfPlayers = jogador.leitura();
            arrayOfPlayers = mergesort.sort(arrayOfPlayers);

            for (int i = 0; i < arrayOfPlayers.size(); i++) {
                arrayOfPlayers.get(i).imprimir();
            }
    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}