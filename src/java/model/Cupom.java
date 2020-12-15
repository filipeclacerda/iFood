/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.CupomDAO;
import java.sql.SQLException;
import java.util.List;

public class Cupom {


   
    private int idCupom;
    private String descricao;
    private float valor;
    
     public Cupom(int idCupom, String descricao, float valor) {
        this.idCupom = idCupom;
        this.descricao = descricao;
        this.valor = valor;
    }
   
         public int getIdCupom() {
        return idCupom;
    }

    public void setIdCupom(int idCupom) {
        this.idCupom = idCupom;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public static Cupom obterCupom(int codCliente)
            throws ClassNotFoundException, SQLException {
        return CupomDAO.getInstancia().obterCupom(codCliente);
    }

    public static List<Cupom> obterCupoms()
            throws ClassNotFoundException, SQLException {
        return CupomDAO.getInstancia().obterCupoms();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        CupomDAO.getInstancia().gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        CupomDAO.getInstancia().alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        CupomDAO.getInstancia().excluir(this);
    }
    
}

