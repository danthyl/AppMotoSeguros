package com.example.appmotoseguros.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.appmotoseguros.R;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.Objects;

public class FormularioVeiculoActivity extends AppCompatActivity {

    private EditText campoQuilometragem;
    private EditText campoPlacaNumero;
    private EditText campoPlacaLetra;
    private EditText campoRenavam;
    private ImageView imageFotoPainel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_veiculo);

        configuraActionBar();

        inicializacaoDosCampos();

        checaPermissoes();
    }

    private void configuraActionBar() {
        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");
    }

    private void inicializacaoDosCampos() {
        campoPlacaNumero = findViewById(R.id.editPlacaNumeros);
        campoPlacaLetra = findViewById(R.id.editPlacaLetras);
        campoRenavam = findViewById(R.id.editRenavam);
        campoQuilometragem = findViewById(R.id.editQuilo);

        campoPlacaLetra.requestFocus();

        imageFotoPainel = findViewById(R.id.imageViewFotoPainel);
        findViewById(R.id.imageViewFotoPainel).setOnClickListener(view -> tirarFoto());
    }

    private void checaPermissoes() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }
    }

    public void ChamaFormularioQuestionario(View view) {
        Intent intent = new Intent(FormularioVeiculoActivity.this, FormularioVeiculoQuestionarioActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //startActivity(new Intent(this, FormularioCompradorActivity.class));
                //finishAffinity();
                onBackPressed();
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    private void tirarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imagem = (Bitmap) extras.get("data");
            imageFotoPainel.setImageBitmap(imagem);
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}
