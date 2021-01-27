/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.luciene.bibliotecapessoal.data;

import br.pro.luciene.bibliotecapessoal.model.CategoriaModel;
import br.pro.luciene.bibliotecapessoal.model.TipoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lucienecavalcanti
 */
public class TipoData extends Conexao{
    public TipoData() throws Exception {}
    public boolean incluir(TipoModel obj) throws Exception {
        String sql="insert into Tipos (descricao) values (?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1,obj.getDescricao());
        return ps.executeUpdate()>0;
    }
    public boolean editar(TipoModel obj) throws Exception {
        String sql="update Tipos set descricao=? where id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1,obj.getDescricao());
        ps.setInt(2,obj.getId());
        return ps.executeUpdate()>0;
    }
    public boolean excluir(int id) throws Exception {
        String sql="delete from Tipos where id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1,id);
        return ps.executeUpdate()>0;
    }
    public ArrayList<TipoModel> pesquisar(String texto) throws Exception{
        ArrayList<TipoModel> dados = new ArrayList<>();
        String sql="Select * from Tipos where descricao like '"+texto+"%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            TipoModel obj = new TipoModel(rs.getInt("id"),rs.getString("descricao"));
            dados.add(obj);
        }   
        return dados;
    }
    public ArrayList<TipoModel> carregarCombo() throws Exception{
        ArrayList<TipoModel> dados = new ArrayList<>();
        String sql="Select * from Tipos order by descricao";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            TipoModel obj = new TipoModel(rs.getInt("id"),rs.getString("descricao"));
            dados.add(obj);
        }  
        return dados;
    }
}
