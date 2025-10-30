package io.javabrains.rating_data_service.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.rating_data_service.modules.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResources {
	@RequestMapping("/{movieid}")
	public Rating getRating(@PathVariable("movieid") String movieid ) {
		return new Rating(movieid,4);
	}

}
