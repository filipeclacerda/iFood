/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.CategoriaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Filipe Lacerda
 */
public class Categoria {


    
    private int idCategoria;
    private String nomeCategoria;
    
    public Categoria(int idCategoria, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }
    
        public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

     public static Categoria obterCategoria(int idCategoria)
            throws ClassNotFoundException, SQLException {
        return CategoriaDAO.getInstancia().obterCategoria(idCategoria);
    }

    public static List<Categoria> obterCategorias()
            throws ClassNotFoundException, SQLException {
        return CategoriaDAO.getInstancia().obterCategorias();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        CategoriaDAO.getInstancia().gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        CategoriaDAO.getInstancia().alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        CategoriaDAO.getInstancia().excluir(this);
    }
}
