package com.iffat.springboot.resttemplate.client;

import com.iffat.springboot.resttemplate.model.BeerDTO;
import com.iffat.springboot.resttemplate.model.BeerDTOPageImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;

    private static final String BASE_URL = "http://localhost:8080";
    private static final String GET_BEER_PATH = "/api/v1/beer";

    @Override
    public Page<BeerDTO> listBeers() {
        RestTemplate restTemplate = restTemplateBuilder.build();

//        ResponseEntity<String> stringResponse = restTemplate.getForEntity(
//                BASE_URL + GET_BEER_PATH,
//                String.class
//        );
//
//        ResponseEntity<Map> mapResponse = restTemplate.getForEntity(
//                BASE_URL + GET_BEER_PATH,
//                Map.class
//        );
//        ResponseEntity<JsonNode> jsonResponse = restTemplate.getForEntity(
//                BASE_URL + GET_BEER_PATH,
//                JsonNode.class
//        );

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(GET_BEER_PATH);

        ResponseEntity<BeerDTOPageImpl> response = restTemplate.getForEntity(
                uriComponentsBuilder.toUriString(),
                BeerDTOPageImpl.class
        );

//        jsonResponse.getBody().findPath("_embedded").findPath("beer")
//                .elements().forEachRemaining(node -> {
//                    System.out.println(node.get("beerName").asText());
//                });

        return response.getBody();
    }
}
