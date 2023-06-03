package bst;

public class App {
    public static void main(String[] args) {

        Jogador jogador = new Jogador();

        try {

            jogador.leitura();
            
            // long startTime = System.currentTimeMillis();
            // long endTime = System.currentTimeMillis();
    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
