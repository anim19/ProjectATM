package izriva.as.beratbadan;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCek, btnClear, btnExit;
    EditText editTinggi, editNama, editBerat, editHasil1, editHasil2, editHasil3;
    TextView txtView, txtNama, txtTinggi, txtBerat, txtKelamin, txtHasil;
    RadioGroup radio1;
    RadioButton radioLaki, radioWanita;
    int h1, ti, bt;
    String temp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radio1 = (RadioGroup) findViewById(R.id.radio1);
        btnCek = (Button) findViewById(R.id.btnCek);
        btnExit = (Button) findViewById(R.id.btnExit);
        btnClear = (Button) findViewById(R.id.btnClear);
        editTinggi = (EditText) findViewById(R.id.editTinggi);
        editNama = (EditText) findViewById(R.id.editNama);
        editBerat = (EditText) findViewById(R.id.editBerat);
        editHasil1 = (EditText) findViewById(R.id.edithasil1);
        editHasil2 = (EditText) findViewById(R.id.editHasil2);
        editHasil3 = (EditText) findViewById(R.id.editHasil3);
        radioLaki = (RadioButton) findViewById(R.id.radioLaki);
        radioWanita = (RadioButton) findViewById(R.id.radioWanita);


        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses();
            }

            private void proses() {
                int ti = Integer.parseInt(String.valueOf(editTinggi.getText()));
                int bt = Integer.parseInt(String.valueOf(editBerat.getText()));

                if (radioLaki.isSelected()) {
                    h1 = (ti - 100);
                } else if (radioWanita.isSelected()) {
                    h1 = (ti - 104);
                }
                temp = Integer.toString(h1);

                if (h1 < bt) {
                    editHasil1.setText("Berat badan ideal anda" + temp);
                    editHasil2.setText("Maaf " + editNama.getText() + (" , Sepertinya anda terlalu GENDUT"));
                    editHasil3.setText("Banyaklah berolahraga dan hindari makanan berkolestrol");
                } else if (h1 > bt) {
                    editHasil1.setText("Berat badan ideal anda" + temp);
                    editHasil2.setText("Maaf " + editNama.getText() + (" , Sepertinya anda terlalu KURUS"));
                    editHasil3.setText("Banyaklah mengkonsumsi makanan berkarbohidrat");
                } else {
                    editHasil1.setText("Berat badan ideal anda" + temp);
                    editHasil2.setText("Hallo " + editNama.getText() + (" , Berat badan anda sudah ideal"));
                    editHasil3.setText("Lanjutkan pola makan teratur dan gaya hidup sehat :) ");
                }
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNama.setText("");
                editBerat.setText("");
                editTinggi.setText("");
                editHasil1.setText("");
                editHasil2.setText("");
                editHasil3.setText("");
            }
        });
    }
}
