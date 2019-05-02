package www.adc.rw.thermo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Formatter;

public class MainActivity extends AppCompatActivity {
     EditText tCalc;
     Button btnCalculate;
     TextView tResult;
     DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tCalc = findViewById(R.id.tCalc);
        btnCalculate =findViewById(R.id.btnCalculate);
        tResult = findViewById(R.id.tResult);

        tResult.setVisibility(View.GONE);

        formatter = new DecimalFormat("#0.0");

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }

            private void openDialog() {
                if (tCalc.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter number of chirps!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int chirps = Integer.parseInt(tCalc.getText().toString().trim());

                    double temp = (chirps / 3.0) + 4;

                    String results = "Temperature outside is  " + formatter.format(temp) + "°C";

                    tResult.setText(results);

                    tResult.setVisibility(View.VISIBLE);
                }

            }
        });
    }
            }
