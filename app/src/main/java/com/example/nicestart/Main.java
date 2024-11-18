package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class Main extends AppCompatActivity {
    private SwipeRefreshLayout swipeLayout;
    private WebView miVisorWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main_activity);

        WebView mycontext = findViewById(R.id.vistaweb);
        registerForContextMenu(mycontext);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        miVisorWeb = (WebView) findViewById(R.id.vistaweb);
        WebSettings webSettings = miVisorWeb.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            /*final ConstraintLayout mLayout=findViewById(R.id.main);
            Snackbar snackbar = Snackbar
                    .make(mLayout, "Que miedo!", Snackbar.LENGTH_SHORT);
            snackbar.show();*/
            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    public boolean onContextItemSelected(MenuItem item){
        int id=item.getItemId();
        if (id == R.id.item1) {
            Toast.makeText(this, "Item copied", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item2) {
            Toast.makeText(this, "Downloading item...", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        final ConstraintLayout mLayout=findViewById(R.id.main);

        if(id == R.id.item3){
            Snackbar snackbar = Snackbar
                    .make(mLayout, "Setting option", Snackbar.LENGTH_SHORT)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is done", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });
            snackbar.show();
        } else if (id==R.id.item4) {
            Intent intent=new Intent(this, Profile.class);
            startActivity(intent);
        } else if (id==R.id.item5) {
            showAlertDialogButtonClicked(Main.this);
        }
        return super.onOptionsItemSelected(item);
    }

    public void showAlertDialogButtonClicked(Main main){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Achtung!");
        builder.setMessage("Where do you go?");
        builder.setIcon(R.drawable.map_icon);
        builder.setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}