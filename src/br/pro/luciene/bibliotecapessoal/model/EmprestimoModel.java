/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.luciene.bibliotecapessoal.model;

import java.sql.Timestamp;

/**
 *
 * @author lucienecavalcanti
 */
public class EmprestimoModel {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ObraModel getObra() {
        return obra;
    }

    public void setObra(ObraModel obra) {
        this.obra = obra;
    }

    public Timestamp getDataemprestimo() {
        return dataemprestimo;
    }

    public void setDataemprestimo(Timestamp dataemprestimo) {
        this.dataemprestimo = dataemprestimo;
    }

    public Timestamp getDatadevolucao() {
        return datadevolucao;
    }

    public void setDatadevolucao(Timestamp datadevolucao) {
        this.datadevolucao = datadevolucao;
    }
    private int id;
    private String nome;
    private ObraModel obra;
    private Timestamp dataemprestimo;
    private Timestamp datadevolucao;

    public EmprestimoModel(int id, String nome, ObraModel obra, Timestamp dataemprestimo, Timestamp datadevolucao) {
        this.id = id;
        this.nome = nome;
        this.obra = obra;
        this.dataemprestimo = dataemprestimo;
        this.datadevolucao = datadevolucao;
    }

    public EmprestimoModel() {
        id=0;
        nome=new String();
        obra = new ObraModel();
        dataemprestimo = new Timestamp(new java.util.Date().getTime());
        datadevolucao = null;
    }
    
}
