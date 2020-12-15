/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public abstract class CupomAbstract {

    protected Desconto desconto;
    protected String nome;
    


    public String getNome() {
        return nome;
    }

    public float obterDesconto(){
        return desconto.obterDesconto();
    }
    public String getNomeDesconto(){
        return desconto.getNomeDesconto();
    }


}

