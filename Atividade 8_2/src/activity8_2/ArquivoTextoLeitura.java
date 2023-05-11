package activity8_2;

import java.io.*;

public class ArquivoTextoLeitura {

    private BufferedReader input;

    ArquivoTextoLeitura(String nomeArquivo) {

        try {
            input = new BufferedReader(new InputStreamReader(new FileInputStream("Atividade 8_1/tmp/jogadores.txt"), "UTF-8"));
        } catch (UnsupportedEncodingException exception) {
            System.out.println(exception.getMessage());
        } catch (FileNotFoundException exception) {
            System.out.println("Arquivo não encontrado");
        }
    }

    @SuppressWarnings("finally")
    public String lerArquivo() {

        String line = null;

        try {
            line = input.readLine();
        } catch (EOFException exception) { // Exceção de final de arquivo.
            line = null;
        } catch (IOException exception) {
            System.out.println("Erro de leitura: " + exception);
            line = null;
        } finally {
            return line;
        }
    }

    public void fecharArquivo() {

        try {
            input.close();
        } catch (IOException exception) {
            System.out.println("Erro no fechamento do arquivo de leitura: " + exception);
        }
    }
}
