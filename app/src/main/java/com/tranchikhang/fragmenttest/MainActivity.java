package com.tranchikhang.fragmenttest;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if(fragmentContainer!=null){
            Detail_Fragment fragment = new Detail_Fragment();
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            fragment.setId((int) id);
            ft.replace(R.id.fragment_container,fragment);
            ft.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }
        else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORD_ID, (int) id);
            startActivity(intent);
        }
    }
}
