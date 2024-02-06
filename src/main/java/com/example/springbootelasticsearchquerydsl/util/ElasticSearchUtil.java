package com.example.springbootelasticsearchquerydsl.util;

import co.elastic.clients.elasticsearch._types.query_dsl.*;


import lombok.val;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders.match;


public class ElasticSearchUtil {

    public static Supplier<Query> supplier(){
        Supplier<Query> supplier = ()->Query.of(q->q.matchAll(matchAllQuery()));
        return supplier;
    }

    public static MatchAllQuery matchAllQuery(){
    	//val matchQueryBuilder = new MatchAllQuery.Builder();
        return new MatchAllQuery.Builder().build();
    }

    public static Supplier<Query> supplierWithNameField(String fieldValue){
        Supplier<Query> supplier = ()->Query.of(q->q.match(matchQueryWithNameField(fieldValue)));
        return supplier;
    }

    public static MatchQuery matchQueryWithNameField(String fieldValue){
       // val  matchQuery = new MatchQuery.Builder();
        return  new MatchQuery.Builder().field("name").query(fieldValue).build();
    }
    
    
    

    public static Supplier<Query> supplierQueryForBoolQuery(String productName, Integer qty){
        Supplier<Query> supplier = ()->Query.of(q->q.bool(boolQuery(productName,qty)));
        return supplier;
    }

     public static BoolQuery boolQuery(String productName, Integer qty){

       // val boolQuery  = new BoolQuery.Builder();
       // return new BoolQuery.Builder().filter(termQuery(productName)).must(matchQuery(qty)).build();
    	 return new BoolQuery.Builder().must(matchQuery(qty)).build();
     }

      public static List<Query> termQuery(String productName){
        final List<Query> terms = new ArrayList<>();
       // val termQuery = new TermQuery.Builder();
        terms.add(Query.of(q->q.term(new TermQuery.Builder().field("name").value(productName).build())));
        return terms;
      }

    public static List<Query> matchQuery(Integer qty){
        final List<Query> matches = new ArrayList<>();
       // val matchQuery = new MatchQuery.Builder();
        matches.add(Query.of(q->q.match(new MatchQuery.Builder().field("quantity").query(qty).build())));
        return matches;
    }
    
    
    
    
    public static Supplier<Query> createSupplierQuery(String approximateProductName){
        Supplier<Query> supplier = ()->Query.of(q->q.fuzzy(createFuzzyQuery(approximateProductName)));
        return  supplier;
    }


    public static FuzzyQuery createFuzzyQuery(String approximateProductName){
       // val fuzzyQuery  = new FuzzyQuery.Builder();
        return  new FuzzyQuery.Builder().field("name").value(approximateProductName).build();

    }


    private static Query createBoolQuery(String name, String description,String addressOrder,String countrycode){

        var criteria = QueryBuilders.bool(builder -> builder.must(
                match(queryName -> queryName.field("name").query(name)),
                match(queryDescription -> queryDescription.field("description").query(description))
        ));
        return criteria;
    }
    
    
    
}