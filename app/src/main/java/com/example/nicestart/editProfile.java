package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class editProfile extends AppCompatActivity {
    Button comfirm;
    EditText nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.edit_profile_activity);

        ImageView prof = findViewById(R.id.profileImg);
        Glide.with(this)
                .load("https://uxwing.com/wp-content/themes/uxwing/download/peoples-avatars/default-profile-picture-female-icon.png")
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                //.centerCrop()
                .circleCrop() //CIRCULO
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.CornflowerBlue)))
                .into(prof);

        ImageView userBanner = findViewById(R.id.banner);

        Glide.with(this)
                .load("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/10c67757-e4fa-43a1-a635-c0e7238be1de/dgtoqt5-300379bb-7164-4112-ab8b-8b669d633553.png/v1/fill/w_1280,h_285,q_80,strp/exclusive_profile_banner_3_by_sacredrebelartwerx_dgtoqt5-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzEwYzY3NzU3LWU0ZmEtNDNhMS1hNjM1LWMwZTcyMzhiZTFkZVwvZGd0b3F0NS0zMDAzNzliYi03MTY0LTQxMTItYWI4Yi04YjY2OWQ2MzM1NTMucG5nIiwiaGVpZ2h0IjoiPD0yODUiLCJ3aWR0aCI6Ijw9MTI4MCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS53YXRlcm1hcmsiXSwid21rIjp7InBhdGgiOiJcL3dtXC8xMGM2Nzc1Ny1lNGZhLTQzYTEtYTYzNS1jMGU3MjM4YmUxZGVcL3NhY3JlZHJlYmVsYXJ0d2VyeC00LnBuZyIsIm9wYWNpdHkiOjk1LCJwcm9wb3J0aW9ucyI6MC40NSwiZ3Jhdml0eSI6ImNlbnRlciJ9fQ.vtdNxfWXiSS2kMygPg-HnOIZtEJzTx6AltXXjjHetzk")
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                //.centerCrop()
                //.circleCrop() //CIRCULO
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.CornflowerBlue)))
                .into(userBanner);

        comfirm=findViewById(R.id.confirmar);
        nombre=findViewById(R.id.name);
        comfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = nombre.getText().toString();
                Intent intent = new Intent(editProfile.this, Profile.class);
                intent.putExtra("n", value);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}