package com.example.biblioteca.Ui.Detail;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.biblioteca.Model.Libro;
import com.example.biblioteca.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding b;
    private DetailViewModel vm;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        vm = new ViewModelProvider(this).get(DetailViewModel.class);

        // Obtenemos el libro del Intent y se lo pasamos al ViewModel
        Libro libro = (Libro) getIntent().getSerializableExtra("libro");
        if (libro != null) {
            vm.cargarLibro(libro);
        }

        // Observamos los cambios en el libro y actualizamos la interfaz de usuario
        vm.getLibro().observe(this, sel -> {
            if (sel != null) {
                b.imgCover.setImageResource(sel.getCoverResId());
                b.tvTitle.setText(sel.getTitulo());
                b.tvAuthor.setText(sel.getAutor());
                b.tvDescription.setText(sel.getDescripcion());
            }
        });
    }
}