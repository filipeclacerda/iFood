/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Marco
 */
public class Lanche extends Produto {
    
    public Lanche(Integer quantidade){
        this.estoque = new Estoque(quantidade);
    }
    
}
