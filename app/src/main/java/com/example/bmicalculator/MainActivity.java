package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtRes;
    EditText et1,et2;
    Button btncal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 =findViewById(R.id.txtWeight);
        et2=findViewById(R.id.txtHeight);
        txtRes=findViewById(R.id.txtres);
        btncal=findViewById(R.id.btnCalculate);
        btncal.setOnClickListener((View.OnClickListener) this);
    }

    //validation
    public boolean valid(){
        if(et1.getText().toString().trim().equals("") || et2.getText().toString().trim().equals("")){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void onClick(View v) {


        String weight = et1.getText().toString();
        String height = et2.getText().toString();

        if(!valid()) {


            float w = Float.parseFloat(weight);
            float h = Float.parseFloat(height);

            float bmi = w / (h * h);

            String category;
            if (bmi < 18f) {
                category = " underweight";
            } else if (bmi >= 18f && bmi <= 25f) {
                category = "Normal";

            } else {
                category = "Overweight";
            }
            category = bmi + "\n\n" + category;
            txtRes.setText("BMI=" + category);
        }
        else
        {
            Toast.makeText(this,"Please fill all the fields", Toast.LENGTH_LONG).show();
        }
    }
}
