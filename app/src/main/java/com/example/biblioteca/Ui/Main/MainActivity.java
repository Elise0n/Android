package com.example.biblioteca.Ui.Main;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.biblioteca.Model.Libro;
import com.example.biblioteca.Ui.Main.Adapters.LibroAdapter;
import com.example.biblioteca.Ui.Main.Detail.DetailActivity;
import com.example.biblioteca.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding b;
    private MainViewModel vm;
    private LibroAdapter adapter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        vm = new ViewModelProvider(this).get(MainViewModel.class);
        adapter = new LibroAdapter(this, new ArrayList<>());
        b.lvBooks.setAdapter(adapter);

        vm.getLibros().observe(this, list -> { adapter.clear(); if (list != null) adapter.addAll(list); });
        vm.cargarLibros();

        b.btnBuscar.setOnClickListener(v -> vm.buscar(b.etQuery.getText().toString()));

        b.lvBooks.setOnItemClickListener((parent, view, position, id) -> {
            Libro sel = adapter.getItem(position);
            Intent i = new Intent(this, DetailActivity.class);
            i.putExtra("libro", sel);
            startActivity(i);
        });
    }
}
