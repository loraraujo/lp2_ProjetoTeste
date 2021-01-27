/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.luciene.bibliotecapessoal.data;

import br.pro.luciene.bibliotecapessoal.model.CategoriaModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lucienecavalcanti
 */
public class CategoriaData extends Conexao{
    public CategoriaData() throws Exception {}
    public boolean incluir(CategoriaModel obj) throws Exception {
        String sql="Insert into Categorias (descricao) values(?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1,obj.getDescricao());
        return ps.executeUpdate()>0;
    }
    public boolean editar(CategoriaModel obj) throws Exception {
        String sql="Update Categorias set descricao=? where id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1,obj.getDescricao());
        ps.setInt(2, obj.getId());
        return ps.executeUpdate()>0;
    }
    public boolean excluir(int id) throws Exception {
        String sql="delete from Categorias where id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate()>0;
    }
    public ArrayList<CategoriaModel> pesquisar(String texto) throws Exception{
        ArrayList<CategoriaModel> dados = new ArrayList<>();
        String sql="Select * from Categorias where descricao like '"+texto+"%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            CategoriaModel obj = new CategoriaModel(rs.getInt("id"),rs.getString("descricao"));
            dados.add(obj);
        }   
        return dados;
    }
    public ArrayList<CategoriaModel> carregarCombo() throws Exception{
        ArrayList<CategoriaModel> dados = new ArrayList<>();
        String sql="Select * from Categorias order by descricao";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            CategoriaModel obj = new CategoriaModel(rs.getInt("id"),rs.getString("descricao"));
            dados.add(obj);
        }  
        return dados;
    }
}