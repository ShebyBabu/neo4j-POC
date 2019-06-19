package com.stackroute.i2ps.service;

import com.stackroute.i2ps.domain.Movie;
import com.stackroute.i2ps.domain.User;


import java.util.Collection;

public interface MovieService {
    public Collection<Movie> getAll();

    public Movie saveMovie(Long movieId, String movieName, int movieDuration);
    public void deleteMovie(Long id);
    public Movie findByName(String name);
    public void deleteAllMovies();
    public Movie updateMovie(Movie movie);
}
