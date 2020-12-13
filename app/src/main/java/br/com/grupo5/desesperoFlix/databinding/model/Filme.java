package br.com.grupo5.desesperoFlix.databinding.model;

import org.parceler.Parcel;

@Parcel
public class Filme
{
    private String genresName;
    private String homePage;
    private int ID;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private String popularity;
    private Thumbnail poster_path;
    private String production_companies_id;

    public Filme() {
    }
    public String getGenresName() {
        return genresName;
    }
    public void setGenresName(String genresName) {
        this.genresName = genresName;
    }
    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }
    public String getHomePage() {
        return homePage;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getImdb_id() {
        return imdb_id;
    }
    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }
    public String getOriginal_language() {
        return original_language;
    }
    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }
    public String getOriginal_title() {
        return original_title;
    }
    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public String getPopularity() {
        return popularity;
    }
    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }
    public Thumbnail getPoster_path() {
        return poster_path;
    }
    public void setPoster_path(Thumbnail poster_path) {
        this.poster_path = poster_path;
    }
    public String getProduction_companies_id() {
        return production_companies_id;
    }
    public void setProduction_companies_id(String production_companies_id) {
        this.production_companies_id = production_companies_id;
    }
}
