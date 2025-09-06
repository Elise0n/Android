package com.example.biblioteca.Ui.Main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.biblioteca.Data.LibroRepo;
import com.example.biblioteca.Model.Libro;
import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    private final LibroRepo repo = new LibroRepo();
    private final MutableLiveData<List<Libro>> libros = new MutableLiveData<>();

    public LiveData<List<Libro>> getLibros() { return libros; }

    public void cargarLibros() { libros.setValue(repo.getLibros()); }

    public void buscar(String query) {
        List<Libro> base = repo.getLibros();
        if (query == null || query.trim().isEmpty()) { libros.setValue(base); return; }
        String q = query.trim().toLowerCase();
        List<Libro> filtered = new ArrayList<>();
        for (Libro l: base) {
            if (l.getTitulo().toLowerCase().contains(q) || l.getAutor().toLowerCase().contains(q))
                filtered.add(l);
        }
        libros.setValue(filtered);
    }
}
