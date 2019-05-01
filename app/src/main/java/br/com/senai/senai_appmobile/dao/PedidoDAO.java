package br.com.senai.senai_appmobile.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.senai_appmobile.model.Pedido;

public class PedidoDAO {

    private final static List<Pedido> pedidos = new ArrayList<>();

    public void salva(Pedido pedido) {
        pedidos.add(pedido);

    }

    public List<Pedido> allPedidos() {
        return new ArrayList<>(pedidos);
    }
}
