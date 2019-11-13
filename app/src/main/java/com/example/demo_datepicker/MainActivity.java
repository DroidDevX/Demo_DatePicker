package com.example.demo_datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = "MainActivity";

    private Button datePickerButton;
    private TextView selectedDateTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectedDateTV = findViewById(R.id.selectedDateTV);
        datePickerButton = findViewById(R.id.datePickerBtn);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Log.e(TAG, "onClick: ");
                DatePickerFragment dialog = new DatePickerFragment();
                dialog.show(getSupportFragmentManager(),"datePicker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Log.d(TAG, "onDateSet: ");
        Date inputDate = new GregorianCalendar(year,month,day).getTime();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
        selectedDateTV.setText(dateFormatter.format(inputDate));

    }


}
