package com.example.nicestart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.nicestart.ui.main.SectionsPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainBn extends AppCompatActivity {
    private MenuItem prevMenuItem;
    private SectionsPagerAdapter sectionsPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mainbn);

        sectionsPagerAdapter=new SectionsPagerAdapter(this, getSupportFragmentManager());

        ViewPager viewPager1 = findViewById(R.id.view_pager);
        viewPager1.setAdapter(sectionsPagerAdapter);
        // cast al xml
        BottomNavigationView mybottomNavView = findViewById(R.id.bottom_navigation);

        /*// crear badges
        BottomNavigationView bottomNavigationMenuView =
                (BottomNavigationView) mybottomNavView.getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(2);
        BottomNavigationView itemView = (BottomNavigationView) v;

        LayoutInflater.from(this)
                .inflate(R.layout.layout_badge, itemView, true);*/


        //here we listen to navigation across menu items and set the pager and the icon state checked
        mybottomNavView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.inicio){
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Inicio", Toast.LENGTH_SHORT).show();
                    viewPager1.setCurrentItem(0);
                } else if (item.getItemId()==R.id.biblioteca) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Biblioteca", Toast.LENGTH_SHORT).show();
                    viewPager1.setCurrentItem(1);
                } else if (item.getItemId()==R.id.anadir) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Añadir", Toast.LENGTH_SHORT).show();
                    viewPager1.setCurrentItem(2);
                } else if (item.getItemId()==R.id.menu) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Menu", Toast.LENGTH_SHORT).show();
                    viewPager1.setCurrentItem(3);
                }
                return false;
            }
        });


//        here we listen to viewpager moves and set navigations items checked or not


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

}

