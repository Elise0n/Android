package com.example.biblioteca.Data;

import com.example.biblioteca.Model.Libro;
import com.example.biblioteca.R;
import java.util.ArrayList;
import java.util.List;

public class LibroRepo {
    public List<Libro> getLibros() {
        ArrayList<Libro> list = new ArrayList<>();
        list.add(new Libro(R.drawable.libro1, "Cien años de soledad", "García Márquez",
                "Realismo mágico y saga de los Buendía.", 1967));
        list.add(new Libro(R.drawable.libro2, "1984", "George Orwell",
                "Distopía sobre vigilancia y totalitarismo.", 1949));
        list.add(new Libro(R.drawable.libro3, "El principito", "Antoine de Saint-Exupéry",
                "Fábula sobre amistad e imaginación.", 1943));
        list.add(new Libro(R.drawable.libro4, "Harry Potter y la piedra filosofal", "J. K. Rowling",
                "Inicio de la saga del joven mago.", 1997));
        list.add(new Libro(R.drawable.libro5, "La comunidad del anillo", "J. R. R. Tolkien",
                "La Compañía y el Anillo Único.", 1954));
        return list;
    }
}
