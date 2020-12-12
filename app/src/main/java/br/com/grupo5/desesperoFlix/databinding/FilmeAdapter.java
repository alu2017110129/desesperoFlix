package br.com.grupo5.desesperoFlix.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.grupo5.desesperoFlix.R;
import br.com.grupo5.desesperoFlix.databinding.model.Filme;


public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.ViewHolder> {

    List<Filme> mFilmes;
    FilmeClickListener mListener;

    public FilmeAdapter(List<Filme> filmes,
                        FilmeClickListener listener) {
        mFilmes = filmes;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemFilmeBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_filme,
                parent,
                false);

        final ViewHolder vh = new ViewHolder(binding);
        vh.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mListener != null) {
                            int pos = vh.getAdapterPosition();
                            Filme filme = mFilmes.get(pos);
                            mListener.onFilmeClick(filme);
                        }
                    }
                });
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int pos) {
        Filme filme = mFilmes.get(pos);
        holder.binding.setFilme(filme);
    }

    @Override
    public int getItemCount() {
        return mFilmes != null ? mFilmes.size() : 0;
    }

    public static class ViewHolder extends
            RecyclerView.ViewHolder {

        ItemFilmeBinding binding;

        public ViewHolder(ItemFilmeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
