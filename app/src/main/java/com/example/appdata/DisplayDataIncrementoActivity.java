package com.example.appdata;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class DisplayDataIncrementoActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.appdata.MESSAGE";
    private Data date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data_incremento);

        // get intent and message
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // date validation
        this.date = null;
        try {
            this.date = Data.fromString(message);
        } catch (IllegalArgumentException e) {
            this.sendMessage("Tente novamente");
        }

        // send to activity the correct date
        if (date != null) {
            this.setDateView();
        }
    }

    private void sendMessage(String message) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private void setDateView() {
        TextView dataView = findViewById(R.id.dataView);
        dataView.setText(this.date.toString());
    }

    public void onIncDay(View view) {
        this.date.incDay();
        this.setDateView();
    }

    public void onIncMonth(View view) {
        this.date.incMonth();
        this.setDateView();
    }

    public void onIncYear(View view) {
        this.date.incYear();
        this.setDateView();
    }
}