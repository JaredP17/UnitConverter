package com.comp3710.unitconverter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    DecimalFormat fmt = new DecimalFormat("#,##0.0#"); // Number formatting for conversions
    private EditText celsius, fahrenheit, kilometers, miles, kilograms, pounds, litres, gallons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celsius = findViewById(R.id.celsiusEditText);
        fahrenheit = findViewById(R.id.fahrenheitEditText);
        kilometers = findViewById(R.id.kmEditText);
        miles = findViewById(R.id.mileEditText);
        kilograms = findViewById(R.id.kgEditText);
        pounds = findViewById(R.id.lbEditText);
        litres = findViewById(R.id.literEditText);
        gallons = findViewById(R.id.gallonEditText);

        clearText(celsius, fahrenheit);
        celsius.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(celsius.hasFocus()) {
                    String c = celsius.getText().toString();
                    if (c.isEmpty()) {
                        fahrenheit.setText("");
                    } else {
                        String f = toFahrenheit() + " \u2109"; // Adds fahrenheit symbol to conversion text
                        fahrenheit.setText(f);
                    }
                }
            }
        });

        clearText(fahrenheit, celsius);
        fahrenheit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(fahrenheit.hasFocus()) {
                    String f = fahrenheit.getText().toString();
                    if (f.isEmpty()) {
                        celsius.setText("");
                    } else {
                        String c = toCelsius() + " \u2103"; // Adds celsius symbol to conversion text
                        celsius.setText(c);
                    }
                }
            }
        });

        clearText(kilometers, miles);
        kilometers.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(kilometers.hasFocus()) {
                    String k = kilometers.getText().toString();
                    if (k.isEmpty()) {
                        miles.setText("");
                    } else {
                        String m = toMiles() + " mi"; // Adds mi to conversion text
                        miles.setText(m);
                    }
                }
            }
        });

        clearText(miles, kilometers);
        miles.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(miles.hasFocus()) {
                    String m = miles.getText().toString();
                    if (m.isEmpty()) {
                        kilometers.setText("");
                    } else {
                        String k = toKilometers() + " km"; // Adds km to conversion text
                        kilometers.setText(k);
                    }
                }
            }
        });

        clearText(kilograms, pounds);
        kilograms.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(kilograms.hasFocus()) {
                    String k = kilograms.getText().toString();
                    if (k.isEmpty()) {
                        pounds.setText("");
                    } else {
                        String p = toPounds() + " lbs"; // Adds lbs to conversion text
                        pounds.setText(p);
                    }
                }
            }
        });

        clearText(pounds, kilograms);
        pounds.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(pounds.hasFocus()) {
                    String p = pounds.getText().toString();
                    if (p.isEmpty()) {
                        kilograms.setText("");
                    } else {
                        String k = toKilograms() + " kg"; // Adds kg to conversion text
                        kilograms.setText(k);
                    }
                }
            }
        });

        clearText(litres, gallons);
        litres.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(litres.hasFocus()) {
                    String l = litres.getText().toString();
                    if (l.isEmpty()) {
                        gallons.setText("");
                    } else {
                        String g = toGallons() + " gal"; // Adds gal to conversion text
                        gallons.setText(g);
                    }
                }
            }
        });

        clearText(gallons, litres);
        gallons.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(gallons.hasFocus()) {
                    String g = gallons.getText().toString();
                    if (g.isEmpty()) {
                        litres.setText("");
                    } else {
                        String l = toLitres() + " li"; // Adds li to conversion text
                        litres.setText(l);
                    }
                }
            }
        });
    }


    // Method for clearing corresponding text fields on touch
    @SuppressLint("ClickableViewAccessibility")
    private void clearText(final EditText editText, final EditText editText2) {
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                editText.getText().clear();
                editText2.getText().clear();
                Vibrator vb = (Vibrator)   getSystemService(Context.VIBRATOR_SERVICE);
                vb.vibrate(20);
                return false;
            }
        });
    }


    /************************
     * ALL UNIT CONVERSIONS *
     ************************/
    private String toCelsius() {
        return fmt.format((Double.parseDouble(fahrenheit.getText().toString()) - 32.0) * (5.0 / 9.0));

    }

    private String toFahrenheit() {
        return fmt.format((Double.parseDouble(celsius.getText().toString()) * (9.0 / 5.0)) + 32.0);

    }

    private String toKilometers() {
        return fmt.format(Double.parseDouble(miles.getText().toString()) * 1.609);
    }

    private String toMiles() {
        return fmt.format(Double.parseDouble(kilometers.getText().toString()) / 1.609);
    }

    private String toKilograms() {
        return fmt.format(Double.parseDouble(pounds.getText().toString()) / 2.205);
    }

    private String toPounds() {
        return fmt.format(Double.parseDouble(kilograms.getText().toString()) * 2.205);
    }

    private String toLitres() {
        return fmt.format(Double.parseDouble(gallons.getText().toString()) * 3.785);
    }

    private String toGallons() {
        return fmt.format(Double.parseDouble(litres.getText().toString()) / 3.785);
    }
}
