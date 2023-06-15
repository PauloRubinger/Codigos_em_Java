package hashtable1;

public class App {
    public static void main(String[] args) throws Exception {
        
        Jogador jogador = new Jogador();
        HashTable hashTable = new HashTable();

        try {

            // long startTime = System.currentTimeMillis();
            hashTable = jogador.leitura();
            // long endTime = System.currentTimeMillis();

            // hashTable.logFile(startTime, endTime);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
