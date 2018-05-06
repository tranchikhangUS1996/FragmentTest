package com.tranchikhang.fragmenttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_WORD_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Detail_Fragment detail_fragment = (Detail_Fragment) getSupportFragmentManager().findFragmentById(R.id.detail_fraggment);
        int workID = (int) getIntent().getExtras().get(EXTRA_WORD_ID);
        detail_fragment.setId(workID);
    }
}
