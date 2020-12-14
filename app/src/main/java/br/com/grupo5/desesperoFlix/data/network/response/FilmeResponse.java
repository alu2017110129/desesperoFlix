package br.com.grupo5.desesperoFlix.data.network.response;

import com.squareup.moshi.Json;

import br.com.grupo5.desesperoFlix.databinding.model.Thumbnail;

public class FilmeResponse {

    @Json(name = "poster_path")
    private final Thumbnail caminhoPoster;

    @Json(name = "original_title")
    private final String tituloOriginal;

    public FilmeResponse(Thumbnail caminhoPoster, String tituloOriginal) {
        this.caminhoPoster = caminhoPoster;
        this.tituloOriginal = tituloOriginal;
    }

    public Thumbnail getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }
}
