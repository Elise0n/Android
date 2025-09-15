package com.example.biblioteca.Ui.Detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.biblioteca.Model.Libro;

public class DetailViewModel extends ViewModel {
    private final MutableLiveData<Libro> libro = new MutableLiveData<>();

    public LiveData<Libro> getLibro() {
        return libro;
    }

    public void cargarLibro(Libro libro) {
        this.libro.setValue(libro);
    }
}