package com.example.activity_dan_intent;

import android.app.DatePickerDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editNama = (EditText) findViewById(R.id.nama_mahasiswa);
        final EditText editNim = (EditText) findViewById(R.id.nim_mahasiswa);
        final EditText editTanggal = (EditText) findViewById(R.id.tanggal_lahir);
        final Spinner jurusan = (Spinner) findViewById(R.id.spinner);
        final RadioGroup grup = (RadioGroup) findViewById(R.id.radio_grup);
        final RadioButton cowok = (RadioButton) findViewById(R.id.laki_laki);
        final RadioButton cewek = (RadioButton) findViewById(R.id.perempuan);
        Button getIn = findViewById(R.id.button_simpan);
        Button getParce = findViewById(R.id.getParcel);

        editTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                editTanggal.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }

        });

        grup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.laki_laki:
                        break;
                    case R.id.perempuan:
                        break;
                }
            }
        });

        getIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = grup.getCheckedRadioButtonId();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("data1", editNama.getText().toString());
                intent.putExtra("data2", editNim.getText().toString());
                intent.putExtra("data3", editTanggal.getText().toString());
                if(cowok.isChecked()){
                    Button cowok = (RadioButton) findViewById(selectedId);
                    intent.putExtra("data4", cowok.getText().toString());
                }else{
                    intent.putExtra("data4", cewek.getText().toString());
                }
                intent.putExtra("data5", jurusan.getSelectedItem().toString());
                startActivity(intent);
            }
        });

        getParce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = grup.getCheckedRadioButtonId();
                Button radioBut = (RadioButton) findViewById(selectedId);
                TampilData show = new TampilData(editNama.getText().toString(),editNim.getText().toString(),editTanggal.getText().toString(),radioBut.getText().toString(),jurusan.getSelectedItem().toString());
                Intent intent = new Intent(MainActivity.this, DetailParcelable.class);
                intent.putExtra("TAMPIL", show);
                startActivity(intent);
            }
        });
    }
}