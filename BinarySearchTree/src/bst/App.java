package bst;

public class App {
    public static void main(String[] args) {

        Jogador jogador = new Jogador();
        BinarySearchTree bst = new BinarySearchTree();

        try {

            long startTime = System.currentTimeMillis();
            bst = jogador.leitura();
            long endTime = System.currentTimeMillis();

            bst.logFile(startTime, endTime);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
