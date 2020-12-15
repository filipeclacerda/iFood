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
import model.Cliente;

/**
 *
 * @author Marco
 */
public class ClienteDAO extends DAO {

    private static ClienteDAO instancia = new ClienteDAO();

    public static ClienteDAO getInstancia() {
        return instancia;
    }

    private ClienteDAO() {
    }

    public Cliente obterCliente(int codCliente) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Cliente cliente = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from usuario where idusuario = " + codCliente);
            rs.first();
            cliente = instanciarCliente(rs);   
        } finally {
            fecharConexao(conexao, comando);
        }
        return cliente;
    }

    public List<Cliente> obterClientes() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from usuario");
            while (rs.next()) {
                cliente = instanciarCliente(rs);
                clientes.add(cliente);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return clientes;
    }

    public Cliente instanciarCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente(
                rs.getInt("idusuario"),
                rs.getString("nomeusuario"),
                rs.getString("emailusuario"),
                rs.getString("telefone"),
                rs.getString("logradouro"),
                rs.getString("numero"),
                rs.getString("bairro"),
                rs.getString("cidade"),
                rs.getString("estado")                        
        );
        return cliente;
    }
    
    public void gravar(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.prepareStatement(
                    "insert into usuario (idusuario, nomeusuario, emailusuario, telefone, logradouro, numero, bairro, cidade, estado) values (?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, cliente.getCodigo());
            comando.setString(2, cliente.getNome());
            comando.setString(3, cliente.getEmail());
            comando.setString(4, cliente.getTelefone());
            comando.setString(5, cliente.getLogradouro());
            comando.setString(6, cliente.getNumero());
            comando.setString(7, cliente.getBairro());
            comando.setString(8, cliente.getCidade());
            comando.setString(9, cliente.getEstado());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public void alterar(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            stringSQL = "update usuario set "
                    + "nomeusuario = '" + cliente.getNome() + "', "
                    + "emailusuario = '" + cliente.getEmail() + "' "
                    + "where idusuario = " + cliente.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public void excluir(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from usuario where idusuario = "
                    + cliente.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
}
