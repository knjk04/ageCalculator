package com.example.karan.agecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CalculatedAgeActivity extends AppCompatActivity {

    public static final String TAG = CalculatedAgeActivity.class.getSimpleName();
    private TextView mDaysTextView;
    private TextView mWeeksTextView;
    private TextView mMonthsTextView;
    private TextView mSecondsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated_age);

        final int DAYS_IN_A_YEAR = 365;
        final float WEEKS_IN_A_YEAR = 52.1429f;
        final int MONTHS_IN_A_YEAR = 12;
        final double SECONDS_IN_A_YEAR = 3.154e7;

        Intent intent = getIntent();
        String age = intent.getStringExtra("date");
        Log.d(TAG, age);

        mDaysTextView = findViewById(R.id.daysTextView);
        String strAgeInDays = " " + mDaysTextView.getText().toString();
        mDaysTextView.setText(age*DAYS_IN_A_YEAR + strAgeInDays);

        mWeeksTextView = findViewById(R.id.weeksTextView);
        String strAgeInWeeks = " " + mWeeksTextView.getText().toString();
        mWeeksTextView.setText(age*WEEKS_IN_A_YEAR + strAgeInWeeks);

        mMonthsTextView = findViewById(R.id.monthsTextView);
        String strAgeInMonths = " " + mMonthsTextView.getText().toString();
        mMonthsTextView.setText(age*MONTHS_IN_A_YEAR + strAgeInMonths);

        mSecondsTextView = findViewById(R.id.secondsTextView);
        String strAgeInSeconds = " " + mSecondsTextView.getText().toString();
        mSecondsTextView.setText(age*SECONDS_IN_A_YEAR + strAgeInSeconds);
    }
}
