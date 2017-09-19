package com.example.buddhima.neareststation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

public class AutocompleteActivity extends AppCompatActivity {
    private Double trainLat;
    private Double trainLong;
    private String trainName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete);

        PlaceAutocompleteFragment places= (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);



        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                .setTypeFilter(AutocompleteFilter.TYPE_FILTER_GEOCODE)
                .setCountry("LK")
                .build();

        places.setFilter(typeFilter);

        ((View)findViewById(R.id.place_autocomplete_search_button)).setVisibility(View.GONE);
        ((EditText)findViewById(R.id.place_autocomplete_search_input)).setBackgroundResource(R.drawable.input_outline);
        ((EditText)findViewById(R.id.place_autocomplete_search_input)).setTextSize(18);
        ((EditText)findViewById(R.id.place_autocomplete_search_input)).setPadding(22,22,22,22);

        places.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                trainLat = place.getLatLng().latitude;
                trainLong = place.getLatLng().longitude;
                trainName = place.getName().toString();

                Intent intent = new Intent(AutocompleteActivity.this, MapActivity.class);
                intent.putExtra("train_lat", trainLat);
                intent.putExtra("train_long",trainLong);
                intent.putExtra("train_name",trainName);
                startActivity(intent);


            }
            @Override
            public void onError(Status status) {

            }

        });
    }
}
