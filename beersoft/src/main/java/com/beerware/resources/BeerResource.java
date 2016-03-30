package com.beerware.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beerware.domain.Beer;
import com.beerware.service.BeerService;

@RestController
@RequestMapping("/beer")
public class BeerResource {

	@Autowired
	private BeerService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return service.getBeers();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarProduto(@PathVariable("id") Integer id) {
		try {
			Beer beer = service.getBeerById(id);
			return ResponseEntity.ok(beer);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvarProduto(@RequestBody Beer beer) {
		try {
			beer = service.saveBeer(beer);
			return new ResponseEntity<Beer>(beer, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

}
