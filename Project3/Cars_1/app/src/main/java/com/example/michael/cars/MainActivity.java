package com.example.michael.cars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?>listView, View view, int position, long id) {
                String carType = (String)listView.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, carDetailActivity.class);
                intent.putExtra("carType", carType);
                intent.putExtra("carId", (int) id);
                startActivity(intent);
            }
        };

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setOnItemClickListener(itemClickListener);
    }

    public void addCar(View view) {
        Log.i("addCarPressed", "Add Car Button Pressed");

        Intent intent = new Intent(this, addCarActivity.class);
        startActivity(intent);
    }


}
