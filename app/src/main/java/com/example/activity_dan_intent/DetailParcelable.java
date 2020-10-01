package com.example.activity_dan_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailParcelable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_parcelable);

        TextView nama = (TextView) findViewById(R.id.tv_name_content);
        TextView nim = (TextView) findViewById(R.id.tv_nim_content);
        TextView tanggal = (TextView) findViewById(R.id.tv_birth_date_content);
        TextView jk = (TextView) findViewById(R.id.tv_gender_content);
        TextView jurusan = (TextView) findViewById(R.id.tv_department_content);

        TampilData show = getIntent().getParcelableExtra("TAMPIL");

        nama.setText( show.getNama());
        nim.setText( show.getNim());
        tanggal.setText( show.getTanggal());
        jk.setText( show.getJk());
        jurusan.setText( show.getJurusan());
    }
}