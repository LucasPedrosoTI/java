package com.example.igti_clt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    public class Data  {
        private String sal_bruto, dependentes, descontos;

        public Data(Parcel in) {
            sal_bruto = in.readString();
            dependentes = in.readString();
            descontos = in.readString();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void calculate(View view) {
        Intent calculateIntent = new Intent(this, results.class);

        EditText input_sal_bruto = (EditText)findViewById(R.id.sal_bruto_input);
        EditText input_dependentes = (EditText)findViewById(R.id.dependentes_input);
        EditText input_descontos = (EditText)findViewById(R.id.descontos_input);

        String sal_bruto =  input_sal_bruto.getText().toString();
        if (sal_bruto.length() == 0){
            Toast.makeText(getApplicationContext(), "Salário deve ser maior que 0", Toast.LENGTH_SHORT).show();
            return;
        }

        String dependentes =  input_dependentes.getText().toString();
        String descontos =  input_descontos.getText().toString();

        calculateIntent.putExtra("sal", sal_bruto);
        calculateIntent.putExtra("dependentes", dependentes);
        calculateIntent.putExtra("descontos", descontos);

        startActivity(calculateIntent);
    }


    }