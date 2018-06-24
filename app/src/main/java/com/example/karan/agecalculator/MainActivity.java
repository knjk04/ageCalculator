package com.example.karan.agecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ageField;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ageField = findViewById(R.id.ageEditText);
        confirmButton = findViewById(R.id.confirmButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ageYears = Integer.parseInt(ageField.getText().toString());
//                Toast.makeText(MainActivity.this, ageYears+"", Toast.LENGTH_LONG).show();

                startCalc(ageYears);
            }
        });
    }

    private void startCalc(int ageYears) {
        Intent intent = new Intent(this, CalculatedAgeActivity.class);
        intent.putExtra("age", ageYears);
        startActivity(intent);
    }
}
