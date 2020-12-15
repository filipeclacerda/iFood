/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.RestauranteDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Filipe Lacerda
 */
public class Restaurante {


    private int idRestaurante;
    private String nomeRestaurante;
    private Categoria categoria;
    private int idCategoria;
    
    
     public Restaurante(int idRestaurante, String nomeRestaurante, Categoria categoria) {
        this.idRestaurante = idRestaurante;
        this.nomeRestaurante = nomeRestaurante;
        this.categoria = categoria;
    }
     
     public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public Categoria getCategoria() throws ClassNotFoundException, SQLException{
        if((this.idCategoria != 0) && (this.categoria == null)){
            this.categoria = Categoria.obterCategoria(this.idCategoria);
            
        }
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
     public static Restaurante obterRestaurante(int codRestaurante)
            throws ClassNotFoundException, SQLException {
        return RestauranteDAO.getInstancia().obterRestaurante(codRestaurante);
    }

    public static List<Restaurante> obterRestaurantes()
            throws ClassNotFoundException, SQLException {
        return RestauranteDAO.getInstancia().obterRestaurantes();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        RestauranteDAO.getInstancia().gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        RestauranteDAO.getInstancia().alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        RestauranteDAO.getInstancia().excluir(this);
    }
    
}
