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
import model.ProdutoModel;


/**
 *
 * @author Marco
 */
public class ProdutoDAO extends DAO {

    private static ProdutoDAO instancia = new ProdutoDAO();

    public static ProdutoDAO getInstancia() {
        return instancia;
    }

    private ProdutoDAO() {
    }

    public ProdutoModel obterProdutoModel(int codProdutoModel) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        ProdutoModel produto = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from produto where idproduto = " + codProdutoModel);
            rs.first();
            produto = instanciarProdutoModel(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return produto;
    }
    
    public List<ProdutoModel> obterProdutoModels() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ProdutoModel> produtos = new ArrayList<ProdutoModel>();
        ProdutoModel produto = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from produto");
            while (rs.next()) {
                produto = instanciarProdutoModel(rs);
                produtos.add(produto);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return produtos;
    }

    public ProdutoModel instanciarProdutoModel(ResultSet rs) throws SQLException {
        ProdutoModel produto = new ProdutoModel(
                rs.getInt("idproduto"),
                rs.getString("nomeproduto"),
                rs.getFloat("preco"),
                rs.getString("descricao"),
                null
        );
         produto.setIdRestaurante(rs.getInt("restaurante_idrestaurante"));
        return produto;
    }

    public void gravar(ProdutoModel produto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement(
                    "insert into produto (idproduto, nomeproduto, preco, descricao, restaurante_idrestaurante) values (?,?,?,?,?)");
            comando.setInt(1, produto.getCodigo());
            comando.setString(2, produto.getNome());
            comando.setFloat(3, produto.getPreco());
            comando.setString(4, produto.getDescricao());
            comando.setInt(5, produto.getRestaurante().getIdRestaurante());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public void alterar(ProdutoModel produto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            stringSQL = "update produto set "
                    + "nomeproduto = '" + produto.getNome() + "', "
                    + "preco = " + produto.getPreco() + ", "
                    + "restaurante_idrestaurante = " + produto.getRestaurante().getIdRestaurante()

                    + " where idproduto = " + produto.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public void excluir(ProdutoModel produto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from produto where idproduto = "
                    + produto.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
