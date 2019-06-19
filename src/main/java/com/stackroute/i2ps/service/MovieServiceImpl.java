package com.stackroute.i2ps.service;

import com.stackroute.i2ps.domain.Movie;

import com.stackroute.i2ps.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Service
public class MovieServiceImpl implements MovieService {

        @Autowired
        MovieRepository movieRepository;



        public MovieServiceImpl(MovieRepository movieRepository) {
            this.movieRepository = movieRepository;
        }

        @Override
        public Collection<Movie> getAll() {
            return movieRepository.getAllMovies();
        }



        @Override
        public Movie saveMovie(Long movieId, String movieName, int movieAge) {
            Movie savedMovie = null;
            savedMovie = movieRepository.saveNode(movieId,movieName,movieAge);


            return savedMovie;
        }


        @Override
        public void deleteMovie(Long id) {
//Long movieId=id;
//Movie u=

            movieRepository.delete(id);

        }

        @Override
        public Movie findByName(String name) {

            return movieRepository.findByName(name);
        }

        @Override
        public void deleteAllMovies() {
            movieRepository.deleteAll();
        }

        public Movie updateMovie(Movie movie)   {
            return movieRepository.save(movie);
        }
    }

