package org.example.arquivos;


import java.io.*;

public class EditarArquivo {

    private static String PASTA_PADRAO_ARQUIVOS = "./saidaDeArquivos/";

    private String nomeDeArquivo;
    private String localDeArquivo;

    /**
     *
     * @param nomeDeArquivo Especifica o nome do arquivo a ser trabalhado
     *                      Ao caminho do arquivo é adicionado a PASTA_PADRAO_ARQUIVOS
     */
    public EditarArquivo(String nomeDeArquivo) {
        this.nomeDeArquivo = nomeDeArquivo;
        this.localDeArquivo = PASTA_PADRAO_ARQUIVOS + nomeDeArquivo;
    }

    /**
     * Lê um arquivo espeificado pela classe
     * @return a string correpondete a leitura do arquivo
     */
    public String lerArquivo() {
        StringBuilder conteudo = new StringBuilder("");

        try {
            BufferedReader leitorBf = new BufferedReader(new FileReader(localDeArquivo));

            String line;
            while ((line = leitorBf.readLine()) != null) {
                conteudo.append(line + "\n");
            }
            leitorBf.close();
        } catch (NullPointerException | FileNotFoundException e) {
            System.err.println(e.getMessage() + "\nFoi tentado ler um arquivo inexistente");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return conteudo.toString();
    }


    /**
     * Edita um arquivo existente
     * @param novoConteudo Conteúdo a ser adicionado ao arquivo existente
     */
    public void editar(String novoConteudo) {
        String conteudoDeArquivo = this.lerArquivo();
        novoConteudo = conteudoDeArquivo + novoConteudo;
        this.escrever(novoConteudo);

    }

    /**
     * Escreve um novo arquivo ou SobreEscreve um arquivo existente
     * @param conteudo Conteúdo a ser Escrito em um novo arquivo
     */
    public void escrever(String conteudo){
        try {
            BufferedWriter leitorBf = new BufferedWriter(new FileWriter(localDeArquivo));
            leitorBf.write(conteudo);
            leitorBf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
