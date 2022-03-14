package com.UpGrad.RestClient.restTemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateDemo {
    public static void main(String[] args) {
        /**Fetch the data in the form of plain JSON */

        //create a RestTemplate Object
        RestTemplate restTemplate = new RestTemplate();

        String URI = "http://localhost:8080/demo_app/v1/ideas/"; //URI to get all the ideas

        ResponseEntity<String> ideaResponse = restTemplate.getForEntity(URI, String.class); //getForEntity takes in URI and its class type and returns ResponseEntity object

        //prints the body of the ResponseEntity
        System.out.println("<-----------------Response Body----------------->");
        System.out.println(ideaResponse.getBody());
        
        //prints the headers of the ResponseEntity
        System.out.println("<-----------------Response Headers----------------->");
        System.out.println(ideaResponse.getHeaders());

        //prints the status code of the ResponseEntity
        System.out.println("<-----------------Response Status Code----------------->");
        System.out.println(ideaResponse.getStatusCode());
    }
}
