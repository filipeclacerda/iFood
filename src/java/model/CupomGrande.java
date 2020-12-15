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
public class CupomGrande extends CupomAbstract{
      public CupomGrande(){
        this.nome = "Cupom Grande";
        this.desconto = new Desconto20();
    }
    
}
