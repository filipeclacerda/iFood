/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.BD;
import dao.ProdutoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Marco
 */
public class ProdutoModel {

    private Integer codigo;
    private String nome;
    private Float preco;
    private String descricao;
    private Restaurante restaurante;
    private Categoria categoria;
    private int idRestaurante;
    private int idCategoria;

 


    public ProdutoModel(Integer codigo, String nome, Float preco, String descricao, Restaurante restaurante) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.restaurante = restaurante;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
       public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

     public Restaurante getRestaurante() throws ClassNotFoundException, SQLException{
        if((this.idRestaurante != 0) && (this.restaurante == null)){
            this.restaurante = Restaurante.obterRestaurante(this.idRestaurante);
            
        }
        return this.restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
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

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public static List<ProdutoModel> obterProdutos()
            throws ClassNotFoundException, SQLException {
        return ProdutoDAO.getInstancia().obterProdutoModels();
    }

    public static ProdutoModel obterProduto(int codProduto)
            throws ClassNotFoundException, SQLException {
        return ProdutoDAO.getInstancia().obterProdutoModel(codProduto);
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        ProdutoDAO.getInstancia().gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ProdutoDAO.getInstancia().alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ProdutoDAO.getInstancia().excluir(this);
    }

}
