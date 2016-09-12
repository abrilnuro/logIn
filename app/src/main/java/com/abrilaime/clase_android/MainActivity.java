package com.abrilaime.clase_android;

import android.animation.IntArrayEvaluator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editNombre;
    private EditText  editEdad;
    private EditText  editCiudad;
    private Button buttonSubmit;

    private ImageView imageSubmit;
    private ImageView imageIcon1;
    private ImageView imageIcon2;
    private ImageView imageIcon3;

    String nombre;
    String edad;
    String ciudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNombre = (EditText) findViewById(R.id.edit_nombre);
        editEdad = (EditText) findViewById(R.id.edit_Edad);
        editCiudad = (EditText) findViewById(R.id.edit_ciudad);
        buttonSubmit = (Button) findViewById(R.id.button_submit);

        imageSubmit = (ImageView)findViewById(R.id.image_submit);
        imageIcon1 = (ImageView)findViewById(R.id.image_icon_1);
        imageIcon2 = (ImageView)findViewById(R.id.image_icon_2);
        imageIcon3 = (ImageView)findViewById(R.id.image_icon_3);

        imageIcon1.setOnClickListener(this);
        imageIcon2.setOnClickListener(this);
        imageIcon3.setOnClickListener(this);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = editNombre.getText().toString();
                edad = editEdad.getText().toString();
                ciudad = editCiudad.getText().toString();

                //crear un bitmap con el imageSubmit
                Bitmap image = ((BitmapDrawable)imageSubmit.getDrawable()).getBitmap();

                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("edad", edad);
                intent.putExtra("ciudad", ciudad);
                intent.putExtra("foto", image);
                startActivity(intent);

                onBackPressed();
            }
        });

    }//onCreate

    @Override
    public void onClick(View v) {
        if(v == imageIcon1){
            Drawable drawable = getResources().getDrawable(R.drawable.heart_pink);
            imageSubmit.setImageDrawable(drawable);
        }
        else if(v == imageIcon3){
            imageSubmit.setImageResource(R.drawable.heart_blue);
        }
        else if(v == imageIcon2){
            imageSubmit.setImageResource(R.drawable.heart_yellow);
        }
    }
}//class
