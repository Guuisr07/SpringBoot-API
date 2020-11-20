package br.com.guilhermesantana.sprintbootcommysql.controller.dto;

import br.com.guilhermesantana.sprintbootcommysql.model.Pessoa;

public class PessoaResponse {

    private Long id;
    private String nome;
    private String sobrenome;

    public static PessoaResponse converter(Pessoa p) {
        var pessoa = new PessoaResponse();
        pessoa.setId(p.getId());
        pessoa.setNome(p.getNome());
        pessoa.setSobrenome(p.getSobrenome());
        return pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}

//Criando essa clase de response apenas para repassar esses dados em uma requisicao para que nao va para o externo as entidades do banco
