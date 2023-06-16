package hashtable2;

import java.io.FileWriter;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) throws Exception {
        
        Jogador jogador = new Jogador();
        int size = 79;  // The instructions of this assignment specifiy that the size of the hash table has to be 79

        try {

            long startTime = System.currentTimeMillis();
            jogador.leitura(size);
            long endTime = System.currentTimeMillis();
            
            FileWriter file = new FileWriter("794310_hashRehashing.txt");
            PrintWriter log = new PrintWriter(file);
            long timeElapsed = endTime - startTime;
            
            log.printf("794310");
            log.printf("\tTempo de execução(ms):" + timeElapsed);
            log.printf("\tComparações feitas:" + HashTable.comp);
            
            log.close();
            file.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}