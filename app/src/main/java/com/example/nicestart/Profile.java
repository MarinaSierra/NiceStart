package com.example.nicestart;

import android.content.Intent;
import android.media.Image;
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
    ImageView edit;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.profile_activity);

        ImageView ban = findViewById(R.id.profileBanner);
        Glide.with(this)
                .load("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/10c67757-e4fa-43a1-a635-c0e7238be1de/dgtoqt5-300379bb-7164-4112-ab8b-8b669d633553.png/v1/fill/w_1280,h_285,q_80,strp/exclusive_profile_banner_3_by_sacredrebelartwerx_dgtoqt5-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzEwYzY3NzU3LWU0ZmEtNDNhMS1hNjM1LWMwZTcyMzhiZTFkZVwvZGd0b3F0NS0zMDAzNzliYi03MTY0LTQxMTItYWI4Yi04YjY2OWQ2MzM1NTMucG5nIiwiaGVpZ2h0IjoiPD0yODUiLCJ3aWR0aCI6Ijw9MTI4MCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS53YXRlcm1hcmsiXSwid21rIjp7InBhdGgiOiJcL3dtXC8xMGM2Nzc1Ny1lNGZhLTQzYTEtYTYzNS1jMGU3MjM4YmUxZGVcL3NhY3JlZHJlYmVsYXJ0d2VyeC00LnBuZyIsIm9wYWNpdHkiOjk1LCJwcm9wb3J0aW9ucyI6MC40NSwiZ3Jhdml0eSI6ImNlbnRlciJ9fQ.vtdNxfWXiSS2kMygPg-HnOIZtEJzTx6AltXXjjHetzk")
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                //.centerCrop()
                //.circleCrop() //CIRCULO
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.CornflowerBlue)))
                .into(ban);

        ImageView prof = findViewById(R.id.profileImg);
        Glide.with(this)
                        .load("https://uxwing.com/wp-content/themes/uxwing/download/peoples-avatars/default-profile-picture-female-icon.png")
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                //.centerCrop()
                .circleCrop() //CIRCULO
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.CornflowerBlue)))
                .into(prof);


        edit=findViewById(R.id.editar);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(Profile.this, editProfile.class);
                startActivity(int2);
            }
        });
        texto=findViewById(R.id.name);
        Intent in = getIntent();
        String nombre = in.getStringExtra("n");
        texto.setText(nombre);

        b=findViewById(R.id.continuar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Profile.this, Main.class);
                startActivity(intent1);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}