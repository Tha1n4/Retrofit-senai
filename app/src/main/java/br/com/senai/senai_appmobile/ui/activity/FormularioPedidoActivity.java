package br.com.senai.senai_appmobile.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.senai.senai_appmobile.R;
import br.com.senai.senai_appmobile.consumer.RetrofitInicializador;
import br.com.senai.senai_appmobile.dao.PedidoDAO;
import br.com.senai.senai_appmobile.model.Pedido;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormularioPedidoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo Pedido";
    private EditText nomeCliente;
    private EditText dataPedido;
    private EditText valorPedido;
    private final PedidoDAO dao = new PedidoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_pedido);

        setTitle(TITULO_APPBAR);

        inicializacaoCampos();

        configuraBotaoSalvar();


    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_pedido_botao_salvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pedido pedidoCriado = getPedido();

                Call call = new RetrofitInicializador().getPedidoService().insere(pedidoCriado);

                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        Log.i("onResponse", "requisição realizada com sucesso");
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Log.e("on Failura", "A requisição solicitada falhou!");
                    }
                });

                salvar(pedidoCriado);

                startActivity(new Intent(FormularioPedidoActivity.this, ListaPedidosActivity.class));
            }
        });
    }

    private void inicializacaoCampos() {
        nomeCliente = findViewById(R.id.activity_formulario_pedido_cliente);
        dataPedido = findViewById(R.id.activity_formulario_pedido_data);
        valorPedido = findViewById(R.id.activity_formulario_pedido_valor);
    }

    private void salvar(Pedido pedidoCriado) {
        dao.salva(pedidoCriado);

        finish();
    }

    @NonNull
    private Pedido getPedido() {
        String nome = nomeCliente.getText().toString();
        String data = dataPedido.getText().toString();
        String valor = valorPedido.getText().toString();

        return new Pedido(nome, data, valor);
    }
}
