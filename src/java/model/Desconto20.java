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
public class Desconto20 implements Desconto{
    public float obterDesconto(){
        return (20);
    }
    public String getNomeDesconto(){
        return "20 reais de desconto";
    }
}
