package com.example.biblioteca.Ui.Main.Detail;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.biblioteca.Model.Libro;
import com.example.biblioteca.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding b;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        Libro libro = (Libro) getIntent().getSerializableExtra("libro");
        if (libro != null) {
            b.imgCover.setImageResource(libro.getCoverResId());
            b.tvTitle.setText(libro.getTitulo());
            b.tvAuthor.setText(libro.getAutor());
            b.tvDescription.setText(libro.getDescripcion());
        }
    }
}
