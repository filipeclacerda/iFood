/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;

/**
 *
 * @author Filipe Lacerda
 */
public class CategoriaDAO extends DAO{
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



    private static CategoriaDAO instancia = new CategoriaDAO();

    public static CategoriaDAO getInstancia() {
        return instancia;
    }

    private CategoriaDAO() {
    }

    public Categoria obterCategoria(int codCategoria) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Categoria categoria = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from categoria where idcategoria = " + codCategoria);
            rs.first();
            categoria = instanciarCategoria(rs);   
        } finally {
            fecharConexao(conexao, comando);
        }
        return categoria;
    }

    public List<Categoria> obterCategorias() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Categoria> categorias = new ArrayList<Categoria>();
        Categoria categoria = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from categoria");
            while (rs.next()) {
                categoria = instanciarCategoria(rs);
                categorias.add(categoria);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return categorias;
    }

    public Categoria instanciarCategoria(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria(
                rs.getInt("idcategoria"),
                rs.getString("nomecategoria")                                       
        );
        return categoria;
    }
    
    public void gravar(Categoria categoria) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement(
                    "insert into categoria (idcategoria, nomecategoria) values (?,?)");
            comando.setInt(1, categoria.getIdCategoria());
            comando.setString(2, categoria.getNomeCategoria());         
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public void alterar(Categoria categoria) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            stringSQL = "update categoria set "
                    + "nomecategoria = '" + categoria.getNomeCategoria() + "' "
                    + "where idcategoria = " + categoria.getIdCategoria();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public void excluir(Categoria categoria) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from categoria where idcategoria = "
                    + categoria.getIdCategoria();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
}

    
