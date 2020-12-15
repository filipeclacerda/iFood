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
import model.Cupom;
/**
 *
 * @author Filipe Lacerda
 */
public class CupomDAO  extends DAO{
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



    private static CupomDAO instancia = new CupomDAO();

    public static CupomDAO getInstancia() {
        return instancia;
    }

    private CupomDAO() {
    }

    public Cupom obterCupom(int codCupom) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Cupom cupom = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from cupom where idcupom = " + codCupom);
            rs.first();
            cupom = instanciarCupom(rs);   
        } finally {
            fecharConexao(conexao, comando);
        }
        return cupom;
    }

    public List<Cupom> obterCupoms() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Cupom> cupoms = new ArrayList<Cupom>();
        Cupom cupom = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from cupom");
            while (rs.next()) {
                cupom = instanciarCupom(rs);
                cupoms.add(cupom);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return cupoms;
    }

    public Cupom instanciarCupom(ResultSet rs) throws SQLException {
        Cupom cupom = new Cupom(
                rs.getInt("idcupom"),
                rs.getString("descricao"),
                rs.getFloat("valor")
        );
        return cupom;
    }
    
    public void gravar(Cupom cupom) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement(
                    "insert into cupom (idcupom, descricao, valor) values (?,?,?)");
            comando.setInt(1, cupom.getIdCupom());
            comando.setString(2, cupom.getDescricao());        
            comando.setFloat(3, cupom.getValor());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public void alterar(Cupom cupom) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            stringSQL = "update cupom set "
                    + "descricao = '" + cupom.getDescricao()+ "', "
                    + "valor = " + cupom.getValor()+ " "
                    + "where idcupom = " + cupom.getIdCupom();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public void excluir(Cupom cupom) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from cupom where idcupom = "
                    + cupom.getIdCupom();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
}

    
