package com.stackroute.i2ps.controller;

import com.stackroute.i2ps.domain.Movie;
import com.stackroute.i2ps.domain.User;
import com.stackroute.i2ps.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping(value= "/api/v1/i2ps/Movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public Collection<Movie> getAll(){
        return movieService.getAll();
    }

    @PostMapping(value="/movie/saveMovie")
    public ResponseEntity saveMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        movie=movieService.saveMovie(movie.getId(),movie.getTitle(),movie.getDuration());
        responseEntity=new ResponseEntity(movie, HttpStatus.CREATED);


return responseEntity;

    }


    @DeleteMapping("/movie/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "Deleted Movie";


    }

    @GetMapping("/getMovie/{name}")
    public Movie getMovie(@PathVariable String name)    {

        return movieService.findByName(name);
    }

    @DeleteMapping("/deleteMovies")
    public String deleteAllMovies() {
        movieService.deleteAllMovies();
        return "Deleted All Movies";


    }

    @PutMapping("/movie/{id}")
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);

    }
}


