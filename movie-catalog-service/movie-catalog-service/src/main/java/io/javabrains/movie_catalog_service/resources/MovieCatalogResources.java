package io.javabrains.movie_catalog_service.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.javabrains.movie_catalog_service.models.CatalogItem;
import io.javabrains.movie_catalog_service.models.Movie;
import io.javabrains.movie_catalog_service.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {
	
	
	// @Autowired	
//	 private RestTemplate restTemplate; 
	 
	 @Autowired
	 private WebClient.Builder webClientbuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
       
  //  	RestTemplate restTemplate=new RestTemplate();
//    	Movie movie=restTemplate.getForObject("http://localhost:9090/movie/3", Movie.class);;
    	
  	
    	
    	List<Rating> ratings=Arrays.asList(
    			new Rating("1234",4),
    			new Rating("5678",3)
    			);
    	return ratings.stream()
    		    .map(rating -> {
    		    	
    		    	
//    		        Movie movie = restTemplate.getForObject("http://localhost:9090/movie/" + rating.getMovieId(), Movie.class);
    		    	
    		    	Movie movie=webClientbuilder.build()
    		    	        .get()
    		    	        .uri("http://localhost:9090/movie/" + rating.getMovieId())
    		    	        .retrieve()
    		    	        .bodyToMono(Movie.class)  // asynchronously get response
    		    	        .block();  // converts async → sync (for simple use)
    		        return new CatalogItem(movie.getName(), "Test", rating.getRating());
    		    })
    		    .collect(Collectors.toList());

    		
    	//For each movie id,call movie info service and get details
    	
    	// Put them all together
//        return Collections.singletonList(
//            new CatalogItem("Dabang", "Test", "4")
//        );
    }
}
