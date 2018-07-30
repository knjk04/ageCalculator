package com.example.karan.agecalculator;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Button button;

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        button = findViewById(R.id.confirmButton);

        //Set max date to be 3 years prior
        final int minAge = 3; //min age is 3 years old
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -minAge);
        datePicker.setMaxDate(cal.getTimeInMillis());


        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dayPicked = datePicker.getDayOfMonth();
                int monthPicked = datePicker.getMonth() + 1; //0 indexed
                int yearPicked = datePicker.getYear();
                final int selectedDates[] = {dayPicked, monthPicked, yearPicked};

                Log.d(TAG, "Day: " + dayPicked + ", Month: " + monthPicked + ", Year: " + yearPicked);
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);

                if (currentYear - yearPicked <= minAge) {
                    showErrorMsg(view);
                } else {
                    startCalc(selectedDates);
                }
            }
        });
    }

    private void showErrorMsg(View view) {
        Snackbar snackbar = Snackbar.make(view, "Sorry, you are too young " +
                "to use this app", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    private void startCalc(int[] selectedDates) {
        Intent intent = new Intent(this, CalculatedAgeActivity.class);
        intent.putExtra("dates", selectedDates);
        startActivity(intent);
    }
}