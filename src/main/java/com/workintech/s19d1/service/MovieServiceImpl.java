package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.MovieRepository;
import com.workintech.s19d1.validation.HollywoodValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        optionalMovie.orElseThrow(() -> {
            HollywoodValidation.isMovieNull(id);
            return null;
        });
        if(optionalMovie.isPresent())
        {
            return optionalMovie.get();
        }
        return null;
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Long id, Movie movie) {
        Movie updatedMovie = findById(id);
        updatedMovie.setId(movie.getId());
        updatedMovie.setRating(movie.getRating());
        updatedMovie.setReleaseDate(movie.getReleaseDate());
        updatedMovie.setName(movie.getName());
        updatedMovie.setDirectorName(movie.getDirectorName());
        updatedMovie.setActors(movie.getActors());
        return movieRepository.save(updatedMovie);
    }

    @Override
    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }
}
