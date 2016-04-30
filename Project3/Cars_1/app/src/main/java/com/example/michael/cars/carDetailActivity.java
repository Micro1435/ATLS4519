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

        int carNum = (Integer)getIntent().getExtras().get("carId");
        String type = (String)getIntent().getExtras().get("carType");
        Car car = Car.cars[carNum];

        ImageView carImage = (ImageView)findViewById(R.id.carImageView);
        carImage.setImageResource(car.getImageResourceID());

        TextView carName = (TextView)findViewById(R.id.car_name);
        carName.setText(car.getMake());
    }
}
