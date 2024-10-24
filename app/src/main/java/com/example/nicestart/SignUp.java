package com.example.nicestart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.signup_activity);

        ImageView mBoy = findViewById(R.id.boy);
        Glide.with(this)
                        .load("https://f.fcdn.app/imgs/3832f5/www.celiafirpo.com.uy/fliluy/2b9d/original/catalogo/FRN012_FRN012_1/1920-1200/ramo-de-flores-naturales-gallerie-ramo-de-flores-naturales-gallerie.jpg")
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.CornflowerBlue)))
                .into(mBoy);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void openLogin(View view) {
        Intent intent1 = new Intent(SignUp.this, Login.class);
        startActivity(intent1);
    }

    public void openMain(View view) {
        Intent intent2 = new Intent(SignUp.this, Main.class);
        startActivity(intent2);
    }
}