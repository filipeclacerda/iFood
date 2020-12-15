/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class Combo extends Produto {
    private ArrayList<Produto> pecas;
    
    public Combo(Integer quantidade){
        this.pecas = new ArrayList();
    }
    
    public void addPeca(Produto produto) {
        this.pecas.add(produto);
    }
    
    public void vender(){
        for (Produto peca : this.pecas) {
            peca.vender();
        }
        
    }
}
