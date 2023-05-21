package heapsort;

import java.util.ArrayList;

public class Heapsort {
    
    public Heapsort() {
        
    }

    public ArrayList<Jogador> sort(ArrayList<Jogador> arrayOfPlayers) {

        ArrayList<Jogador> temp = new ArrayList<Jogador>(arrayOfPlayers.size() + 1);
        temp.add(null);

      	for (int i = 0; i < arrayOfPlayers.size(); i++) {
        	temp.add(i + 1, arrayOfPlayers.get(i));
      	}
      	
      	//Contrução do heap
      	for (int tamHeap = 2; tamHeap <= arrayOfPlayers.size(); tamHeap++) {
        	constroi(temp, tamHeap);
      	}

      	//Ordenação propriamente dita
      	int tamHeap = arrayOfPlayers.size();
        
      	while (tamHeap > 1) {
        	troca(temp, 1, tamHeap--);
         	reconstroi(temp, tamHeap);
      	}

      	//Alterar o vetor para voltar à posição zero
      	for (int i = 0; i < arrayOfPlayers.size(); i++) {
        	arrayOfPlayers.set(i, temp.get(i + 1));
      	}

        return arrayOfPlayers;
    }

    void constroi(ArrayList<Jogador> arrayOfPlayers, int tamHeap) {

        for (int i = tamHeap; i > 1 && arrayOfPlayers.get(i).getAltura() > arrayOfPlayers.get(i/2).getAltura(); i /= 2) {
            troca(arrayOfPlayers, i, i/2);
        }
    }
    
    void reconstroi(ArrayList<Jogador> arrayOfPlayers, int tamHeap) {
    
        int i = 1;
              
        while (i <= (tamHeap/2)) {
            int filho = getMaiorFilho(arrayOfPlayers, i, tamHeap);
            if(arrayOfPlayers.get(i).getAltura() < arrayOfPlayers.get(filho).getAltura()) {
                troca(arrayOfPlayers, i, filho);
                i = filho;
            } else {
                i = tamHeap;
            }
        }
    }
    
    int getMaiorFilho(ArrayList<Jogador> arrayOfPlayers, int i, int tamHeap) {
    
        int filho;
    
        if (2*i == tamHeap || arrayOfPlayers.get(2*i).getAltura() > arrayOfPlayers.get(2*i + 1).getAltura()) {
            filho = 2*i;
        } else {
            filho = 2*i + 1;
        }
        return filho;
    }
    
    void troca(ArrayList<Jogador> arrayOfPlayers, int i, int j) {
              
        Jogador temp = arrayOfPlayers.get(i);
        arrayOfPlayers.set(i, arrayOfPlayers.get(j));
        arrayOfPlayers.set(j, temp);
    }
}
