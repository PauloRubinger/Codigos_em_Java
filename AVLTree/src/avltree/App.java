package avltree;

public class App {
    public static void main(String[] args) {

        Jogador jogador = new Jogador();
        AVLTree avlTree = new AVLTree();

        try {

            long startTime = System.currentTimeMillis();
            avlTree = jogador.leitura();
            long endTime = System.currentTimeMillis();

            avlTree.logFile(startTime, endTime);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}