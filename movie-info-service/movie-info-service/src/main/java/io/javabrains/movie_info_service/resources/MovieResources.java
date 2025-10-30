package io.javabrains.movie_info_service.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.movie_info_service.modules.Movie;

@RestController
@RequestMapping("/movie")
public class MovieResources {
	@RequestMapping("/{movieId}")
	public List<Movie> getMovie(@PathVariable("movieId") String movieId){
		return Collections.singletonList(new Movie("3","Dabang"));
	}

}
