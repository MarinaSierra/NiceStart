package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
public class Profile extends AppCompatActivity {
    TextView texto;
    //Button edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.profile_activity);

        ImageView prof = findViewById(R.id.profileImg);
        Glide.with(this)
                        .load("https://uxwing.com/wp-content/themes/uxwing/download/peoples-avatars/default-profile-picture-female-icon.png")
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                //.centerCrop()
                .circleCrop() //CIRCULO
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.CornflowerBlue)))
                .into(prof);
        texto=findViewById(R.id.name);
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("Nombre");
        texto.setText(nombre);

        /*edit=findViewById(R.id.editar);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });*/
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}