package com.example.a2_1p;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner unit_spinner;
    private EditText unit_value;
    private TextView value1;
    private TextView value2;
    private TextView value3;
    private TextView unit1;
    private TextView unit2;
    private TextView unit3;

    private ImageButton m_button;
    private ImageButton t_button;
    private ImageButton w_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unit_value = (EditText) findViewById(R.id.unit_value);
        unit_spinner = (Spinner) findViewById(R.id.unit_selection);
        //get uneditable text
        value1 = (TextView) findViewById(R.id.calc1);
        value2 = (TextView) findViewById(R.id.calc2);
        value3 = (TextView) findViewById(R.id.calc3);
        unit1 = (TextView) findViewById(R.id.unit1);
        unit2 = (TextView) findViewById(R.id.unit2);
        unit3 = (TextView) findViewById(R.id.unit3);

        setContentView(R.layout.activity_main);


        //button code below
        m_button = (ImageButton) findViewById(R.id.metrebutton);
        m_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateM();
            }});
        t_button = (ImageButton) findViewById(R.id.celbutton);
        t_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateT();
            }});
        w_button = (ImageButton) findViewById(R.id.kgbutton);
        w_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateW();
            }});
    }
    void scanvalues() {
        unit_value = (EditText) findViewById(R.id.unit_value);
        unit_spinner = (Spinner) findViewById(R.id.unit_selection);

        //get uneditable text
        value1 = (TextView) findViewById(R.id.calc1);
        value2 = (TextView) findViewById(R.id.calc2);
        value3 = (TextView) findViewById(R.id.calc3);
        unit1 = (TextView) findViewById(R.id.unit1);
        unit2 = (TextView) findViewById(R.id.unit2);
        unit3 = (TextView) findViewById(R.id.unit3);

    }

    private void calculateM() {
        scanvalues();
        if (unit_spinner.getSelectedItemPosition() == 0) {
            if (unit_value.getText().length() != 0) {
                //centimetres
                double input = Double.valueOf(String.valueOf(unit_value.getText()));
                double result = input * 100;
                result = Math.round(result * 100) / 100D;
                value1.setText(Double.valueOf(result).toString());
                unit1.setText("Centimetre");
                //foot
                result = input * 3.28084;
                result = Math.round(result * 100) / 100D;
                value2.setText(Double.valueOf(result).toString());
                unit2.setText("Foot");
                //inch
                result = input * 39.3701;
                result = Math.round(result * 100) / 100D;
                value3.setText(Double.valueOf(result).toString());
                unit3.setText("Inch");
            }
        } else {
            value1.setText("Please select the correct \n conversion icon");
            unit1.setText(" ");
            value2.setText(" ");
            unit2.setText(" ");
            value3.setText(" ");
            unit3.setText(" ");
        }
    }

    private void calculateT() {
        scanvalues();
        if (unit_spinner.getSelectedItemPosition() == 1) {
            //fahrenheit
            if (unit_value.getText().length() != 0) {
                double input = Double.valueOf(String.valueOf(unit_value.getText()));
                double result = input * 9 / 5 + 32;
                result = Math.round(result * 100) / 100D;
                value1.setText(Double.valueOf(result).toString());
                unit1.setText("Fahrenheit");
                //kelvin
                result = input + 273.15;
                result = Math.round(result * 100) / 100D;
                value2.setText(Double.valueOf(result).toString());
                unit2.setText("Kelvin");
                //hide
                value3.setText(" ");
                unit3.setText(" ");
            }
        } else {
            value1.setText("Please select the correct \n conversion icon");
            unit1.setText(" ");
            value2.setText(" ");
            unit2.setText(" ");
            value3.setText(" ");
            unit3.setText(" ");
        }
    }

    private void calculateW() {
        scanvalues();
            if (unit_spinner.getSelectedItemPosition() == 2) {
                //Gram
                if (unit_value.getText().length() != 0) {
                    double input = Double.valueOf(String.valueOf(unit_value.getText()));
                    double result = input * 1000;
                    result = Math.round(result * 100) / 100D;
                    value1.setText(Double.valueOf(result).toString());
                    unit1.setText("Gram");
                    //kelvin
                    result = input * 35.274;
                    result = Math.round(result * 100) / 100D;
                    value2.setText(Double.valueOf(result).toString());
                    unit2.setText("Ounce(Oz)");
                    //pound
                    result = input * 2.20462;
                    //conv to 2 dec points
                    result = Math.round(result * 100) / 100D;
                    value3.setText(Double.valueOf(result).toString());
                    unit3.setText("Pound(lb)");
                }
            } else {
                value1.setText("Please select the correct \n conversion icon");
                unit1.setText(" ");
                value2.setText(" ");
                unit2.setText(" ");
                value3.setText(" ");
                unit3.setText(" ");
            }
    }
}