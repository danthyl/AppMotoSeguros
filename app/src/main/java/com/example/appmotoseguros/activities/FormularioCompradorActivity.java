package com.example.appmotoseguros.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appmotoseguros.activities.MenuActivity;
import com.example.appmotoseguros.R;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class FormularioCompradorActivity extends AppCompatActivity {

    private EditText campoCPFVendedor;
    private EditText campoCelularVendedor;
    private EditText campoCelularCliente;
    private EditText campoConfereCelularCliente;
    private EditText campoCPFCliente;
    private EditText campoCEPCliente;
    private EditText campoNumeroCliente;
    private EditText campoComplementoCliente;
    private EditText campoDataCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_comprador);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("");//Sem título
        inicializacaoDosCampos();

        SimpleMaskFormatter smfcc = new SimpleMaskFormatter("(NN)NNNNN-NNNN");
        MaskTextWatcher mtw = new MaskTextWatcher(campoCelularCliente, smfcc);
        campoCelularCliente.addTextChangedListener(mtw);

        SimpleMaskFormatter smfccc = new SimpleMaskFormatter("(NN)NNNNN-NNNN");
        MaskTextWatcher mtwccc = new MaskTextWatcher(campoConfereCelularCliente, smfccc);
        campoConfereCelularCliente.addTextChangedListener(mtwccc);

        SimpleMaskFormatter smfcv = new SimpleMaskFormatter("(NN)NNNNN-NNNN");
        MaskTextWatcher mtwv = new MaskTextWatcher(campoCelularVendedor, smfcv);
        campoCelularVendedor.addTextChangedListener(mtwv);

        SimpleMaskFormatter cpfc = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtwcpfcliente = new MaskTextWatcher(campoCPFCliente, cpfc);
        campoCPFCliente.addTextChangedListener(mtwcpfcliente);

        SimpleMaskFormatter cpfv = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtwcpfvendedor = new MaskTextWatcher(campoCPFVendedor, cpfv);
        campoCPFVendedor.addTextChangedListener(mtwcpfvendedor);

        SimpleMaskFormatter cep = new SimpleMaskFormatter("NNNNN-NNN");
        MaskTextWatcher mtwcep = new MaskTextWatcher(campoCEPCliente, cep);
        campoCEPCliente.addTextChangedListener(mtwcep);

        SimpleMaskFormatter data = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher mtwdata = new MaskTextWatcher(campoDataCliente, data);
        campoDataCliente.addTextChangedListener(mtwdata);

    }

    public void ChamaFormularioVeiculo(View view) {
        Intent intent = new Intent(FormularioCompradorActivity.this, FormularioVeiculoActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, MenuActivity.class));
                finishAffinity();
                break;
            default:
                break;
        }
        return true;
    }

    private void inicializacaoDosCampos() {
        campoCPFVendedor = findViewById(R.id.editCpfVendedor);
        campoCelularVendedor = findViewById(R.id.editCelularVendedor);
        campoConfereCelularCliente = findViewById(R.id.editConfereCelularCliente);
        campoCelularCliente = findViewById(R.id.editCelularCliente);
        campoCPFCliente = findViewById(R.id.editCpfCliente);
        campoCEPCliente = findViewById(R.id.editCepCliente);
        campoNumeroCliente = findViewById(R.id.editNumeroCliente);
        campoComplementoCliente = findViewById(R.id.editComplementoCliente);
        campoDataCliente = findViewById(R.id.editDataNascimento);

    }
}
