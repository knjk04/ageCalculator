package com.example.karan.agecalculator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
//    private CalendarView calendarView;

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);

        TimeZone timeZone = TimeZone.getDefault();
//        datePicker.setMaxDate();



//        calendarView = findViewById(R.id.calendarView);
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
//                month++; //0 indexed
//                String date = day + "/" + month + "/" + year;
//                Log.d(TAG, "onSelectedDayChange: date : " + date);
//
//                int selectedDates[] = {day, month, year};
//                startCalc(selectedDates);
//            }
//        });
    }

    private void startCalc(int[] selectedDates) {
        Intent intent = new Intent(this, CalculatedAgeActivity.class);
//        intent.putExtra("date", date);
        intent.putExtra("dates", selectedDates);
        startActivity(intent);
    }
}
