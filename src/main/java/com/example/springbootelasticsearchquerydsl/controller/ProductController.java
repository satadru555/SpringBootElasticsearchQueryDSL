package com.example.springbootelasticsearchquerydsl.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.springbootelasticsearchquerydsl.entity.Product;
import com.example.springbootelasticsearchquerydsl.service.ElasticSearchService;
import com.example.springbootelasticsearchquerydsl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/apis")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ElasticSearchService elasticSearchService;

    @GetMapping("/findAll")
    Iterable<Product> findAll(){
       return productService.getProducts();

    }

    @PostMapping("/insert")
    public Product insertProduct(@RequestBody  Product product){
       return productService.insertProduct(product);
    }

    @GetMapping("/matchAll")
    public String matchAll() throws IOException {
        SearchResponse<Map> searchResponse =  elasticSearchService.matchAllServices();
        System.out.println(searchResponse.hits().hits().toString());
        return searchResponse.hits().hits().toString();
    }
//matchAllProducts video content
    @GetMapping("/matchAllProducts")
    public List<Product> matchAllProducts() throws IOException {
        SearchResponse<Product> searchResponse =  elasticSearchService.matchAllProductsServices();
        System.out.println(searchResponse.hits().hits().toString());

        List<Hit<Product>> listOfHits= searchResponse.hits().hits();
        List<Product> listOfProducts  = new ArrayList<>();
        for(Hit<Product> hit : listOfHits){
            listOfProducts.add(hit.source());
        }
        return listOfProducts;
    }

    @GetMapping("/matchAllProducts/{fieldValue}")
    public List<Product> matchAllProductsWithName(@PathVariable String fieldValue) throws IOException {
        SearchResponse<Product> searchResponse =  elasticSearchService.matchProductsWithName(fieldValue);
        System.out.println(searchResponse.hits().hits().toString());

        List<Hit<Product>> listOfHits= searchResponse.hits().hits();
        List<Product> listOfProducts  = new ArrayList<>();
        for(Hit<Product> hit : listOfHits){
            listOfProducts.add(hit.source());
        }
        return listOfProducts;
    }
    
//    @GetMapping("/boolQuery/{productName}/{qty}")
//    public List<Product> boolQuery(@PathVariable String productName, @PathVariable Integer qty) throws IOException {
//
//        SearchResponse<Product> searchResponse =  elasticSearchService.boolQueryImpl(productName,qty);
//        System.out.println(searchResponse.hits().hits().toString());
//
//        List<Hit<Product>> listOfHits= searchResponse.hits().hits();
//        List<Product> listOfProducts  = new ArrayList<>();
//        for(Hit<Product> hit : listOfHits){
//            listOfProducts.add(hit.source());
//        }
//        return listOfProducts;
//    }
    
    
    
    @GetMapping("/fuzzySearch/{approximateProductName}")
    List<Product> fuzzySearch( @PathVariable String approximateProductName ) throws IOException {
        SearchResponse<Product> searchResponse = elasticSearchService.fuzzySearch(approximateProductName);
       List<Hit<Product>> hitList = searchResponse.hits().hits();
        System.out.println(hitList);
        List<Product> productList = new ArrayList<>();
        for(Hit<Product> hit :hitList){
            productList.add(hit.source());
        }
        return productList;
    }


    @GetMapping("/boolQuery/{productName}/{description}")
    public List<Product> boolQueryTemplate(@PathVariable String productName, @PathVariable String description) throws IOException {
   return elasticSearchService.boolQueryTemplate(productName,description);
    }


    @GetMapping("/boolQueryNested/{productName}/{description}")
    public List<Product> boolQueryTemplateNested(@PathVariable String productName, @PathVariable String description) throws IOException {
        return elasticSearchService.boolQueryTemplateNested(productName,description);
    }

}
