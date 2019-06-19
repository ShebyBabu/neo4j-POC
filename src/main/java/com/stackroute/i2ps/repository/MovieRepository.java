package com.stackroute.i2ps.repository;

import com.stackroute.i2ps.domain.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {

        @Query("MATCH (u:Movie) RETURN u")
        Collection<Movie> getAllMovies();


        // public Movie addMovie();
        @Query("CREATE (u:Movie) SET u.id={movieId},u.title={movieName},u.duration={duration} RETURN u")
        public Movie saveNode(Long movieId, String movieName, int duration);


        @Query("MATCH (u:Movie) WHERE u.id={id} DETACH DELETE u RETURN 'node deleted' ")
//    public void delete(@Param("id") Long id);
        public void delete(Long id);


        @Query("MATCH (u:Movie) WHERE u.name={movieName} RETURN u")
        public Movie findByName(@Param("movieName") String movieName);


        @Query("MATCH (Movie) DETACH DELETE Movie")
        public void deleteAll();



//        @Query("MATCH (u:Movie) WHERE u.id={movieId} SET u.movieName={movieName},u.age={age} RETURN u")
//        Movie updateMovie(long movieId,String movieName,int age);
    }

