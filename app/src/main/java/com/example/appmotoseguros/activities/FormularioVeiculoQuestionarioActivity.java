package com.example.appmotoseguros.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appmotoseguros.R;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.Objects;

public class FormularioVeiculoQuestionarioActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText campoCPFCondutor, campoDataCondutor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_veiculo_questionario);

        configuraActionBar();

        inicializacaoDosCampos();

        inicializacaoMascaras();
    }

    private void configuraActionBar() {
        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");
    }

    private void inicializacaoDosCampos() {
        campoCPFCondutor = findViewById(R.id.editCpfCondutor);
        campoDataCondutor = findViewById(R.id.editDataCondutor);

        Spinner spinnerestadocivilcondutor = findViewById(R.id.spinnerEstadoCivilCondutor);
        ArrayAdapter<CharSequence> adapterestadocivilcondutor = ArrayAdapter.createFromResource(
                this, R.array.Spinner_estado_civil,
                android.R.layout.simple_spinner_item
        );
        adapterestadocivilcondutor.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
        spinnerestadocivilcondutor.setAdapter(adapterestadocivilcondutor);
        spinnerestadocivilcondutor.setOnItemSelectedListener(this);

        Spinner spinnergenerocondutor = findViewById(R.id.spinnerGeneroCondutor);
        ArrayAdapter<CharSequence> adaptergenerocondutor = ArrayAdapter.createFromResource(
                this, R.array.Spinner_genero,
                android.R.layout.simple_spinner_item
        );
        adaptergenerocondutor.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
        spinnergenerocondutor.setAdapter(adaptergenerocondutor);
        spinnergenerocondutor.setOnItemSelectedListener(this);

        Spinner spinnerpergunta1 = findViewById(R.id.spinnerPergunta1);
        ArrayAdapter<CharSequence> adapterpergunta1 = ArrayAdapter.createFromResource(
                this, R.array.Spinner_pergunta1,
                android.R.layout.simple_spinner_item
        );
        adapterpergunta1.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
        spinnerpergunta1.setAdapter(adapterpergunta1);
        spinnerpergunta1.setOnItemSelectedListener(this);

        Spinner spinnerpergunta2 = findViewById(R.id.spinnerPergunta2);
        ArrayAdapter<CharSequence> adapterpergunta2 = ArrayAdapter.createFromResource(
                this, R.array.Spinner_pergunta2,
                android.R.layout.simple_spinner_item
        );
        adapterpergunta2.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
        spinnerpergunta2.setAdapter(adapterpergunta2);
        spinnerpergunta2.setOnItemSelectedListener(this);

        Spinner spinnerpergunta3 = findViewById(R.id.spinnerPergunta3);
        ArrayAdapter<CharSequence> adapterpergunta3 = ArrayAdapter.createFromResource(
                this, R.array.Spinner_pergunta3,
                android.R.layout.simple_spinner_item
        );
        adapterpergunta3.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
        spinnerpergunta3.setAdapter(adapterpergunta3);
        spinnerpergunta3.setOnItemSelectedListener(this);

        Spinner spinnertipoutilizacao = findViewById(R.id.spinnerTipoUtilizacao);
        ArrayAdapter<CharSequence> adaptertipoutilizacao = ArrayAdapter.createFromResource(
                this, R.array.Spinner_tipoUtilizacao,
                android.R.layout.simple_spinner_item
        );
        adaptertipoutilizacao.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
        spinnertipoutilizacao.setAdapter(adaptertipoutilizacao);
        spinnertipoutilizacao.setOnItemSelectedListener(this);
    }

    private void inicializacaoMascaras() {
        SimpleMaskFormatter cpfc = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtwcpfcliente = new MaskTextWatcher(campoCPFCondutor, cpfc);
        campoCPFCondutor.addTextChangedListener(mtwcpfcliente);

        SimpleMaskFormatter datac = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher mtwdatacondutor = new MaskTextWatcher(campoDataCondutor, datac);
        campoDataCondutor.addTextChangedListener(mtwdatacondutor);
    }

    public void ChamaListaOfertas(View view) {
        Intent intent = new Intent(FormularioVeiculoQuestionarioActivity.this, ListaOfertasActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //startActivity(new Intent(this, FormularioVeiculoActivity.class));
                //finishAffinity();
                onBackPressed();
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
