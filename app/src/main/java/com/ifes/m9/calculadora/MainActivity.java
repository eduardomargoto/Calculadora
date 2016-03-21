package com.ifes.m9.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText txt_result;
    double result = 0;
    String prox_op = "";
    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_mais, btn_menos, btn_vezes, btn_div, btn_ce, btn_igual, btn_virg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_result = (EditText) findViewById(R.id.txt_result);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_virg = (Button) findViewById(R.id.btn_virg);
        btn_mais = (Button) findViewById(R.id.btn_mais);
        btn_menos = (Button) findViewById(R.id.btn_menos);
        btn_vezes = (Button) findViewById(R.id.btn_vezes);
        btn_div = (Button) findViewById(R.id.btn_dividir);
        btn_ce = (Button) findViewById(R.id.btn_ce);
        btn_igual = (Button) findViewById(R.id.btn_igual);

        btn_0.setOnClickListener(clickButtonsNum);
        btn_1.setOnClickListener(clickButtonsNum);
        btn_2.setOnClickListener(clickButtonsNum);
        btn_3.setOnClickListener(clickButtonsNum);
        btn_4.setOnClickListener(clickButtonsNum);
        btn_5.setOnClickListener(clickButtonsNum);
        btn_6.setOnClickListener(clickButtonsNum);
        btn_7.setOnClickListener(clickButtonsNum);
        btn_8.setOnClickListener(clickButtonsNum);
        btn_9.setOnClickListener(clickButtonsNum);
        btn_virg.setOnClickListener(clickButtonsNum);
        btn_mais.setOnClickListener(clickButtonOP);
        btn_menos.setOnClickListener(clickButtonOP);
        btn_vezes.setOnClickListener(clickButtonOP);
        btn_div.setOnClickListener(clickButtonOP);
        btn_igual.setOnClickListener(clickButtonOP);
        btn_ce.setOnClickListener(clickButtonOP);


    }

    View.OnClickListener clickButtonOP = new View.OnClickListener() {
        public void onClick(View v) {
            if (v.getId() == R.id.btn_igual) {
                switch (prox_op) {
                    case "-":
                        result = result - Double.parseDouble(txt_result.getText().toString());
                        break;
                    case "+":
                        result = result + Double.parseDouble(txt_result.getText().toString());
                        break;
                    case "x":
                        result = result * Double.parseDouble(txt_result.getText().toString());
                        break;
                    case "÷":
                        result = result / Double.parseDouble(txt_result.getText().toString());
                        break;
                }
                txt_result.setText(String.valueOf(result));
            } else if (v.getId() == R.id.btn_ce) {
                txt_result.setText("");
                result = 0;
            } else {
                Button b = (Button) findViewById(v.getId());
                result = Double.parseDouble(txt_result.getText().toString());
                prox_op = b.getText().toString();
                txt_result.setText("");
            }
        }
    };

    View.OnClickListener clickButtonsNum = new View.OnClickListener() {
        public void onClick(View v) {
            Button b = (Button) findViewById(v.getId());
            txt_result.setText(txt_result.getText().toString() + b.getText().toString());
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
