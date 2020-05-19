package com.example.appmotoseguros.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.appmotoseguros.R;
import com.example.appmotoseguros.api.session.SessionController;

public class LaunchActivity extends AppCompatActivity {

    private SVProgressHUD progressHUD;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        progressHUD = new SVProgressHUD(this);
        progressHUD.show();

        final Context context = this;

        new Handler().postDelayed(() -> {
            if (SessionController.getInstance() == null) {
                SessionController.initialize(this);
            }

            if (SessionController.getInstance().getCurrentUser() == null ||
                    SessionController.getInstance().getCurrentUser().getToken() == null) {

                    progressHUD.dismiss();

                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                    finish();

            } else {

                progressHUD.dismiss();

                Intent intent = new Intent(context, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
