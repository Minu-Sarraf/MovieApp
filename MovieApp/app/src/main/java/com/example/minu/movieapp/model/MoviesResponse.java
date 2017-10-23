package com.example.minu.movieapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by minu on 10/5/2017.
 */

public class MoviesResponse {

    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<MoviePopular> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MoviePopular> getResults() {
        return results;
    }
    public void setResults(List<MoviePopular> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

}
