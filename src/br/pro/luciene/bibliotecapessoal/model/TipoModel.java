/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.luciene.bibliotecapessoal.model;

/**
 *
 * @author lucienecavalcanti
 */
public class TipoModel {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    private int id;
    private String descricao;

    public TipoModel(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public TipoModel() {
        id=0;
        descricao=new String();
    }
    
}
