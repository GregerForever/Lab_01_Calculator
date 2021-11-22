package com.example.lab_01_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    double a = 0, b = 0, result;
    EditText txtA, txtB, txtDOP;
    TextView textResult, txtResultDOP, txtPOW;
    Context activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtA = findViewById(R.id.textA);
        txtB = findViewById(R.id.textB);
        textResult = findViewById(R.id.ResultView);
        txtDOP = findViewById(R.id.textDOP);
        txtResultDOP = findViewById(R.id.ResultTextDOP);
        txtPOW = findViewById(R.id.PowMultiplier);
    }


    public void onClickButton(View v)
    {
        String promA = txtA.getText().toString();
        String promB = txtB.getText().toString();
        try
        {
            a = Double.parseDouble(promA);
            b = Double.parseDouble(promB);
        }
        catch (NumberFormatException e)
        {
            Toast.makeText(activity, "Неверно введены значения", Toast.LENGTH_SHORT).show();
            return;
        }
        switch(v.getId()){
            case R.id.PlusButton:
                result = a + b;
                break;
            case R.id.MinusButton:
                result = a - b;
                break;
            case R.id.MultiplyButton:
                result = a * b;
                break;
            case R.id.DivideButton:
                if (b == 0)
                {
                    Toast.makeText(activity, "Деление на 0 невозможно", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = a / b;
                break;
        }
        textResult.setText("Результат: " + result);
    }
    public void onDOPClickButton(View v)
    {
        String promDOP = txtDOP.getText().toString();
        try
        {
            a = Double.parseDouble(promDOP);
        }
        catch (NumberFormatException e)
        {
            Toast.makeText(activity, "Неверно введены значения", Toast.LENGTH_SHORT).show();
            return;
        }
        switch (v.getId())
        {
            case R.id.SinButton:
                result = Math.sin(a * (Math.PI/180));
                break;
            case R.id.CosButton:
                result = Math.cos(a * (Math.PI/180));
                break;
            case R.id.TanButton:
                result = Math.tan(a * (Math.PI/180));
                break;
            case R.id.SqrtButton:
                result = Math.sqrt(a);
                break;
            case R.id.PowButton:
                int pow;
                try
                {
                    pow = Integer.parseInt(txtPOW.getText().toString());
                }
                catch (NumberFormatException e)
                {
                    Toast.makeText(activity, "Отсутствует степень", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = Math.pow(a, pow);
                break;
        }
        txtResultDOP.setText("Результат: " + result);
    }
}