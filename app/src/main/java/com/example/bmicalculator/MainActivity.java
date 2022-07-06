package com.example.bmicalculator;

import static java.lang.Float.valueOf;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    float weight;
    float height;
    float mHeight;
    float bmi;
    float p,losw,gainw;
    public void onCalc(View v)
    {
        EditText e1,e2,e3;
        TextView tv1,tv2,tv3;
        e1 = (EditText)findViewById(R.id.etT1);
        e2 = (EditText)findViewById(R.id.editTextNumber3);
        e3 = (EditText)findViewById(R.id.editTextNumber4);
        tv1 = (TextView)findViewById(R.id.textView4);
        tv2 = (TextView)findViewById(R.id.tvv1);
        tv3 = (TextView)findViewById(R.id.tvv2);
        weight = Float.parseFloat(e1.getText().toString());
        height = Float.parseFloat(e2.getText().toString());
        mHeight = height / 100;
        float hsq = mHeight * mHeight;
        bmi = weight/hsq;
        e3.setText(""+valueOf(bmi));
        if(bmi < 18)
        {
            tv1.setText("Underweight");
            p = (float) (24 * Math.pow(mHeight, 2));
            tv2.setText("Your Optimum weight should be "+ p +" kg");
            gainw = p - weight;
            tv3.setText("You need to gain at least "+gainw+ "Kg");

        }
        else if(bmi >= 18 && bmi < 25)
        {
            tv1.setText("Healthy Range");
            tv2.setText("");
            tv3.setText("");

        }
        else if(bmi > 25 && bmi <= 30)
        {
            tv1.setText("Overweight");
            p = (float) (24 * Math.pow(mHeight, 2));
            tv2.setText("Your Optimum weight should be "+p+" kg");
            losw = weight-p;
            tv3.setText("You need to lose at least "+losw+ "Kg");
        }
        else
        {
            tv1.setText("Obese");
            p = (float) (24 * Math.pow(mHeight, 2));
            tv2.setText("Your Optimum weight should be "+p+" kg");
            losw = weight-p;
            tv3.setText("You need to lose at least "+losw+ "Kg");
        }
    }

    public void onReset(View v)
    {
        EditText e1,e2,e3;
        TextView tv1,tv2,tv3;
        e1 = (EditText)findViewById(R.id.etT1);
        e2 = (EditText)findViewById(R.id.editTextNumber3);
        e3 = (EditText)findViewById(R.id.editTextNumber4);
        tv1 = (TextView)findViewById(R.id.textView4);
        tv2 = (TextView)findViewById(R.id.tvv1);
        tv3 = (TextView)findViewById(R.id.tvv2);
        e1.setText("");
        e2.setText("");
        e3.setText("");
        tv1.setText("");
        tv2.setText("");
        tv3.setText("");
    }
}