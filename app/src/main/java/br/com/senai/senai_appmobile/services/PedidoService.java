package br.com.senai.senai_appmobile.services;

import br.com.senai.senai_appmobile.model.Pedido;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface PedidoService {

    @GET("pedido")
    Call<Void> insere(@Body Pedido pedido);
}
