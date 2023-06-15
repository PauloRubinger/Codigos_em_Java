package hashtable1;

public class App {
    public static void main(String[] args) throws Exception {
        
        Jogador jogador = new Jogador();
        int size = 37;

        HashTable hashTable = new HashTable(size); // The instructions of this assignment specifiy that the size of the hash table has to be 37

        try {

            // long startTime = System.currentTimeMillis();
            hashTable = jogador.leitura(size);
            // long endTime = System.currentTimeMillis();

            // hashTable.logFile(startTime, endTime);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}