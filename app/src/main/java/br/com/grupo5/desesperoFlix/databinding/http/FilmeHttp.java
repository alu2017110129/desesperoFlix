package br.com.grupo5.desesperoFlix.databinding.http;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.grupo5.desesperoFlix.databinding.model.Filme;

public class FilmeHttp {

    public static List<Filme> getEditoraFromJson(String json) throws JSONException {
        List<Filme> Filmes = new ArrayList<>();

        Gson gson = new Gson();
        JSONObject jsonResult = new JSONObject(json);
        JSONArray jsonItems = jsonResult.getJSONArray("items");
        for (int i = 0; i < jsonItems.length(); i++) {
            JSONObject jsonFilme = jsonItems.getJSONObject(i);
            JSONObject jsonVolumeInfo = jsonFilme.getJSONObject("volumeInfo");

            Filme Filme = gson.fromJson(jsonVolumeInfo.toString(), Filme.class);
            Filmes.add(Filme);
        }
        return Filmes;
    }
}
