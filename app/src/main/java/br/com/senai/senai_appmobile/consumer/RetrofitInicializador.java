package br.com.senai.senai_appmobile.consumer;

import br.com.senai.senai_appmobile.services.PedidoService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitInicializador {

    private final Retrofit retrofit;

    public RetrofitInicializador(){
        retrofit = new Retrofit.Builder()
                .baseUrl("br.com.senai.senai_appMobile")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public PedidoService getPedidoService() {

        return retrofit.create(PedidoService.class);
    }
}
