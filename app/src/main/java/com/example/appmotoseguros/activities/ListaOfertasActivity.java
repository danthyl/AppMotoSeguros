package com.example.appmotoseguros.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.appmotoseguros.R;
import com.example.appmotoseguros.adapter.AdapterOfertas;
import com.example.appmotoseguros.api.controllers.OfertaApiController;
import com.example.appmotoseguros.api.session.SessionController;
import com.example.appmotoseguros.model.Ofertas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ListaOfertasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Ofertas> listaofertas = new ArrayList<>();

    private AdapterOfertas adapterOfertas;

    private SVProgressHUD progressHUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ofertas);

        configuraActionBar();

        inicializacaoDosCampos();
    }

    private void configuraActionBar() {
        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");
    }

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

        //Lista Local de teste
        criarOfertas();
        //TODO listarOfertas();
    }

    private void criarOfertas() {

        Ofertas ofertas = new Ofertas("293", "Mapfre - Garantia Motor e Câmbio", "Regras de Recusa", "Regras de Recusa", new BigDecimal(750.00), "32801");
        this.listaofertas.add(ofertas);

        ofertas = new Ofertas("294", "Mapfre - Garantia Motor e Cambio e Suspensão", "Regras de Recusa", "Regras de Recusa", new BigDecimal(900.00), "32801");
        this.listaofertas.add(ofertas);

        ofertas = new Ofertas("295", "Mapfre - Motor, Cambio, Suspensão e Pane Eletrica", "Regras de Recusa", "Regras de Recusa", new BigDecimal(1100.00), "32801");
        this.listaofertas.add(ofertas);

        ofertas = new Ofertas("296", "Dekra - Vistoria Veicular para Transferência", "Voucher para vistoria de compra e venda de veiculos", "Voucher p/ vistoria de compra e venda de veiculos", new BigDecimal(120.00), "32801");
        this.listaofertas.add(ofertas);

        ofertas = new Ofertas("297", "Dekra - Vistoria Veicular Cautelar", "Voucher para vistoria cautelar", "Voucher para vistoria cautelar", new BigDecimal(200.00), "32801");
        this.listaofertas.add(ofertas);
    }

    @SuppressLint("CheckResult")
    private void listarOfertas() {

        progressHUD.show();

        OfertaApiController controller = new OfertaApiController(this, getString(R.string.api_endpoint_dev), getResources());
        Observable<List<Ofertas>> call = controller.obterOfertas();

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(authResponse -> {
                            adapterOfertas.addAll(authResponse);

                            progressHUD.dismiss();
                        },
                        throwable -> {
                            progressHUD.dismiss();
                            Toast.makeText(ListaOfertasActivity.this, getString(R.string.msg_invalid_login), Toast.LENGTH_SHORT).show();
                        });
    }

    public void ChamaResumoCompra(View view) {
        Intent intent = new Intent(ListaOfertasActivity.this, ResumoCompraActivity.class);
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
}
