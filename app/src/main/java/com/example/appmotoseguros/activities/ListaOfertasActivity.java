package com.example.appmotoseguros.activities;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.appmotoseguros.R;
import com.example.appmotoseguros.adapter.AdapterOfertas;
import com.example.appmotoseguros.api.controllers.OfertaApiController;
import com.example.appmotoseguros.api.request.CadastroRequest;
import com.example.appmotoseguros.model.Comprador;
import com.example.appmotoseguros.model.Ofertas;
import com.example.appmotoseguros.model.Veiculo;
import com.example.appmotoseguros.model.Vendedor;
import com.example.appmotoseguros.utils.RVHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ListaOfertasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Ofertas> listaofertas = new ArrayList<>();

    public TextView textItensQtd;
//    private TextView textItensTotal;

    private AdapterOfertas adapterOfertas;

    private SVProgressHUD progressHUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ofertas);

        configuraActionBar();

        inicializacaoDosCampos();

        inicializacaoListener();
    }

    private void configuraActionBar() {
        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");

    }

    @SuppressLint("SetTextI18n")
    private void inicializacaoDosCampos() {
        progressHUD = new SVProgressHUD(this);

        recyclerView = findViewById(R.id.recycleListaOfertas);

        //Configurar adapter
        adapterOfertas = new AdapterOfertas(this);

        //Configurar recycleview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterOfertas);
        recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));

        textItensQtd = findViewById(R.id.textItensQtd);
        //textItensTotal  = findViewById(R.id.textItensTotal);

        textItensQtd.setText("ITENS QTD. " + adapterOfertas.getItemCount() + " - R$ 0.00");

        //Lista Local de teste
        //criarOfertas();
        listarOfertas();
    }

    private void inicializacaoListener() {
        RVHelper.addTo(recyclerView).setOnItemClickListener((recyclerView, position, v) -> {

        });
    }

    private void criarOfertas() {

        Ofertas ofertas = new Ofertas("293", "Mapfre - Garantia Motor e Câmbio", "Regras de Recusa", "Regras de Recusa", "750.00", "32801");
        this.listaofertas.add(ofertas);

        ofertas = new Ofertas("294", "Mapfre - Garantia Motor e Cambio e Suspensão", "Regras de Recusa", "Regras de Recusa", "900.00", "32801");
        this.listaofertas.add(ofertas);

        ofertas = new Ofertas("295", "Mapfre - Motor, Cambio, Suspensão e Pane Eletrica", "Regras de Recusa", "Regras de Recusa", "1100.00", "32801");
        this.listaofertas.add(ofertas);

        ofertas = new Ofertas("296", "Dekra - Vistoria Veicular para Transferência", "Voucher para vistoria de compra e venda de veiculos", "Voucher p/ vistoria de compra e venda de veiculos", "120.00", "32801");
        this.listaofertas.add(ofertas);

        ofertas = new Ofertas("297", "Dekra - Vistoria Veicular Cautelar", "Voucher para vistoria cautelar", "Voucher para vistoria cautelar", "200.00", "32801");
        this.listaofertas.add(ofertas);
    }

    @SuppressLint({"CheckResult", "DefaultLocale", "SetTextI18n"})
    private void listarOfertas() {

        progressHUD.show();

        OfertaApiController controller = new OfertaApiController(this, getString(R.string.api_endpoint_dev), getResources());
        CadastroRequest request = new CadastroRequest();
        request.setComprador((Comprador)getIntent().getSerializableExtra("objeto_comprador"));
        request.setVeiculo((Veiculo)getIntent().getSerializableExtra("objeto_veiculo"));
        request.setVendedor(carregaVendedorTeste());
        Observable<List<Ofertas>> call = controller.obterOfertas(request);

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(authResponse -> {
                            adapterOfertas.addAll(authResponse);

//                            float total = 0.0f;
//
//                            for(Ofertas oferta : authResponse){
//                                float tempPrice = Float.parseFloat(oferta.getPreco().replaceAll("[^\\d.]", ""));
//                                total += tempPrice;
//                            }

//                            textItensQtd.setText("ITENS QTD. " + adapterOfertas.getItemCount() +
//                                    " - R$" + String.format("%.2f", adapterOfertas.precoFinal));

                            progressHUD.dismiss();
                        },
                        throwable -> {
                            progressHUD.dismiss();
                            Toast.makeText(ListaOfertasActivity.this, getString(R.string.msg_error_load_data), Toast.LENGTH_SHORT).show();
                        });
    }

    private void atualizaPreco(){

    }

    public void ChamaResumoCompra(View view) {
        Intent intent = new Intent(ListaOfertasActivity.this, PedidoActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //startActivity(new Intent(this, FormularioVeiculoQuestionarioActivity.class));
                //finishAffinity();
                onBackPressed();
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    private Vendedor carregaVendedorTeste(){
        Vendedor vendedor = new Vendedor();
        vendedor.setCpfCnpjVendedor("40442820135");
        vendedor.setNumeroCelularVendedor("11966100936");
        vendedor.setIdloja("104");

        return vendedor;
    }

    public void finalizaCompra(View view){

        //Instanciar o alertdialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        //configurar o titulo
        dialog.setTitle("FINALIZANDO A COMPRA");
        dialog.setMessage("Deseja finalizar sua compra?");
        //configura ações para sim e não
        dialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(
                        getApplicationContext(), "Passe o cartão!", Toast.LENGTH_SHORT
                ).show();

            }
        });

        dialog.setNegativeButton("Voltar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

    }
}
