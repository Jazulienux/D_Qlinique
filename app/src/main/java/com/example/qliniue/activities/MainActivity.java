package com.example.qliniue.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.qliniue.R;
import com.example.qliniue.fragments.AntrianFragment;
import com.example.qliniue.fragments.HomeFragment;
import com.example.qliniue.fragments.KonsulFragment;
import com.example.qliniue.fragments.MedicalRecordFragment;
import com.example.qliniue.fragments.PengaturanFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private String username;
    private String password;
    private HomeFragment homeFragment;
    private AntrianFragment antrianFragment;
    private KonsulFragment konsulFragment;
    private MedicalRecordFragment medicalRecordFragment;
    private PengaturanFragment pengaturanFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            username = extras.getString("USERNAME_KEY");
            password = extras.getString("PASSWORD_KEY");
            loadFragment(homeFragment = HomeFragment.newInstance(username,password));
        }
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
                fragment = homeFragment = HomeFragment.newInstance(username,password);
                break;
            case R.id.antrian:
                fragment = antrianFragment = AntrianFragment.newInstance(username,password);
                break;
            case R.id.medical_record:
                fragment = medicalRecordFragment =  MedicalRecordFragment.newInstance(username,password);
                break;

            case R.id.konsultasi:
                fragment = konsulFragment = KonsulFragment.newInstance(username,password);
                break;

            case R.id.pengaturan:
                fragment = pengaturanFragment = PengaturanFragment.newInstance(username,password);
                break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}