package com.example.appmotoseguros.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appmotoseguros.R;
import com.example.appmotoseguros.api.session.SessionController;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Toast.makeText(this, "TOKEN: " + SessionController.getInstance().getToken(), Toast.LENGTH_SHORT).show();
    }

    public void ChamaFormularioComprador(View view) {
        Intent intent = new Intent(MenuActivity.this, FormularioCompradorActivity.class);
        startActivity(intent);
    }


}
