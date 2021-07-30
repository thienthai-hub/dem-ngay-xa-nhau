package com.thienthai.demngayxanhau;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnLove;
    EditText edtfirstMeet, edtlastMeet;
    TextView tvLove;
    Calendar calendarLove1, calendarLove2;
    SimpleDateFormat simpleDateFormat1, simpleDateFormat2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        edtfirstMeet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeFrirtMeet();
            }
        });
        edtlastMeet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeLastMeet();
            }
        });
        btnLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int TotalDayLove = (int) ((calendarLove2.getTimeInMillis() - calendarLove1.getTimeInMillis())
                        / (1000*60*60*24));
                tvLove.setText("Tổng số ngày yêu là:" + TotalDayLove);
            }
        });
    }
    private void TimeFrirtMeet(){
        calendarLove1 = Calendar.getInstance();
        int day = calendarLove1.get(Calendar.DATE); 
        int month = calendarLove1.get(Calendar.MONTH);
        int year = calendarLove1.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarLove1.set(year, month, dayOfMonth );
                simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
                edtfirstMeet.setText(simpleDateFormat1.format(calendarLove1.getTime()));
            }
        },year ,month ,day );
        datePickerDialog.show();
    }
    private void TimeLastMeet(){
        calendarLove2 = Calendar.getInstance(); //thu viện java
        int day = calendarLove2.get(Calendar.DATE);
        int month = calendarLove2.get(Calendar.MONTH);
        int year = calendarLove2.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarLove2.set(year, month, dayOfMonth );
                simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
                edtlastMeet.setText(simpleDateFormat2.format(calendarLove2.getTime()));
            }
        },year ,month ,day );
        datePickerDialog.show();
    }
    private void AnhXa(){
        btnLove = (Button) findViewById(R.id.btnLove);
        tvLove = (TextView) findViewById(R.id.textView);
        edtfirstMeet = (EditText) findViewById(R.id.edtCalendar1);
        edtlastMeet = (EditText) findViewById(R.id.edtCalendar2);
    }
}