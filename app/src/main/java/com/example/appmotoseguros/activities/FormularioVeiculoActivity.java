package com.example.appmotoseguros.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.appmotoseguros.R;

public class FormularioVeiculoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_veiculo);

    }

    public void ChamaFormularioQuestionario(View view) {
        Intent intent = new Intent(FormularioVeiculoActivity.this, FormularioVeiculoQuestionarioActivity.class);
        startActivity(intent);
    }
}
