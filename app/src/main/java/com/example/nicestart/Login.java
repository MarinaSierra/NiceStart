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

public class Login extends AppCompatActivity {
    EditText txt1, txt2;
    Button bot1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_activity);
        txt1=findViewById(R.id.username);
        txt2=findViewById(R.id.password);

        bot1=findViewById(R.id.button1);

        bot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Login.this, Profile.class);
                String value = txt1.getText().toString();
                intent2.putExtra("Nombre", value);
                startActivity(intent2);
            }
        });
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
}