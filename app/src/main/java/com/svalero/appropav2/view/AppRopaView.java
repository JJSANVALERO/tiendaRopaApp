package com.svalero.appropav2.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.appropav2.R;

public class AppRopaView extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeMainScreen();

    }

    private void initializeMainScreen() {
        Button viewMapButton = findViewById(R.id.viewArticulosButton);
        viewMapButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.viewArticulosButton) {
            Intent intent = new Intent(this, ArticulosListView.class);
            startActivity(intent);
        }
    }



}
