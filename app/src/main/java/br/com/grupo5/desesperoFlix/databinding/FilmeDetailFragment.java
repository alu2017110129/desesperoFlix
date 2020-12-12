package br.com.grupo5.desesperoFlix.databinding;


import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import org.parceler.Parcels;

import br.com.grupo5.desesperoFlix.R;
import br.com.grupo5.desesperoFlix.databinding.model.Filme;


public class FilmeDetailFragment extends Fragment {
    private static final String EXTRA_FILME = "filme";

    public static FilmeDetailFragment newInstance(Filme filme) {
        FilmeDetailFragment fragment = new FilmeDetailFragment();
        Bundle args = new Bundle();
        Parcelable p = Parcels.wrap(filme);
        args.putParcelable(EXTRA_FILME, p);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Filme filme = null;
        if (getArguments() != null) {
            Parcelable p = getArguments().getParcelable(EXTRA_FILME);
            filme = Parcels.unwrap(p);
        }
        View view = inflater.inflate(R.layout.fragment_detail_filme, container, false);

        FragmentDetailFilmeBinding fdlb = FragmentDetailFilmeBinding.bind(view);
        fdlb.setFilme(filme);

        return view;
    }
}
