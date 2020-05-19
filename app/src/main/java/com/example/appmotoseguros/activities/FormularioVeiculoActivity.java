package com.example.appmotoseguros.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.appmotoseguros.R;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class FormularioVeiculoActivity extends AppCompatActivity {

    private EditText campoQuilometragem;
    private EditText campoPlacaNumero;
    private EditText campoPlacaLetra;
    private EditText campoRenavam;
    private EditText campoFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_veiculo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("");//Sem título
        inicializacaoDosCampos();

        campoPlacaLetra.requestFocus();


    }



    public void ChamaFormularioQuestionario(View view) {
        Intent intent = new Intent(FormularioVeiculoActivity.this, FormularioVeiculoQuestionarioActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, FormularioCompradorActivity.class));
                finishAffinity();
                break;
            default:
                break;
        }
        return true;
    }

    private void inicializacaoDosCampos() {
        campoPlacaNumero = findViewById(R.id.editPlacaNumeros);
        campoPlacaLetra = findViewById(R.id.editPlacaLetras);
        campoRenavam = findViewById(R.id.editRenavam);
        campoQuilometragem = findViewById(R.id.editQuilo);
        //campoFoto = findViewById(R.id.imageViewFotoPainel);

    }
}
