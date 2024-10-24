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

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_activity);

        ImageView mGirl=findViewById(R.id.girl);
        Glide.with(this)
                        .load("https://media.revistaad.es/photos/61e6fa8210427c62e91838e8/1:1/w_3839,h_3839,c_limit/taisiia-stupak-SFYL9rFcLy0-unsplash.jpg")
                            .transition(DrawableTransitionOptions.withCrossFade(1000))
                                .centerCrop()
                //.circleCrop() CIRCULO
                                        //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.CornflowerBlue)))
                                                .into(mGirl);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void openSignUp(View view) {
        Intent intent1 = new Intent(Login.this, SignUp.class);
        startActivity(intent1);
    }

    public void openMain(View view) {
        Intent intent2 = new Intent(Login.this, Main.class);
        startActivity(intent2);
    }
}