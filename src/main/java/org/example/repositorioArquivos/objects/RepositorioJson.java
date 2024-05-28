package org.example.repositorioArquivos.objects;


import java.util.HashMap;
import java.util.Map;

public class RepositorioJson<E extends Object> {

    private String nome;
    private Long idCount;

    private Map<Long, Map<String, E>> conteudo;

    public RepositorioJson() {
        this.conteudo = new HashMap<>();
        idCount = 0L;
    }

    public RepositorioJson(String nome) {
        this.nome = nome;
        this.conteudo = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdCount() {
        return idCount;
    }

    public void setIdCount(Long idCount) {
        this.idCount = idCount;
    }

    public void addIdCount(Long idCount) {
        this.idCount += idCount;
    }

    public Map<Long, Map<String, E>> getConteudo() {
        return conteudo;
    }

    public void setConteudo(Map<Long, Map<String, E>> conteudo) {
        this.conteudo = conteudo;
    }

    public void addConteudo(Map<String, E> novoConteudo) {
        this.conteudo.put(++idCount, novoConteudo);
    }
    public void removerConteudo(Long id) {
        this.conteudo.remove(id);
    }
    public void atualizarConteudo(Long id, Map<String, E> novoConteudo) {
        this.conteudo.put(id, novoConteudo);
    }
}
