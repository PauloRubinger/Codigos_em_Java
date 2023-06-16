package hashtable2;

public class HashTable {
    
    public static int comp = 0;
    private int divisionFactor;
    private Jogador hashTable[];

    public HashTable(int size) {

        this.divisionFactor = size;
        hashTable = new Jogador[this.divisionFactor];

        for (int i = 0; i < divisionFactor; i++) {
            hashTable[i] = null;
        }
    }

    public int hashFunction(int key, int attempts) {
        return (((key % this.divisionFactor) + (attempts * (key % 23))) % this.divisionFactor);
    }

    public void insert(Jogador newPlayer) throws Exception {
        
        int position;
        int attempts = 0;
        boolean inserted = false;

        while (!inserted && attempts < this.divisionFactor) {

            position = hashFunction(newPlayer.getAltura(), attempts);
            
            if (hashTable[position] == null) {
                hashTable[position] = newPlayer;
                inserted = true;
            } else if (hashTable[position] == newPlayer) {
                throw new Exception("Não foi possível inserir o item na tabela: esse item já foi inserido anteriormente!");
            } else {
                attempts++;
            }
        }
    }

    public int search(Jogador player) throws Exception {
        
        int position;
        int attempts = 0;

        while (attempts < this.divisionFactor) {

            position = hashFunction(player.getAltura(), attempts);

            if (hashTable[position] == player) {
                comp++;
                return position;
            } else {
                attempts++;
            }
        }

        return -1;
    }
}
