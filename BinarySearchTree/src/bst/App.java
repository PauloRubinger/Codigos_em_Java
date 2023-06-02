package bst;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        Jogador jogador = new Jogador();
        ArrayList<Jogador> arrayOfPlayers;

        try {
            arrayOfPlayers = jogador.leitura();

            // long startTime = System.currentTimeMillis();
            // long endTime = System.currentTimeMillis();

            for (int i = 0; i < arrayOfPlayers.size(); i++) {
                arrayOfPlayers.get(i).imprimir();
            }
    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
