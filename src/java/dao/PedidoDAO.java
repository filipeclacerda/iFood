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
import model.ItemPedido;
import model.Pedido;
import model.PedidoEstado;

/**
 *
 * @author Marco
 */
public class PedidoDAO extends DAO {

    private static PedidoDAO instancia = new PedidoDAO();

    public static PedidoDAO getInstancia() {
        return instancia;
    }

    public Pedido obterPedido(int numero) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Pedido pedido = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from pedido where idpedido = " + numero);
            rs.first();
            pedido = instanciarPedido(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return pedido;
    }

    public List<Pedido> obterPedidos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Pedido> pedidos = new ArrayList<Pedido>();
        Pedido pedido = null;
        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from pedido");
            while (rs.next()) {
                pedido = instanciarPedido(rs);
                pedidos.add(pedido);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return pedidos;
    }

    public Pedido instanciarPedido(ResultSet rs) throws SQLException {
        Class classe = null;
        Object objeto = null;
        try {
            String status = rs.getString("status");
            classe = Class.forName("model.PedidoEstado" + rs.getString("status"));            
            objeto = classe.newInstance();
        } catch (Exception ex) {
        }

        Pedido pedido = new Pedido(
                rs.getInt("idpedido"),
                rs.getString("observacao"),
                rs.getFloat("troco"),
                null,
                null,
                null,                
                rs.getDate("datapedido"),
                rs.getFloat("valortotal"),                
                (PedidoEstado)objeto, 
                null);
        pedido.setCodCliente(rs.getInt("usuario_idusuario"));
        pedido.setIdCupom(rs.getInt("cupom_idcupom"));
        pedido.setIdMetodoPagamento(rs.getInt("metodopagamento_idmetodopagamento"));
        return pedido;
    }

    public int gravar(Pedido pedido) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        int id = 0;
        try {
            conexao = BD.getInstancia().getConexao();
            conexao.setAutoCommit(false);
            comando = conexao.prepareStatement(
                    "insert into pedido (observacao, troco, usuario_idusuario, cupom_idcupom, metodopagamento_idmetodopagamento, datapedido, valortotal, status) values (?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, pedido.getObservacao());
            comando.setFloat(2, pedido.getTroco());
            comando.setInt(3, pedido.getCliente().getCodigo());
            comando.setInt(4, pedido.getCupom().getIdCupom());
            comando.setInt(5, pedido.getMetodoPagamento().getIdMetodoPagamento());
            comando.setDate(6, new java.sql.Date(pedido.getDataPedido().getTime()));                 
            comando.setFloat(7, pedido.getValorTotal());
            comando.setString(8, pedido.getPedidoEstado().getNome());
            
            comando.executeUpdate();

            ResultSet rs = comando.getGeneratedKeys();
            id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            int num_item = 0;
            for (ItemPedido item : pedido.getItensPedido()) {
                comando = conexao.prepareStatement(
                        "insert into itempedido (idpedido, numitem, idproduto, quantidade, valorunitario) values (?,?,?,?,?)");
                num_item = num_item + 1;
                comando.setInt(1, id);
                comando.setInt(2, num_item);
                comando.setInt(3, item.getProduto().getCodigo());
                comando.setFloat(4, item.getQuantidade());
                comando.setFloat(5, item.getPrecoUnitario());
                comando.executeUpdate();
            }
            conexao.commit();
        } catch (SQLException e) {
            conexao.rollback();
        } finally {
            fecharConexao(conexao, comando);
        }
        return id;
    }
        
    public void alterarEstado(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getInstancia().getConexao();
            comando = conexao.createStatement();
            stringSQL = "update pedido set "
                    + "status = '" + pedido.getPedidoEstado().getNome() + "' "
                    + "where idpedido = " + pedido.getNumero();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    
}
