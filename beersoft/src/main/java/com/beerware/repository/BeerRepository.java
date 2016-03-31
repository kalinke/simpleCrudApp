package com.beerware.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beerware.domain.Beer;

public interface BeerRepository extends CrudRepository<Beer, Integer>{

	public Beer save(Beer beer);
	
	public Beer findById(Integer id);
}
