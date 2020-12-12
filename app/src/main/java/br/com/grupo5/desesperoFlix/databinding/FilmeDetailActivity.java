package br.com.grupo5.desesperoFlix.databinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.parceler.Parcels;

import br.com.grupo5.desesperoFlix.R;
import br.com.grupo5.desesperoFlix.databinding.model.Filme;

public class FilmeDetailActivity extends AppCompatActivity {

    public static final String EXTRA_FILME = "filme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_filme);

        Filme filme = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_FILME));

        FilmeDetailFragment dlf = FilmeDetailFragment.newInstance(filme);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.detalhe, dlf, "detalhe")
                .commit();
    }
}
