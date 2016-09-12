package com.abrilaime.clase_android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imageProfile;
    private TextView textNombre;
    private TextView textEdad;
    private TextView textCiudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //referenciacion
        imageProfile = (ImageView) findViewById(R.id.image_profile);
        textNombre = (TextView) findViewById(R.id.text_nombre);
        textEdad = (TextView) findViewById(R.id.text_edad);
        textCiudad = (TextView)findViewById(R.id.text_ciudad);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String edad = intent.getStringExtra("edad");
        String ciudad = intent.getStringExtra("ciudad");
        Bitmap foto = intent.getParcelableExtra("foto");

        textNombre.setText(nombre);
        textEdad.setText(edad);
        textCiudad.setText(ciudad);
        imageProfile.setImageBitmap(foto);
    }
}
