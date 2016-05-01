package com.example.michael.cars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class carDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        String makeAndModel = (String)getIntent().getExtras().get("carType");
        String year = (String)getIntent().getExtras().get("carYear");
        String price = (String)getIntent().getExtras().get("carPrice");
        String horsepower = (String)getIntent().getExtras().get("carHP");

        TextView carName = (TextView)findViewById(R.id.car_name);
        carName.setText(makeAndModel);

        TextView carYear = (TextView)findViewById(R.id.car_year);
        carYear.setText("Year: " + year);

        TextView carPrice = (TextView)findViewById(R.id.car_price);
        carPrice.setText("Price: " + price);

        TextView carHP = (TextView)findViewById(R.id.car_hp);
        carHP.setText("Horsepower: " + horsepower);
    }
}
