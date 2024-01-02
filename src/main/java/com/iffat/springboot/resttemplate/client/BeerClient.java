package com.iffat.springboot.resttemplate.client;

import com.iffat.springboot.resttemplate.model.BeerDTO;
import com.iffat.springboot.resttemplate.model.BeerStyle;
import org.springframework.data.domain.Page;

public interface BeerClient {

    Page<BeerDTO> listBeers();

    Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize);
}
