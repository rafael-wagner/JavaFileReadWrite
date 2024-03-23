package org.example.repositorioArquivos.objects;


import java.util.List;
import java.util.Map;

public class ArquivoJSON {

    private String nome;
    private int idCount;

    private List<Map<String, ?>> conteudo;

    public ArquivoJSON() {
    }

    public ArquivoJSON(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCount() {
        return idCount;
    }

    public void setIdCount(int idCount) {
        this.idCount = idCount;
    }

    public void addIdCount(int idCount) {
        this.idCount += idCount;
    }

    public List<Map<String, ?>> getConteudo() {
        return conteudo;
    }

    public void setConteudo(List<Map<String, ?>> conteudo) {
        this.conteudo = conteudo;
    }
}
