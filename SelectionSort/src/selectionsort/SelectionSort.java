package selectionsort;

import java.util.ArrayList;

public class SelectionSort {

    public SelectionSort() {

    }

    public ArrayList<Jogador> sort(ArrayList<Jogador> arrayOfPlayers) {
        for (int i = 0; i < (arrayOfPlayers.size() - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < arrayOfPlayers.size(); j++) {
                if (arrayOfPlayers.get(menor).getNome().compareTo(arrayOfPlayers.get(j).getNome()) > 0) {
                    menor = j;
                }
            }
            Jogador temp = arrayOfPlayers.get(i);
            arrayOfPlayers.set(i, arrayOfPlayers.get(menor));
            arrayOfPlayers.set(menor, temp);
        }
        return arrayOfPlayers;
    }
}
