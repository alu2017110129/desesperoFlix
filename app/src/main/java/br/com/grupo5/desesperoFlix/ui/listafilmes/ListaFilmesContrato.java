package br.com.grupo5.desesperoFlix.ui.listafilmes;

import java.util.List;

import br.com.grupo5.desesperoFlix.databinding.model.Filme;

public interface ListaFilmesContrato {

    interface ListaFilmesView {

        void mostraFilmes(List<Filme> filmes);

        void mostraErro();
    }

    interface ListaFilmesPresenter {

        void obtemFilmes();

        void destruirView();
    }
}
