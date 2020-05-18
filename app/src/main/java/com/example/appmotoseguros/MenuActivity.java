package com.example.appmotoseguros;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appmotoseguros.activities.FormularioCompradorActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void ChamaFormularioComprador(View view) {
        Intent intent = new Intent(MenuActivity.this, FormularioCompradorActivity.class);
        startActivity(intent);
    }


}
