package br.com.grupo5.desesperoFlix.ui.detalhesfilme;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.grupo5.desesperoFlix.R;
import br.com.grupo5.desesperoFlix.databinding.model.Filme;

public class DetalhesFilmeActivity extends AppCompatActivity {

    public static final String EXTRA_FILME = "EXTRA_FILME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_filme);

        TextView textTituloFilme = findViewById(R.id.original_title);

        final Filme filme = (Filme) getIntent().getSerializableExtra(EXTRA_FILME);

        textTituloFilme.setText(filme.getOriginal_title());
    }
}
