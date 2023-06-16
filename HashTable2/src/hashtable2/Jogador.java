package hashtable2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class Jogador {

    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    // Constructors
    public Jogador() {

    }

    public Jogador(String id, String nome, String altura, String peso, String universidade, String anoNascimento, String cidadeNascimento, String estadoNascimento) {
        this.setId(id);
        this.setNome(nome);
        this.setAltura(altura);
        this.setPeso(peso);
        this.setUniversidade(universidade);
        this.setAnoNascimento(anoNascimento);
        this.setCidadeNascimento(cidadeNascimento);
        this.setEstadoNascimento(estadoNascimento);
    }
    
    // Getters
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public int getAltura() {
        return this.altura;
    }

    public int getPeso() {
        return this.peso;
    }

    public String getUniversidade() {
        return this.universidade;
    }

    public int getAnoNascimento() {
        return this.anoNascimento;
    }

    public String getCidadeNascimento() {
        return this.cidadeNascimento;
    }

    public String getEstadoNascimento() {
        return this.estadoNascimento;
    }

    // Setters
    public void setId(String idStr) {
        int idInt = Integer.parseInt(idStr);
        this.id = idInt;
    }

    public void setNome(String nome) {
        if (nome.equals("")) {
            nome = "nao informado";
        }
        this.nome = nome;
    }

    public void setAltura(String alturaStr) {
        int alturaInt = -1;
        try {
            alturaInt = Integer.parseInt(alturaStr);
        } catch (NumberFormatException e) {

        }
        this.altura = alturaInt;
    }

    public void setPeso(String pesoStr) {
        int pesoInt = -1;
        try {
            pesoInt = Integer.parseInt(pesoStr);
        } catch (NumberFormatException e) {

        }
        this.peso = pesoInt;
    }

    public void setUniversidade(String universidade) {
        if (universidade.equals("")) {
            universidade = "nao informado";
        }
        this.universidade = universidade;
    }

    public void setAnoNascimento(String anoNascimentoStr) {
        int anoNascimentoInt = -1;
        try {
            anoNascimentoInt = Integer.parseInt(anoNascimentoStr);
        } catch (NumberFormatException e) {

        }
        this.anoNascimento = anoNascimentoInt;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        if (cidadeNascimento.equals("")) {
            cidadeNascimento = "nao informado";
        }
        this.cidadeNascimento = cidadeNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        if (estadoNascimento.equals("-1")) {
            estadoNascimento = "nao informado";
        }
        this.estadoNascimento = estadoNascimento;
    }

    public HashTable leitura(int size) throws Exception {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Jogador> arrayOfPlayers = new ArrayList<>();

        ArquivoTextoLeitura leituraArquivo = new ArquivoTextoLeitura("HashTable2/tmp/jogadores.txt");
        leituraArquivo.lerArquivo();

        while (leituraArquivo != null) {

            String str = leituraArquivo.lerArquivo();

            if (str == null) {
                break;
            }
            
            if (str.lastIndexOf(",") == str.length() - 1) {
                str += "-1";
            }
            String[] arrayOfStrings = str.split(",");
            Jogador newJogador = new Jogador(arrayOfStrings[0], arrayOfStrings[1], arrayOfStrings[2], arrayOfStrings[3], arrayOfStrings[4], arrayOfStrings[5], arrayOfStrings[6], arrayOfStrings[7]);
            arrayOfPlayers.add(newJogador);
        }

        leituraArquivo.fecharArquivo();

        HashTable hashTable = new HashTable(size);
        HashSet<Integer> addedPlayerIds = new HashSet<>();
        String entrada = scanner.nextLine();
        int positionOfSearchedPlayer;

        while (!entrada.equals("FIM")) {
            int playerId = Integer.parseInt(entrada);
            for (Jogador jogador : arrayOfPlayers) {
                if (playerId == jogador.id && !addedPlayerIds.contains(playerId)) {
                    hashTable.insert(jogador);
                    addedPlayerIds.add(playerId);
                }
            }
            entrada = scanner.nextLine();
        }

        entrada = scanner.nextLine();

        while (!entrada.equals("FIM")) {
            
            for (Jogador jogador : arrayOfPlayers) {
                if (entrada.equals(jogador.getNome())) {
                    positionOfSearchedPlayer = hashTable.search(jogador);

                    if (positionOfSearchedPlayer == -1) {
                        System.out.println("NAO");
                    } else {
                        System.out.println(positionOfSearchedPlayer + " SIM");
                    }
                }
            }
            entrada = scanner.nextLine();
        }

        scanner.close();

        return hashTable;
    }

    public void imprimir() {

        String alturaStr = (altura != -1) ? Integer.toString(altura) : "nao informado";
        String pesoStr = (peso != -1) ? Integer.toString(peso) : "nao informado";
        String anoNascimentoStr = (anoNascimento != -1) ? Integer.toString(anoNascimento) : "nao informado";
        System.out.println("[" + getId() + " ## " + getNome() + " ## " + alturaStr + " ## " + pesoStr + " ## "
                + anoNascimentoStr + " ## " + getUniversidade() + " ## " + getCidadeNascimento() + " ## "
                + getEstadoNascimento() + "]");
    }
}
