package com.example.appmotoseguros.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appmotoseguros.R;

public class ResumoCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("");//Sem título

    }
}
