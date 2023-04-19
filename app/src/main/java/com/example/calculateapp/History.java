package com.example.calculateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        TextView historyTextView = findViewById(R.id.historyTextView);
        Button clearButton = findViewById(R.id.history_clear_button);

        SharedPreferences prefs = getSharedPreferences("history", MODE_PRIVATE);
        String history = prefs.getString("history", "");
        historyTextView.setText(history);

        setBackButtonListener();

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("history", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("history", "");
                editor.apply();
                historyTextView.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem historyMenuItem = menu.findItem(R.id.menu_history);
        historyMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(History.this, History.class);
                startActivity(intent);
                return true;
            }
        });
        return true;
    }

    private void setBackButtonListener() {
        Button backButton = findViewById(R.id.history_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(History.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}