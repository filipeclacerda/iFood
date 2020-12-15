/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Filipe Lacerda
 */
public class CupomPequeno extends CupomAbstract{
    
    public CupomPequeno(){
        this.nome = "Cupom Pequeno";
        this.desconto = new Desconto10();
    }
    
}
