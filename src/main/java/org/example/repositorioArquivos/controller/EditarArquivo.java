package org.example.repositorioArquivos.controller;


import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.repositorioArquivos.objects.RepositorioJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


public class EditarArquivo {

    private static final Logger logger
            = LoggerFactory.getLogger(EditarArquivo.class);
    public static final String PASTA_PADRAO_ARQUIVOS = "./saidaDeArquivos/";
    private static final ObjectMapper mapper = new ObjectMapper();
    private String nomeDeArquivo;
    private String localDeArquivo;


    /**
     * @param nomeDeArquivo Especifica o nome do arquivo a ser trabalhado
     *                      Ao caminho do arquivo é adicionado a PASTA_PADRAO_ARQUIVOS
     */
    public EditarArquivo(String nomeDeArquivo) {
        this.setNomeDeArquivo(nomeDeArquivo);
    }

    public String getNomeDeArquivo() {
        return nomeDeArquivo;
    }

    /**
     * @param nomeDeArquivo Especifica o nome do arquivo a ser trabalhado
     *                      Ao caminho do arquivo é adicionado a PASTA_PADRAO_ARQUIVOS
     */
    public void setNomeDeArquivo(String nomeDeArquivo) {
        this.nomeDeArquivo = nomeDeArquivo;
        this.localDeArquivo = PASTA_PADRAO_ARQUIVOS + nomeDeArquivo;
    }

    /**
     * Lê um arquivo espeificado pela classe
     *
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
            logger.info("concluido leitura de arquivo.");
        } catch (NullPointerException | FileNotFoundException e) {
            logger.warn("Foi tentado ler um arquivo inexistente");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return conteudo.toString();
    }

    /**
     *
     * @param repositorio A ser escrito para o arquivo.
     *                    Este metodo CRIA um novo arquivo caso inexistente e REESCREVE SOBRE um arquivo ja existente.
     *
     */
    public void escreverArquivoJson(RepositorioJson repositorio) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(
                    new File(localDeArquivo),
                    repositorio
            );

            logger.info("arquivo escrito usando o método {escreverArquivoJson}");
        } catch (IOException e) {
            logger.warn("Falha ao escrever arquivo :", e);
        }
    }

    /**
     *
     * @return variavel RepositorioJson extraida do arquivo.
     * @throws IOException
     */
    public RepositorioJson lerArquivoJson() throws IOException {
        try {
            return
                    mapper.readValue(
                            new File(localDeArquivo),
                            RepositorioJson.class
                    );

        } catch (IOException e) {
            logger.warn("Falha ao tentar ler Arquivo :", e);
            throw e;
        }

    }


    /**
     * Edita um arquivo existente
     *
     * @param novoConteudo Conteúdo a ser adicionado ao arquivo existente
     */
    public void editar(String novoConteudo) {
        String conteudoDeArquivo = this.lerArquivo();
        novoConteudo = conteudoDeArquivo + novoConteudo;
        this.escrever(novoConteudo);

        logger.info("arquivo editado com sucesso!");

    }

    /**
     * Escreve um novo arquivo ou SobreEscreve um arquivo existente
     *
     * @param conteudo Conteúdo a ser Escrito em um novo arquivo
     */
    public void escrever(String conteudo) {
        try {
            BufferedWriter leitorBf = new BufferedWriter(new FileWriter(localDeArquivo));
            leitorBf.write(conteudo);
            leitorBf.close();

            logger.info("arquivo escrito com sucesso !");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
