package com.example.michael.cars;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    public static List<String> carList = new ArrayList<String>();
    public static List<String> carYearList = new ArrayList<String>();
    public static List<String> carPriceList = new ArrayList<String>();
    public static List<String> carHorsepower = new ArrayList<String>();

    private ArrayAdapter<String> arrayAdapter;

    @Override
    public void onStart() {
        super.onStart();
        loadCars(MainActivity.this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?>listView, View view, int position, long id) {
                String carType = (String)listView.getItemAtPosition(position);
                String carYear = carYearList.get(position);
                String carPrice = carPriceList.get(position);
                String carHP = carHorsepower.get(position);

                Intent intent = new Intent(MainActivity.this, carDetailActivity.class);
                intent.putExtra("carType", carType);
                intent.putExtra("carYear", carYear);
                intent.putExtra("carPrice", carPrice);
                intent.putExtra("carHP", carHP);

                startActivity(intent);
            }
        };

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, carList);


        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(itemClickListener);

        registerForContextMenu(listView);
    }

    public void addCarView(View view) {
        Intent intent = new Intent(this, addCarActivity.class);
        startActivity(intent);
    }

    public static void addCarToList(String newCar, String newYear, String newPrice, String newHP) {
        carList.add(newCar);
        carYearList.add(newYear);
        carPriceList.add(newPrice);
        carHorsepower.add(newHP);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);

        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)menuInfo;
        String carName = arrayAdapter.getItem(adapterContextMenuInfo.position);
        menu.setHeaderTitle("Delete " + carName);
        menu.add(1, 1, 1, "Yes");
        menu.add(2,2,2, "No");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == 1) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            carList.remove(info.position);
            carYearList.remove(info.position);
            carPriceList.remove(info.position);
            carHorsepower.remove(info.position);
            MainActivity.this.arrayAdapter.notifyDataSetChanged();
        }
        return true;
    }

    public void storeCars(Context context) {
        SharedPreferences sharedPrefs = context.getSharedPreferences("Cars", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();

        Set<String> set = new HashSet<String>();
        set.addAll(carList);
        editor.putStringSet("Cars", set);
        editor.commit();
    }

    public void loadCars(Context context) {
        SharedPreferences sharedPrefs = context.getSharedPreferences("Cars", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();

        Set<String> set = sharedPrefs.getStringSet("Cars", null);
        if (set != null) {
            carList.addAll(set);
        }
    }


}
