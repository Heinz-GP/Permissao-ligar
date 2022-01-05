package com.example.atvavltv3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_telefonar;
    private Button btn_limpar;
    private EditText telefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            btn_telefonar = findViewById(R.id.btn_telefonar);
            btn_limpar = findViewById(R.id.btn_limpar);
            telefone = findViewById(R.id.numero);


            btn_telefonar.setOnClickListener(this);
            btn_limpar.setOnClickListener(this);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        try {
            if (view == btn_limpar) {
                telefone.setText("");
            } else if (view == btn_telefonar) {
                String  numero = telefone.getText().toString();
                Uri uri = Uri.parse("tel:" + numero);

                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                if(ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    return;
                }
                startActivity(intent);
            }
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }



}