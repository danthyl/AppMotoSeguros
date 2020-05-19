package com.example.appmotoseguros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appmotoseguros.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private EditText campoUsuario;
    private EditText campoSenha;
    private Button botaoLogin;

    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        retrofit = new Retrofit.Builder()
                .baseUrl("http://ibug.westus.cloudapp.azure.com:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        campoUsuario = findViewById(R.id.editUsuario);
        campoSenha = findViewById(R.id.editSenha);
        botaoLogin = findViewById(R.id.buttonAcesso);



        /*botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

    }

    public void ChamaMenu(View view) {
        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(intent);
    }


}
