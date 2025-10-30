package io.javabrains.movie_catalog_service.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.movie_catalog_service.models.CatalogItem;
import io.javabrains.movie_catalog_service.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
       
    	RestTemplate restTemplate=new RestTemplate();
    	restTemplate.getForObject(null, null)
    	
    	
    	
    	List<Rating> ratings=Arrays.asList(
    			new Rating("1234",4),
    			new Rating("5678",3)
    			);
    	return ratings.stream().map(rating->
    		new CatalogItem("Dabang", "Test", "4")
    	).collect(Collectors.toList());
    	
    		
    	//For each movie id,call movie info service and get details
    	
    	// Put them all together
//        return Collections.singletonList(
//            new CatalogItem("Dabang", "Test", "4")
//        );
    }
}
