package com.example.appmotoseguros.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.appmotoseguros.R;

public class FormularioVeiculoQuestionarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_veiculo_questionario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("");//Sem título

    }

    public void ChamaListaOfertas(View view) {
        Intent intent = new Intent(FormularioVeiculoQuestionarioActivity.this, ListaOfertasActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, FormularioVeiculoQuestionarioActivity.class));
                finishAffinity();
                break;
            default:
                break;
        }
        return true;
    }
}
