package com.example.igti_clt;

import android.util.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Salary {
    private static double toFixed (double number, int decimal){
        return BigDecimal.valueOf(number).setScale(decimal, RoundingMode.HALF_UP).doubleValue();
    }

    private static String getDiscount(double aliquota, double salary, double deduction){
        double result = (salary * aliquota) - deduction;

        return Double.toString(toFixed(result, 2)).replace(".",",");
    }

    private static double getDoubleInss(String salary){
        return Double.parseDouble(calculateINSS(salary).replace(",","."));
    }

    private static double getDoubleIrrf(String salary, String dependentes){
        return Double.parseDouble(calculateIRRF(salary, dependentes).replace(",","."));
    }


    public static String calculateINSS(String salary){
        double salaryDouble = Double.parseDouble(salary);
        double deduction= 0;
        double aliquota = 0;

        if (salaryDouble <= 1045){
          aliquota = 0.075;
          return getDiscount(aliquota, salaryDouble, deduction);
        }

        if (salaryDouble > 1045 && salaryDouble <=2089.60){
            aliquota = 0.09;
            deduction = 15.67;
            return getDiscount(aliquota, salaryDouble, deduction);
        }

        if (salaryDouble > 2089.60 && salaryDouble <= 3134.40){
            aliquota = 0.12;
            deduction = 78.36;
            return getDiscount(aliquota, salaryDouble, deduction);
        }

        if (salaryDouble > 3134.40 && salaryDouble <= 6101.06){
            aliquota = 0.14;
            deduction = 141.05;
            return getDiscount(aliquota, salaryDouble, deduction);
        }

        return "713,10";
    }

    public static String calculateIRRF(String salary, String dependentes){
        double salaryDouble = salary.length() > 0 ? Double.parseDouble(salary) : 0;
        double dependentesDouble = dependentes.length() > 0 ? Double.parseDouble(dependentes) : 0;
        double deduction= 0;
        double aliquota = 0;
        double inss = getDoubleInss(salary);
        double base = salaryDouble - inss - dependentesDouble * 189.59;

        if (base > 1903.98 && base <= 2826.65){
            aliquota = 0.075;
            deduction = 142.80;
            return getDiscount(aliquota, base, deduction);
        }

        if (base > 2826.65 && base <= 3751.05){
            aliquota = 0.15;
            deduction = 354.80;
            return getDiscount(aliquota, base, deduction);
        }

        if (base > 3751.05 && base <= 4664.68){
            aliquota = 0.225;
            deduction = 636.13;
            return getDiscount(aliquota, base, deduction);
        }

        if (base > 4664.68){
            aliquota = 0.275;
            deduction = 869.36;
            return getDiscount(aliquota, base, deduction);
        }

        return "0";
    }

    public static String calculateLiquidSalary(String salary, String dependentes, String discounts){
        double salaryDouble = Double.parseDouble(salary);
        double inss = getDoubleInss(salary);
        double irrfDouble = getDoubleIrrf(salary, dependentes);
        double discountsDouble = discounts.length() > 0 ? Double.parseDouble(discounts) : 0;

        double result = toFixed(salaryDouble - inss - irrfDouble - discountsDouble, 2);

        return Double.toString((result)).replace(".",",");

    }

    public static String discountPercent(String salary, String dependentes, String discounts){
       double liquid = Double.parseDouble(calculateLiquidSalary(salary, dependentes, discounts).replace(",","."));
       double salaryDouble = Double.parseDouble(salary);
       double result = toFixed(((salaryDouble - liquid) / salaryDouble) * 100, 2);

       return Double.toString(result).replace(".", ",") + "%";
    }

}
