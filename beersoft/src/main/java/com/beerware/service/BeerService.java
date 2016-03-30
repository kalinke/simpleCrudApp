package com.beerware.service;
	
import org.springframework.stereotype.Service;

import com.beerware.domain.Beer;
import com.beerware.repository.BeerRepository;

@Service
public class BeerService {

	private BeerRepository beerRepository;
	
	public Beer saveBeer(Beer beer){
		return beerRepository.save(beer);
	}
	
	public Beer getBeerById(Integer id){
		return beerRepository.findById(id);
	}
	
	public String getBeers(){
		return "beers";
	}
	
}
