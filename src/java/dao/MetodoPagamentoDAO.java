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
import model.MetodoPagamento;
/**
 *
 * @author Filipe Lacerda
 */
public class MetodoPagamentoDAO  extends DAO{
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



    private static MetodoPagamentoDAO instancia = new MetodoPagamentoDAO();

    public static MetodoPagamentoDAO getInstancia() {
        return instancia;
    }

    private MetodoPagamentoDAO() {
    }

    public MetodoPagamento obterMetodoPagamento(int codMetodoPagamento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        MetodoPagamento metodoPagamento = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from metodoPagamento where idmetodoPagamento = " + codMetodoPagamento);
            rs.first();
            metodoPagamento = instanciarMetodoPagamento(rs);   
        } finally {
            fecharConexao(conexao, comando);
        }
        return metodoPagamento;
    }

    public List<MetodoPagamento> obterMetodoPagamentos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<MetodoPagamento> metodoPagamentos = new ArrayList<MetodoPagamento>();
        MetodoPagamento metodoPagamento = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from metodoPagamento");
            while (rs.next()) {
                metodoPagamento = instanciarMetodoPagamento(rs);
                metodoPagamentos.add(metodoPagamento);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return metodoPagamentos;
    }

    public MetodoPagamento instanciarMetodoPagamento(ResultSet rs) throws SQLException {
        MetodoPagamento metodoPagamento = new MetodoPagamento(
                rs.getInt("idmetodoPagamento"),
                rs.getString("nomemetodo")                                       
        );
        return metodoPagamento;
    }
    
    public void gravar(MetodoPagamento metodoPagamento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement(
                    "insert into metodoPagamento (idmetodoPagamento, nomemetodo) values (?,?)");
            comando.setInt(1, metodoPagamento.getIdMetodoPagamento());
            comando.setString(2, metodoPagamento.getNomeMetodoPagamento());         
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public void alterar(MetodoPagamento metodoPagamento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            stringSQL = "update metodoPagamento set "
                    + "nomemetodo = '" + metodoPagamento.getNomeMetodoPagamento() + "' "
                    + "where idmetodoPagamento = " + metodoPagamento.getIdMetodoPagamento();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public void excluir(MetodoPagamento metodoPagamento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from metodoPagamento where idmetodoPagamento = "
                    + metodoPagamento.getIdMetodoPagamento();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
}

    
