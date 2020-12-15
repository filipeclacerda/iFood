/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MetodoPagamentoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Filipe Lacerda
 */
public class MetodoPagamento {

    private int idMetodoPagamento;
    private String nomeMetodoPagamento;

    public MetodoPagamento(int idMetodoPagamento, String nomeMetodoPagamento) {
        this.idMetodoPagamento = idMetodoPagamento;
        this.nomeMetodoPagamento = nomeMetodoPagamento;
    }

    public int getIdMetodoPagamento() {
        return idMetodoPagamento;
    }

    public void setIdMetodoPagamento(int idMetodoPagamento) {
        this.idMetodoPagamento = idMetodoPagamento;
    }

    public String getNomeMetodoPagamento() {
        return nomeMetodoPagamento;
    }

    public void setNomeMetodoPagamento(String nomeMetodoPagamento) {
        this.nomeMetodoPagamento = nomeMetodoPagamento;
    }

    public static MetodoPagamento obterMetodoPagamento(int codMetodoPagamento)
            throws ClassNotFoundException, SQLException {
        return MetodoPagamentoDAO.getInstancia().obterMetodoPagamento(codMetodoPagamento);
    }

    public static List<MetodoPagamento> obterMetodoPagamentos()
            throws ClassNotFoundException, SQLException {
        return MetodoPagamentoDAO.getInstancia().obterMetodoPagamentos();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        MetodoPagamentoDAO.getInstancia().gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        MetodoPagamentoDAO.getInstancia().alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        MetodoPagamentoDAO.getInstancia().excluir(this);
    }

}
