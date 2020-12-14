package br.com.grupo5.desesperoFlix.data.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.grupo5.desesperoFlix.databinding.model.Filme;
import br.com.grupo5.desesperoFlix.data.network.response.FilmeResponse;

public class FilmeMapper {

    public static List<Filme> deResponseParaDominio(List<FilmeResponse> listaFilmeResponse) {
        List<Filme> listaFilmes = new ArrayList<>();

        for (FilmeResponse filmeResponse : listaFilmeResponse) {
            final Filme filme = new Filme(filmeResponse.getTituloOriginal(), filmeResponse.getCaminhoPoster());
            listaFilmes.add(filme);
        }

        return listaFilmes;
    }
}