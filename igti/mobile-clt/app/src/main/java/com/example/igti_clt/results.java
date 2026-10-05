package com.example.igti_clt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle intent = getIntent().getExtras();

        String sal_bruto = intent.getString("sal");
        String dependentes = intent.getString("dependentes");
        String descontos = intent.getString("descontos");

        String inss = Salary.calculateINSS(sal_bruto);
        String irrf = Salary.calculateIRRF(sal_bruto, dependentes);
        String liquid = Salary.calculateLiquidSalary(sal_bruto, dependentes, descontos);
        String discountPercent = Salary.discountPercent(sal_bruto, dependentes, descontos);

        TextView sal_bruto_txt = (TextView)findViewById(R.id.sal_bruto);
        TextView inss_txt = (TextView)findViewById(R.id.inss);
        TextView irrf_txt = (TextView)findViewById(R.id.irrf);
        TextView descontos_txt = (TextView)findViewById(R.id.descontos);
        TextView liquid_txt = (TextView)findViewById(R.id.liquid);
        TextView percent_txt = (TextView)findViewById(R.id.percent);


        sal_bruto_txt.setText(sal_bruto);
        inss_txt.setText("-"+inss);
        irrf_txt.setText("-"+irrf);
        descontos_txt.setText("-"+descontos);
        liquid_txt.setText(liquid);
        percent_txt.setText(discountPercent);

    }

    public void goBack(View view) {
        Intent goBackIntent = new Intent(this, MainActivity.class);

        startActivity(goBackIntent);
    }
}