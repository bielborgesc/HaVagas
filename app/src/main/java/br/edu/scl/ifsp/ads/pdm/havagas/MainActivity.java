package br.edu.scl.ifsp.ads.pdm.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.edu.scl.ifsp.ads.pdm.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private Candidato candidato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}