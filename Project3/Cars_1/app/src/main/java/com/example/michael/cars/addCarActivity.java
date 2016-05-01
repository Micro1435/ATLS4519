package com.example.michael.cars;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addCarActivity extends MainActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        final Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText make = (EditText)findViewById(R.id.editText);
                EditText model = (EditText)findViewById(R.id.editText2);
                EditText year = (EditText)findViewById(R.id.editText3);
                EditText price = (EditText)findViewById(R.id.editText4);
                EditText hp = (EditText)findViewById(R.id.editText5);

                String newMake = make.getText().toString();
                String newModel = model.getText().toString();
                String newCar = newMake + " " + newModel;

                String newYear = year.getText().toString();
                String newPrice = price.getText().toString();
                String newHP = hp.getText().toString();

                Context context = getApplicationContext();
                CharSequence text = "Car Added";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);

                if (newMake != null) {
                    addCarToList(newCar, newYear, newPrice, newHP);
                    make.setText("");
                    model.setText("");
                    year.setText("");
                    price.setText("");
                    hp.setText("");
                    toast.show();
                }
            }
        });

    }
}
