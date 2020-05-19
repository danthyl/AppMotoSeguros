package com.example.appmotoseguros.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appmotoseguros.R;
import com.example.appmotoseguros.api.controllers.LoginApiController;
import com.example.appmotoseguros.api.response.LoginResponse;
import com.example.appmotoseguros.api.session.SessionController;
import com.example.appmotoseguros.model.Usuario;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    private EditText campoUsuario;
    private EditText campoSenha;
    private Button botaoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (SessionController.getInstance() == null) {
            SessionController.initialize(this);
        }

        setupViews();

        setListeners();
    }

    private void setupViews() {
        campoUsuario = findViewById(R.id.editUsuario);
        campoSenha = findViewById(R.id.editSenha);
        botaoLogin = findViewById(R.id.buttonAcesso);
    }

    private void setListeners() {
        botaoLogin.setOnClickListener(v -> login());
    }

    @SuppressLint("CheckResult")
    private void login() {

        LoginApiController controller = new LoginApiController(this, getString(R.string.api_endpoint_dev),
                getResources());
        Observable<LoginResponse> call = controller.usuarioLogin(campoUsuario.getText().toString(), campoSenha.getText().toString());

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(authResponse -> {
                            Usuario usuario = new Usuario();
                            usuario.setToken(authResponse.getAccesstoken());
                            usuario.setNome(campoUsuario.getText().toString());
                            SessionController.getInstance().login(usuario);

                            carregaMenuPrincipal();
                        },
                        throwable -> {
                            Toast.makeText(LoginActivity.this, getString(R.string.msg_invalid_login), Toast.LENGTH_SHORT).show();
                        });
    }

    public void carregaMenuPrincipal() {
        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }
}
