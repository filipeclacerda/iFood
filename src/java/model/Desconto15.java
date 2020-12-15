/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Desconto15 implements Desconto{
    public float obterDesconto(){
        return (15);
    }
    public String getNomeDesconto(){
        return "15 reais de desconto";
    }
}
