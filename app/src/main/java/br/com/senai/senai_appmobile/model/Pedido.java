package br.com.senai.senai_appmobile.model;

import android.support.annotation.NonNull;

public class Pedido {
    private final String nome;
    private final String data;
    private final String valor;

    public Pedido(String nome, String data, String valor) {
        this.nome = nome;
        this.data = data;
        this.valor = valor;
    }

   @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
