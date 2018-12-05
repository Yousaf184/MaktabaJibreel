package com.example.yousafkhan.maktabajibreel.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.yousafkhan.maktabajibreel.R;
import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class SettingsActivity extends AppCompatActivity {

    private ImageView quranTextColorImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        quranTextColorImg = findViewById(R.id.quran_text_color_imageview);

        Spinner searchResultsLimitSpinner = findViewById(R.id.search_results_limit_spinner);
        Spinner quranTextSizeSpinner = findViewById(R.id.quran_text_size_spinner);
        Spinner hadeesTextSizeSpinner = findViewById(R.id.hadees_text_size_spinner);

        fillSpinner(searchResultsLimitSpinner, R.array.search_results_limit_options);
        fillSpinner(quranTextSizeSpinner, R.array.settings_activity_text_size_options);
        fillSpinner(hadeesTextSizeSpinner, R.array.settings_activity_text_size_options);
    }

    // fills the passed in spinner with passed in array resource
    private void fillSpinner(Spinner spinner, int resourceArray) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                                        this,
                                                resourceArray,
                                                android.R.layout.simple_spinner_item
                                              );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    // quran text color picker listener
    public void openColorPickerDialog(View view) {
        ColorPickerDialog.Builder builder =
                new ColorPickerDialog.Builder(this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);

        builder.setTitle("ColorPicker Dialog");

        builder.setPositiveButton("Confirm", new ColorEnvelopeListener() {
            @Override
            public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                quranTextColorImg.setBackgroundColor(envelope.getColor());
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.attachAlphaSlideBar(); // attach AlphaSlideBar
        builder.attachBrightnessSlideBar(); // attach BrightnessSlideBar
        builder.show(); // show dialog
    }
}
