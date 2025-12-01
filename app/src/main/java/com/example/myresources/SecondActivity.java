package com.example.myresources;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    DatePicker datePicker;
    Button btn;

    ProgressBar progressBar;
    Button btnProgress;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        datePicker = findViewById(R.id.datePicker);
        btn = findViewById(R.id.btnSelected);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day = "Day" + datePicker.getDayOfMonth();
                String month = "Month" + datePicker.getMonth();
                String year = "Year" + datePicker.getYear();

                Toast.makeText(SecondActivity.this,
                        day + "\n" + month + "\n" + year,
                        Toast.LENGTH_SHORT).show();


            }
        });

        btnProgress = findViewById(R.id.btnProgress);
        progressBar = findViewById(R.id.progressBar);

        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress = progress + 10;
                progressBar.setProgress(progress);
            }
        });
    }
}