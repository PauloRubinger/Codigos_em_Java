package hashtable1;

public class HashTable {
    
    private int divisionFactor;
    private ListaEncadeada hashtable[];

    public HashTable(int size) {

        this.divisionFactor = size;
        hashtable = new ListaEncadeada[this.divisionFactor];

        for (int i = 0; i < divisionFactor; i++) {
            hashtable[i] = new ListaEncadeada();
        }
    }

    public int hashFunction(int key) {
        return (key % this.divisionFactor);
    }

    public void insert(Jogador newPlayer) throws Exception {

        int position = hashFunction(newPlayer.getAltura());

        if (hashtable[position].search(newPlayer) == null) {
            hashtable[position].inserirInicio(newPlayer);
        } else {
            throw new Exception("Não foi possível inserir o elemento na tabela: o elemento já foi inserido anteriormente!");
        }
    }

    public Jogador search(Jogador player) throws Exception {
        return hashtable[hashFunction(player.getAltura())].search(player); // this search method is from ListaEncadeada class
    }

    public void print() {
        
    }
}
