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
public class Produto {

    protected Estoque estoque;

    public void vender() {
        this.estoque.vender();
    }

    public Integer getQuantidade() {
        if (this.estoque != null) {
            return this.estoque.getQuantidade();
        } else {
            return 0;
        }
    }
}


