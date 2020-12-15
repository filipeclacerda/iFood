/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ClienteDAO;
import dao.CupomDAO;
import dao.MetodoPagamentoDAO;
import dao.PedidoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class Pedido {

    private Integer numero;
    private Cliente cliente;
    private MetodoPagamento metodoPagamento;
    private Cupom cupom;
    private Date dataPedido;
    private String nomeEstado;
   
    private String observacao;
    private Float troco;
    private Float valorTotal;
    private ArrayList<ItemPedido> itensPedido;
    private PedidoEstado pedidoEstado;
    private Integer codCliente = 0;

    public Integer getIdMetodoPagamento() {
        return idMetodoPagamento;
    }

    public void setIdMetodoPagamento(Integer idMetodoPagamento) {
        this.idMetodoPagamento = idMetodoPagamento;
    }

    public Integer getIdCupom() {
        return idCupom;
    }

    public void setIdCupom(Integer idCupom) {
        this.idCupom = idCupom;
    }
    private Integer idMetodoPagamento=0;
    private Integer idCupom=0;

    public Pedido() {
        this.itensPedido = new ArrayList<ItemPedido>();
        this.pedidoEstado = new PedidoEstadoRecebido();
    }

    public Pedido(Integer numero, String observacao, float troco, Cliente cliente, Cupom cupom, MetodoPagamento metodoPagamento, Date dataPedido, Float valorTotal, PedidoEstado pedidoEstado, ArrayList<ItemPedido> itensPedido) {
        this.numero = numero;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
        this.itensPedido = itensPedido;
        this.pedidoEstado = pedidoEstado;
        this.metodoPagamento = metodoPagamento;
        this.cupom = cupom;
        this.observacao = observacao;
        this.troco = troco;
        
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        if ((this.codCliente != 0) && (this.cliente == null)) {
            try {
                this.cliente = ClienteDAO.getInstancia().obterCliente(this.codCliente);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ArrayList<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(ArrayList<ItemPedido> itensVenda) {
        this.itensPedido = itensPedido;
    }
    
    public void adicionarItem(ItemPedido item) {
        this.itensPedido.add(item);
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public PedidoEstado getPedidoEstado() {
        return pedidoEstado;
    }

    public void setPedidoEstado(PedidoEstado pedidoEstado) {
        this.pedidoEstado = pedidoEstado;
    }
    
    public String getNomeEstado() {
        return this.pedidoEstado.getNome();
    }
    
     public MetodoPagamento getMetodoPagamento() {
          if ((this.idMetodoPagamento != 0) && (this.metodoPagamento == null)) {
            try {
                this.metodoPagamento = MetodoPagamentoDAO.getInstancia().obterMetodoPagamento(this.idMetodoPagamento);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Cupom getCupom() {
          if ((this.idCupom != 0) && (this.cupom == null)) {
            try {
                this.cupom = CupomDAO.getInstancia().obterCupom(this.idCupom);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Float getTroco() {
        return troco;
    }

    public void setTroco(Float troco) {
        this.troco = troco;
    }

    public static Pedido obterPedido(int numero)
            throws ClassNotFoundException, SQLException {
        return PedidoDAO.getInstancia().obterPedido(numero);
    }

    public static List<Pedido> obterPedidos()
            throws ClassNotFoundException, SQLException {
        return PedidoDAO.getInstancia().obterPedidos();
    }

    public boolean receber() {
        return this.pedidoEstado.receber(this);
    }

    public boolean preparar() {
        return this.pedidoEstado.preparar(this);
    }

    public boolean enviar() {
        return this.pedidoEstado.enviar(this);
    }

    public boolean entregar() {
        return this.pedidoEstado.entregar(this);
    }

    public boolean cancelar() {
        return this.pedidoEstado.cancelar(this);
    }

    public int gravar() throws ClassNotFoundException, SQLException {
        return PedidoDAO.getInstancia().gravar(this);
    }
    
    public void alterarEstado() throws SQLException, ClassNotFoundException {
        PedidoDAO.getInstancia().alterarEstado(this);
    }
    
}
