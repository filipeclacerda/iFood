/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marco
 */
public class Cliente {



    private Integer codigo;
    private String nome;
    private String email;
    private String telefone;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    
    public Cliente(Integer codigo, String nome, String email, String telefone, String logradouro, String numero, String bairro, String cidade, String estado) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static Cliente obterCliente(int codCliente)
            throws ClassNotFoundException, SQLException {
        return ClienteDAO.getInstancia().obterCliente(codCliente);
    }

    public static List<Cliente> obterClientes()
            throws ClassNotFoundException, SQLException {
        return ClienteDAO.getInstancia().obterClientes();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        ClienteDAO.getInstancia().gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ClienteDAO.getInstancia().alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ClienteDAO.getInstancia().excluir(this);
    }
}
