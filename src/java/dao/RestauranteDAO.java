/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Restaurante;


/**
 *
 * @author Marco
 */
public class RestauranteDAO extends DAO {

    private static RestauranteDAO instancia = new RestauranteDAO();

    public static RestauranteDAO getInstancia() {
        return instancia;
    }

    public Restaurante obterRestaurante(int numero) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Restaurante restaurante = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from restaurante where idrestaurante = " + numero);
            rs.first();
            restaurante = instanciarRestaurante(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return restaurante;
    }

    public List<Restaurante> obterRestaurantes() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Restaurante> restaurantes = new ArrayList<Restaurante>();
        Restaurante restaurante = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from restaurante");
            while (rs.next()) {
                restaurante = instanciarRestaurante(rs);
                restaurantes.add(restaurante);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return restaurantes;
    }

    public Restaurante instanciarRestaurante(ResultSet rs) throws SQLException {
        Class classe = null;    
        Restaurante restaurante = new Restaurante(
                rs.getInt("idrestaurante"),
                rs.getString("nomeRestaurante"),
                null);
        restaurante.setIdCategoria(rs.getInt("categoria_idcategoria"));
        return restaurante;
    }

    public void gravar(Restaurante restaurante) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement(
                    "insert into restaurante (idrestaurante, nomerestaurante, categoria_idcategoria) values (?,?,?)");
            comando.setInt(1, restaurante.getIdRestaurante());
            comando.setString(2, restaurante.getNomeRestaurante());
            comando.setInt(3, restaurante.getCategoria().getIdCategoria());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    public void alterar(Restaurante restaurante) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            stringSQL = "update restaurante set "
                    + "nomerestaurante = '" + restaurante.getNomeRestaurante() + "', "
                    + "categoria_idcategoria = " + restaurante.getCategoria().getIdCategoria()+ " "
                    + "where idrestaurante = " + restaurante.getIdRestaurante();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public void excluir(Restaurante restaurante) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from restaurante where idrestaurante = "
                    + restaurante.getIdRestaurante();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
}


