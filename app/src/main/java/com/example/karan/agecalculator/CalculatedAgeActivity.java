package com.example.karan.agecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class CalculatedAgeActivity extends AppCompatActivity {

    public static final String TAG = CalculatedAgeActivity.class.getSimpleName();
    private TextView mDaysTextView;
    private TextView mWeeksTextView;
    private TextView mMonthsTextView;
    private TextView mSecondsTextView;
    Calendar mNow = Calendar.getInstance();
    private int[] mDates;
    private static final int DAY_INDEX = 0;
    private static final int MONTH_INDEX = 1;
    private static final int YEAR_INDEX = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated_age);

        Intent intent = getIntent();
        mDates = intent.getIntArrayExtra("dates");

        mDaysTextView = findViewById(R.id.daysTextView);
        //using getText() to prepend onto it later
        String strAgeInDays = " " + mDaysTextView.getText().toString();
        mDaysTextView.setText(getDiffInDays() + strAgeInDays);

        mWeeksTextView = findViewById(R.id.weeksTextView);
        //using getText() to prepend onto it later
        String strAgeInWeeks = " " + mWeeksTextView.getText().toString();
        mWeeksTextView.setText(getDiffInWeeks() + strAgeInWeeks);

        mMonthsTextView = findViewById(R.id.monthsTextView);
        String strAgeInMonths = " " + mMonthsTextView.getText().toString();
        mMonthsTextView.setText(getDiffInMonths() + strAgeInMonths);

        mSecondsTextView = findViewById(R.id.secondsTextView);
        String strAgeInSeconds = " " + mSecondsTextView.getText().toString();
        mSecondsTextView.setText(getDiffInSeconds() + strAgeInSeconds);
    }

    public long getDiffInDays() {
        int currentMonth = mNow.get(Calendar.MONTH)+1; //+1 since months are 0 indexed
//        Log.d(TAG, "current month: " + currentMonth);

        int currentDayOfMonth = mNow.get(Calendar.DAY_OF_MONTH);
//        Log.d(TAG, "current day: " + currentDayOfYear);

        int currentYear = mNow.get(Calendar.YEAR);
//        Log.d(TAG, "current year: " + currentYear);

        LocalDate startDate = LocalDate.of(mDates[YEAR_INDEX], mDates[MONTH_INDEX], mDates[DAY_INDEX]);
        LocalDate endDate = LocalDate.of(currentYear, currentMonth, currentDayOfMonth);

        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
        Log.d(TAG, "days diff: " + daysDiff);

        return daysDiff;
    }

    public long getDiffInMonths() {
        int currentMonth = mNow.get(Calendar.MONTH)+1; //+1 since months are 0 indexed
//        Log.d(TAG, "current month: " + currentMonth);

        int currentDayOfMonth = mNow.get(Calendar.DAY_OF_MONTH);
//        Log.d(TAG, "current day: " + currentDayOfYear);

        int currentYear = mNow.get(Calendar.YEAR);
//        Log.d(TAG, "current year: " + currentYear);

        LocalDate startDate = LocalDate.of(mDates[YEAR_INDEX], mDates[MONTH_INDEX], mDates[DAY_INDEX]);
        LocalDate endDate = LocalDate.of(currentYear, currentMonth, currentDayOfMonth);

        long monthsDiff = ChronoUnit.MONTHS.between(startDate, endDate);
        Log.d(TAG, "months diff: " + monthsDiff);

        return monthsDiff;
    }

    public long getDiffInSeconds() {
        int currentMonth = mNow.get(Calendar.MONTH)+1; //+1 since months are 0 indexed
//        Log.d(TAG, "current month: " + currentMonth);

        int currentDayOfMonth = mNow.get(Calendar.DAY_OF_MONTH);
//        Log.d(TAG, "current day: " + currentDayOfYear);

        int currentYear = mNow.get(Calendar.YEAR);
//        Log.d(TAG, "current year: " + currentYear);

        LocalDateTime startDate = LocalDateTime.of(mDates[YEAR_INDEX], mDates[MONTH_INDEX],
                                                   mDates[DAY_INDEX], 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(currentYear, currentMonth, currentDayOfMonth,
                                                 mNow.get(Calendar.HOUR_OF_DAY),
                                                 mNow.get(Calendar.MINUTE),
                                                 mNow.get(Calendar.SECOND));

//        long secondsDiff = ChronoUnit.SECONDS.between(startDate, endDate);


        LocalDateTime temp = LocalDateTime.from(startDate);


        long secondsDiff = temp.until(endDate, ChronoUnit.SECONDS);
        Log.d(TAG, "seconds diff: " + secondsDiff);

        return secondsDiff;
    }

    public long getDiffInWeeks() {
        int currentMonth = mNow.get(Calendar.MONTH)+1; //+1 since months are 0 indexed
//        Log.d(TAG, "current month: " + currentMonth);

        int currentDayOfMonth = mNow.get(Calendar.DAY_OF_MONTH);
//        Log.d(TAG, "current day: " + currentDayOfYear);

        int currentYear = mNow.get(Calendar.YEAR);
//        Log.d(TAG, "current year: " + currentYear);

        LocalDate startDate = LocalDate.of(mDates[YEAR_INDEX], mDates[MONTH_INDEX], mDates[DAY_INDEX]);
        LocalDate endDate = LocalDate.of(currentYear, currentMonth, currentDayOfMonth);

        long weeksDiff = ChronoUnit.WEEKS.between(startDate, endDate);
        Log.d(TAG, "weeks diff: " + weeksDiff);

        return weeksDiff;
    }
}
