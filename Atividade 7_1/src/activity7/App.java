package activity7;

public class App {
    public static void main(String[] args) {
        
        Jogador jogador = new Jogador();

        try {
            jogador.leitura();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
