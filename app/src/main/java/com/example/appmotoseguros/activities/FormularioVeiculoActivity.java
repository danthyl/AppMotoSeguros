package com.example.appmotoseguros.activities;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.appmotoseguros.R;
import com.example.appmotoseguros.api.request.CadastroRequest;
import com.example.appmotoseguros.model.Comprador;
import com.example.appmotoseguros.model.Endereco;
import com.example.appmotoseguros.model.PrincipalCondutor;
import com.example.appmotoseguros.model.Veiculo;

import java.util.Objects;

public class FormularioVeiculoActivity extends AppCompatActivity {

    private static final int PLACA_LETRA_MAX = 3;

    private EditText campoQuilometragem;
    private EditText campoPlacaNumero;
    private EditText campoPlacaLetra;
    private EditText campoRenavam;
    private ImageView imageFotoPainel;

    private Comprador comprador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_veiculo);

        configuraActionBar();

        inicializacaoDosCampos();

        camposListener();

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
        campoPlacaLetra.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (campoPlacaLetra.getText().length() == 3)
                    campoPlacaNumero.requestFocus();
                return false;
            }
        });

        imageFotoPainel = findViewById(R.id.imageViewFotoPainel);
        findViewById(R.id.imageViewFotoPainel).setOnClickListener(view -> tirarFoto());
    }

    private void camposListener() {

        campoPlacaLetra.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count < 3) campoPlacaLetra.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {
                Editable temp = s;

                if (temp.length() >= PLACA_LETRA_MAX) {
                    campoPlacaNumero.requestFocus();
                }
            }
        });
    }

    private void checaPermissoes() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }
    }

    public void ChamaFormularioQuestionario(View view) {
   //TODO     if(comprador != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("objeto_comprador", carregaCompradorTeste());
            Intent intent = new Intent(FormularioVeiculoActivity.this, FormularioVeiculoQuestionarioActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
//        } else {
//            Toast.makeText(this, "Precisamos dos dados do comprador, por favor preencha os dados.",
//                    Toast.LENGTH_SHORT).show();;
//        }
    }

    public void ChamaListaOfertasSemFormulario(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("objeto_comprador", carregaCompradorTeste());
        bundle.putSerializable("objeto_veiculo", carregaVeiculoTeste());
        Intent intent = new Intent(FormularioVeiculoActivity.this, ListaOfertasActivity.class);
        intent.putExtras(bundle);
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

    private Comprador carregaCompradorTeste() {
        Comprador comprador = new Comprador();
        comprador.setCpfCnpj("40442820135");
        comprador.setDatanascimento("15111991");
        comprador.setSexo("2");
        comprador.setEstadoCivil("1");

        Endereco endereco = new Endereco();
        endereco.setCep("07713305");
        endereco.setComplemento("Casa");
        endereco.setNumero("48");
        comprador.setEndereco(endereco);

        comprador.setNumeroCelular("11966200936");
        comprador.setPossuiOutroVeic("1");
        comprador.setTipoContratacao("1");
        comprador.setUtilizacaoDut("1");
        comprador.setTipoContratacao("3");
        comprador.setPergunta1("1");
        comprador.setPergunta2("1");
        comprador.setPergunta3("1");

        PrincipalCondutor principalCondutor = new PrincipalCondutor();
        principalCondutor.setCpfCnpj("40442820135");
        principalCondutor.setNome("Eric Aparecido da silva tunú");
        principalCondutor.setSexo("2");
        principalCondutor.setEstadoCivil("1");
        principalCondutor.setDatanascimento("15111991");
        comprador.setPrincipalCondutor(principalCondutor);

        return comprador;
    }

    private Veiculo carregaVeiculoTeste(){
        Veiculo veiculo = new Veiculo();
        veiculo.setComprovanteKilometragem("xxxxxxxxxxxxxxxxxxxx");
        veiculo.setKilometragem("34000");
        veiculo.setPlaca("FXR9915");
        veiculo.setRenavan("");
        veiculo.setNumeroChassi("");

        return veiculo;
    }
}
