package com.example.nicestart;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main_activity);

        ImageView prof = findViewById(R.id.profileImg);
        Glide.with(this)
                        .load("https://uxwing.com/wp-content/themes/uxwing/download/peoples-avatars/default-profile-picture-female-icon.png")
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                //.centerCrop()
                .circleCrop() //CIRCULO
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.CornflowerBlue)))
                .into(prof);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}