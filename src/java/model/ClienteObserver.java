/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

package model;

import java.util.Observable;
import java.util.Observer;

public class ClienteObserver implements Observer {

    private Observable statusPedido;
    private String novoStatus;
    private String nome;

    public Observable getStatusPedido() {
        return statusPedido;
    }

    public ClienteObserver setStatusPedido(Observable statusPedido) {
        this.statusPedido = statusPedido;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public ClienteObserver setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteObserver(Observable statusPedido) {
        this.statusPedido = statusPedido;
        statusPedido.addObserver(this);
    }

    public void update(Observable statusPedidoSubject, Object arg1) {
        if (statusPedidoSubject instanceof PedidoObserver) {
            PedidoObserver statusPedido = (PedidoObserver) statusPedidoSubject;
            novoStatus = statusPedido.getStatus();
            System.out.println("Atenção " + getNome() + 
                    ", o seu pedido está: " + 
                    novoStatus);
        }
    }
    
}
*/