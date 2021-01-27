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
public class ObraModel {

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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

    public TipoModel getTipo() {
        return tipo;
    }

    public void setTipo(TipoModel tipo) {
        this.tipo = tipo;
    }
    private int id;
    private String descricao;
    private String autor;
    private int ano;
    private String local;
    private CategoriaModel categoria;
    private TipoModel tipo;

    public ObraModel(int id, String descricao, String autor, int ano, String local, CategoriaModel categoria, TipoModel tipo) {
        this.id = id;
        this.descricao = descricao;
        this.autor = autor;
        this.ano = ano;
        this.local = local;
        this.categoria = categoria;
        this.tipo = tipo;
    }

    public ObraModel() {
        id=0;
        descricao=new String();
        autor=new String();
        local=new String();
        categoria = new CategoriaModel();
        tipo = new TipoModel();
    }
    
    
}
