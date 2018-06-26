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

import static com.example.karan.agecalculator.DifferenceIn.SECONDS;

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
        mDaysTextView.setText(getDiff(DifferenceIn.DAYS) + strAgeInDays);

        mWeeksTextView = findViewById(R.id.weeksTextView);
        //using getText() to prepend onto it later
        String strAgeInWeeks = " " + mWeeksTextView.getText().toString();
        mWeeksTextView.setText(getDiff(DifferenceIn.WEEKS) + strAgeInWeeks);

        mMonthsTextView = findViewById(R.id.monthsTextView);
        String strAgeInMonths = " " + mMonthsTextView.getText().toString();
        mMonthsTextView.setText(getDiff(DifferenceIn.MONTHS) + strAgeInMonths);

        mSecondsTextView = findViewById(R.id.secondsTextView);
        String strAgeInSeconds = " " + mSecondsTextView.getText().toString();
        mSecondsTextView.setText(getDiff(DifferenceIn.SECONDS) + strAgeInSeconds);
    }

    public long getDiff(DifferenceIn duration) {
        int currentMonth = mNow.get(Calendar.MONTH)+1; //+1 since months are 0 indexed
//        Log.d(TAG, "current month: " + currentMonth);

        int currentDayOfMonth = mNow.get(Calendar.DAY_OF_MONTH);
//        Log.d(TAG, "current day: " + currentDayOfYear);

        int currentYear = mNow.get(Calendar.YEAR);
//        Log.d(TAG, "current year: " + currentYear);

        LocalDate startDate = LocalDate.of(mDates[YEAR_INDEX], mDates[MONTH_INDEX], mDates[DAY_INDEX]);
        LocalDate endDate = LocalDate.of(currentYear, currentMonth, currentDayOfMonth);

        long diff = 0; //default value

        switch (duration) {
            case SECONDS:
                LocalDateTime startDateSec = LocalDateTime.of(mDates[YEAR_INDEX], mDates[MONTH_INDEX],
                        mDates[DAY_INDEX], 0, 0, 0);

                LocalDateTime endDateSec = LocalDateTime.of(currentYear, currentMonth,
                        currentDayOfMonth,
                        mNow.get(Calendar.HOUR_OF_DAY),
                        mNow.get(Calendar.MINUTE),
                        mNow.get(Calendar.SECOND));

                LocalDateTime temp = LocalDateTime.from(startDateSec);

                diff = temp.until(endDateSec, ChronoUnit.SECONDS);
                Log.d(TAG, "seconds diff: " + diff);
                break;

            case DAYS:
                diff = ChronoUnit.DAYS.between(startDate, endDate);
                Log.d(TAG, "days diff: " + diff);
                break;

            case WEEKS:
                diff = ChronoUnit.WEEKS.between(startDate, endDate);
                Log.d(TAG, "weeks diff: " + diff);
                break;

            case MONTHS:
                diff = ChronoUnit.MONTHS.between(startDate, endDate);
                Log.d(TAG, "months diff: " + diff);
                break;
        }

        return diff;
    }
}
