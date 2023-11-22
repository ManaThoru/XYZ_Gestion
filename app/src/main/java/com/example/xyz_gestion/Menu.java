package com.example.xyz_gestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    private TextView Resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Resultado = findViewById(R.id.txt_resul);
        String nombreUsuario = getIntent().getStringExtra("Usuario");
        Resultado.setText("Bienvenido(a) " + nombreUsuario);

    }
    public void Inven(View view){
        Intent inven = new Intent(Menu.this, Inventario.class);
        startActivity(inven);
    }

}