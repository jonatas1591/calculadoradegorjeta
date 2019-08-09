package br.com.jisystems.calculadoradegorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekGorjeta;

    private double porcetagem = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textGorjeta = findViewById(R.id.textGorjeta);
        textTotal = findViewById(R.id.textTotal);
        seekGorjeta = findViewById(R.id.seekGorjeta);

        //Controlar seekBar
        seekGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Recupera progresso da porcentagem
                porcetagem = seekBar.getProgress();
                textPorcentagem.setText(Math.round(porcetagem) +"%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){
        //Recuperar valor digitado
        double valorDigitado = Double.parseDouble(editValor.getText().toString());

        //Calcula gorjeta
        double gorjeta = valorDigitado * (porcetagem / 100);
        double total = gorjeta + valorDigitado;

        //exibe a gorjeta total
        textGorjeta.setText("RS " + Math.round(gorjeta));
        textTotal.setText("RS " + Math.round(total));
    }
}
