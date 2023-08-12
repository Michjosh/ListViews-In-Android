package com.mikul.listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

public class MainActivity extends Activity {

    private ListView continentListView;

    private final String[][] continentsAndCountries = {
            {"Africa", "Nigeria", "Egypt", "South Africa"},
            {"Asia", "China", "India", "Japan"},
            {"Europe", "Germany", "France", "United Kingdom"},
            {"North America", "United States", "Canada", "Mexico"},
            {"South America", "Brazil", "Argentina", "Colombia"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continentListView = findViewById(R.id.continentListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item_continent,
                R.id.continentNameTextView,
                getContinentNames(continentsAndCountries)
        );

        continentListView.setAdapter(adapter);

        continentListView.setOnItemClickListener((parent, view, position, id) -> showCountriesForContinent(position));
    }

    private String[] getContinentNames(String[][] data) {
        String[] continentNames = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            continentNames[i] = data[i][0];
        }
        return continentNames;
    }

    private void showCountriesForContinent(int continentIndex) {
        String[] countries = new String[continentsAndCountries[continentIndex].length - 1];
        System.arraycopy(continentsAndCountries[continentIndex], 1, countries, 0, countries.length);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item_country,
                R.id.countryNameTextView,
                countries
        );

        continentListView.setAdapter(adapter);
    }
}
