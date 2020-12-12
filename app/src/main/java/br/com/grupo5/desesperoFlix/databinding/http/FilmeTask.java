package br.com.grupo5.desesperoFlix.databinding.http;

import android.os.AsyncTask;

import java.lang.ref.WeakReference;
import java.util.List;

import br.com.grupo5.desesperoFlix.databinding.FilmeListFragment;
import br.com.grupo5.desesperoFlix.databinding.model.Filme;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FilmeTask extends AsyncTask<String, Void, List<Filme>> {

    public static final String API_KEY = "3f6489060a40b269d688e6e26c99c689";
    public static final String BASE_URL = "https://api.themoviedb.org/3/movie/550?api_key="+ API_KEY;

    private WeakReference<FilmeListFragment> fragment;

    public FilmeTask(FilmeListFragment fragment) {
        this.fragment = new WeakReference<>(fragment);
    }

    public void setFragment(FilmeListFragment fragment) {
        this.fragment = new WeakReference<>(fragment);
    }

    @Override
        protected List<Filme> doInBackground(String... params) {

            OkHttpClient client = new OkHttpClient();

            final String args = params[0];
            final String url = String.format(BASE_URL, args);

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                String jsonString = response.body().string();

                List<Filme> Filmes = FilmeHttp.getEditoraFromJson(jsonString);

                return Filmes;

            } catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Filme> Filmes) {
            super.onPostExecute(Filmes);
            FilmeListFragment llf = fragment.get();
            if (llf == null) return;

            if (Filmes != null){
                llf.setFilmes(Filmes);
            } else {
                llf.showError();
            }
        }
    }