package com.example.qliniue.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import com.example.qliniue.R;
import com.example.qliniue.fragments.AntrianFragment;
import com.example.qliniue.fragments.HomeFragment;
import com.example.qliniue.fragments.KonsulFragment;
import com.example.qliniue.fragments.MedicalRecordFragment;
import com.example.qliniue.fragments.PengaturanFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.halaman_utama:
                fragment = new HomeFragment();
                break;
            case R.id.antrian:
                fragment = new AntrianFragment();
                break;
            case R.id.medical_record:
                fragment = new MedicalRecordFragment();
                break;

            case R.id.konsultasi:
                fragment = new KonsulFragment();
                break;

            case R.id.pengaturan:
                fragment = new PengaturanFragment();
                break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}