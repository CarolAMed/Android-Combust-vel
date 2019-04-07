package com.carol.exerciciocombustivel;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();


    private TextView textViewGasolina;
    private  TextView textViewGas;
    private SeekBar seekBarGas;
    private TextView textViewEtano;
    private TextView textViewEtanol;
    private SeekBar seekBarEtanol;
    private TextInputEditText textInputExibi;
    private ImageView imageViewEscolha;

    private double gas;
    private double etanol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewGasolina = findViewById(R.id.textViewGasolina);
        seekBarGas = findViewById(R.id.seekBarGas);
        textViewEtano = findViewById(R.id.textViewEtano);
        seekBarEtanol = findViewById(R.id.seekBarEtanol);
        imageViewEscolha = findViewById(R.id.imageViewEscolha);
        textInputExibi = findViewById(R.id.textInputExibi);

        seekBarGas.setOnSeekBarChangeListener(seen);
        seekBarEtanol.setOnSeekBarChangeListener(seen);

        textViewGasolina.setText(currencyFormat.format(0));
        textViewEtano.setText(currencyFormat.format(0));



        calcula();

    }
    private void calcula (){


        if ((etanol/gas) >= 0.7){
            textInputExibi.setText(R.string.gas);
            imageViewEscolha.setImageResource(R.drawable.gasolina);
        }
        else{
            textInputExibi.setText(R.string.etanol);
            imageViewEscolha.setImageResource(R.drawable.etanol);
        }
    }



    private OnSeekBarChangeListener seen =
            new OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                    if (seekBar.getId() == R.id.seekBarGas){
                        gas = progress / 100.;
                        textViewGasolina.setText(currencyFormat.format(gas));
                    }
                    else if(seekBar.getId() == R.id.seekBarEtanol){
                        etanol = progress / 100.;
                        textViewEtano.setText(currencyFormat.format(etanol));

                    }
                    calcula();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };
}
