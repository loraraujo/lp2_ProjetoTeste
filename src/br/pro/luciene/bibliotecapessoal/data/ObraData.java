/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.luciene.bibliotecapessoal.data;

import br.pro.luciene.bibliotecapessoal.model.CategoriaModel;
import br.pro.luciene.bibliotecapessoal.model.ObraModel;
import br.pro.luciene.bibliotecapessoal.model.TipoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static javax.swing.UIManager.getString;

/**
 *
 * @author lucienecavalcanti
 */
public class ObraData extends Conexao{
    public ObraData() throws Exception{}
    public boolean incluir(ObraModel obj) throws Exception{
        String sql="Insert into obras (descricao,ano,autor,local,idcategoria,idtipo) "
                + "values (?,?,?,?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getDescricao());
        ps.setInt(2, obj.getAno());
        ps.setString(3,obj.getAutor());
        ps.setString(4, obj.getLocal());
        ps.setInt(5, obj.getCategoria().getId());
        ps.setInt(6,obj.getTipo().getId());
        return ps.executeUpdate()>0;
    }

    public ArrayList<ObraModel> pesquisar(String texto) throws Exception{
        ArrayList<ObraModel> dados = new ArrayList<>();
        String[] palavras = texto.split(" ");
        String sql = "Select * from obras where ";
        for(int i=0;i<palavras.length;i++) {
            if(i>0 && i!= palavras.length) sql+= " or ";
            sql+= " descricao like '%"+palavras[i]+"%' or autor like '%"+palavras[i]+"%' ";
        }
        System.out.println(sql);
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            ObraModel obj = new ObraModel(rs.getInt("id"), 
                    rs.getString("descricao"), 
                    rs.getString("autor"), 
                    rs.getInt("ano"), 
                    rs.getString("local"), 
                    new CategoriaModel(rs.getInt("idcategoria"), ""), 
                    new TipoModel(rs.getInt("idtipo"), ""));
            dados.add(obj);
        }
        
        return dados;
    }
    public ArrayList<ObraModel> carregarCombo() throws Exception{
        ArrayList<ObraModel> dados = new ArrayList<>();
        String sql = "Select * from obras order by descricao";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            ObraModel obj = new ObraModel(rs.getInt("id"),
                    rs.getString("descricao"),
                    rs.getString("autor"),
                    rs.getInt("ano"),
                    rs.getString("local"),
                    new CategoriaModel(rs.getInt("idcategoria"), ""),
                    new TipoModel(rs.getInt("idtipo"), ""));
            dados.add(obj);
        }
        
        return dados;
    }
}
