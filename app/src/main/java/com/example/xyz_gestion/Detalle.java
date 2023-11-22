package com.example.xyz_gestion;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Detalle extends AppCompatActivity {

    TextView detailtitulo, detailedito, detailiodioma;
    ImageView detailImage;
    FloatingActionButton deleteButton, editButton;
    String key = "";
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        detailtitulo = findViewById(R.id.detail_titulo);
        detailImage = findViewById(R.id.detailImage);
        detailedito = findViewById(R.id.detail_edito);
        deleteButton = findViewById(R.id.deleteButton);
        editButton = findViewById(R.id.editButton);
        detailiodioma = findViewById(R.id.detail_idio);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailedito.setText(bundle.getString("dataEditorial"));
            detailtitulo.setText(bundle.getString("dataTitulo"));
            detailiodioma.setText(bundle.getString("dataIdioma"));
            key = bundle.getString("Key");
            imageUrl = bundle.getString("dataImage");
            Glide.with(this).load(bundle.getString("dataImage")).into(detailImage);
        }
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Inventario");
                FirebaseStorage storage = FirebaseStorage.getInstance();

                StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
                storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        reference.child(key).removeValue();
                        Toast.makeText(Detalle.this, "Deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                });
            }
        });
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Detalle.this, Agregar.class)
                        .putExtra("dataTitulo", detailtitulo.getText().toString())
                        .putExtra("dataEditorial", detailedito.getText().toString())
                        .putExtra("dataIdioma", detailiodioma.getText().toString())
                        .putExtra("dataImage", imageUrl)
                        .putExtra("Key", key);
                startActivity(intent);
            }
        });
    }
}