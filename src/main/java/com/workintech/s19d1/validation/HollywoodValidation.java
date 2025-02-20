package com.workintech.s19d1.validation;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class HollywoodValidation {
    public static void isMovieNull(Long id)
    {
        throw new ApiException("Movie is not found with id: "+id, HttpStatus.NOT_FOUND);
    }

    public static void isActorNull(Long id)
    {
        throw new ApiException("actor is not found with id: "+id, HttpStatus.NOT_FOUND);
    }
}
