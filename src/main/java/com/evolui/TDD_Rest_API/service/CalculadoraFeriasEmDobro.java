package com.evolui.TDD_Rest_API.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CalculadoraFeriasEmDobro implements CalculadoraFeriasIntegral {

    @Override
    public double calcularFeriasNaoProporcionais(double salario) {
        double acrescimoFerias = salario / 3;

        double ferias = formatarParaDoubleDaStringComVirgula(salario + acrescimoFerias);

        int valorAdicional = 3;
        return ferias  * valorAdicional;
    }

    private double formatarParaDoubleDaStringComVirgula(double ferias) {
        DecimalFormat df = new DecimalFormat("##.00");
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        Number number = null;

        try {
            number = format.parse(df.format(ferias));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return number.doubleValue();
    }
}