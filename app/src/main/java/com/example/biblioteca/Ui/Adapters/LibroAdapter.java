package com.example.biblioteca.Ui.Main.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.biblioteca.Model.Libro;
import com.example.biblioteca.R;
import java.util.List;

public class LibroAdapter extends ArrayAdapter<Libro> {
    private final LayoutInflater inflater;
    static class VH { ImageView img; TextView title, author; }

    public LibroAdapter(@NonNull Context ctx, @NonNull List<Libro> data){
        super(ctx, 0, data);
        inflater = LayoutInflater.from(ctx);
    }

    @NonNull @Override public View getView(int pos, View v, ViewGroup parent){
        VH h;
        if (v == null){
            v = inflater.inflate(R.layout.item_libro, parent, false);
            h = new VH();
            h.img = v.findViewById(R.id.imgCover);
            h.title = v.findViewById(R.id.tvTitle);
            h.author = v.findViewById(R.id.tvAuthor);
            v.setTag(h);
        } else h = (VH) v.getTag();

        Libro b = getItem(pos);
        if (b != null){
            h.img.setImageResource(b.getCoverResId());
            h.title.setText(b.getTitulo());
            h.author.setText(b.getAutor());
        }
        return v;
    }
}
