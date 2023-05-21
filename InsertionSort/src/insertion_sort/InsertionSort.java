package insertion_sort;

import java.util.ArrayList;

public class InsertionSort {

    public InsertionSort() {

    }

    public ArrayList<Jogador> sort(ArrayList<Jogador> arrayOfPlayers) {
        
        for (int i = 1; i < arrayOfPlayers.size(); i++) {
            
            Jogador temp = arrayOfPlayers.get(i);
            int j = i - 1;
            
            while (j >= 0 && (arrayOfPlayers.get(j).getAnoNascimento() > temp.getAnoNascimento() || (arrayOfPlayers.get(j).getAnoNascimento() == temp.getAnoNascimento() && arrayOfPlayers.get(j).getNome().compareToIgnoreCase(temp.getNome()) > 0))) {
                arrayOfPlayers.set(j + 1, arrayOfPlayers.get(j));
                j--;
            }
            arrayOfPlayers.set(j + 1, temp);
        }
        return arrayOfPlayers;
    }
}
