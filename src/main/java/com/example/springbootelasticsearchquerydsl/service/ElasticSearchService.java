package com.example.springbootelasticsearchquerydsl.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.*;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.springbootelasticsearchquerydsl.entity.Product;
import com.example.springbootelasticsearchquerydsl.repo.ProductRepo;
import com.example.springbootelasticsearchquerydsl.util.ElasticSearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import static co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders.match;

@Service
public class ElasticSearchService {

    @Autowired
    private ElasticsearchClient  elasticsearchClient;

    private final ProductRepo productRepo;
    private final ElasticsearchTemplate elasticsearchTemplate;

    public ElasticSearchService(ProductRepo productRepo, ElasticsearchTemplate elasticsearchTemplate) {
        this.productRepo = productRepo;
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    public SearchResponse<Map> matchAllServices() throws IOException {
        Supplier<Query> supplier  = ElasticSearchUtil.supplier();
       SearchResponse<Map> searchResponse = elasticsearchClient.search(s->s.query(supplier.get()),Map.class);
        System.out.println("elasticsearch query is "+supplier.get().toString());
        return searchResponse;
    }
    //matchAllProducts video content

    public SearchResponse<Product> matchAllProductsServices() throws IOException {
        Supplier<Query> supplier  = ElasticSearchUtil.supplier();
        SearchResponse<Product> searchResponse = elasticsearchClient.search(s->s.index("products").query(supplier.get()),Product.class);
        System.out.println("elasticsearch query is "+supplier.get().toString());
        return searchResponse;
    }

    //matchProductWithName

    public SearchResponse<Product> matchProductsWithName(String fieldValue) throws IOException {
        Supplier<Query> supplier  = ElasticSearchUtil.supplierWithNameField(fieldValue);
        SearchResponse<Product> searchResponse = elasticsearchClient.search(s->s.index("products").query(supplier.get()),Product.class);
        System.out.println("elasticsearch query is "+supplier.get().toString());
        return searchResponse;
    }
    
  //matchProductWithName and quantity
    public SearchResponse<Product> boolQueryImpl(String productName, Integer qty) throws IOException {
        Supplier<Query> supplier  = ElasticSearchUtil.supplierQueryForBoolQuery(productName, qty);
        SearchResponse<Product> searchResponse = elasticsearchClient.search(s->s.index("products").query(supplier.get()),Product.class);
        System.out.println("elasticsearch query is "+supplier.get().toString());
        return searchResponse;
    }
    
    // fuzzysearch for name
    public SearchResponse<Product> fuzzySearch(String approximateProductName) throws IOException {
        Supplier<Query>  supplier = ElasticSearchUtil.createSupplierQuery(approximateProductName);
       SearchResponse<Product> response = elasticsearchClient
               .search(s->s.index("products").query(supplier.get()),Product.class);
        System.out.println("elasticsearch supplier fuzzy query "+supplier.get().toString());
        return response;
    }

    public List<Product> boolQueryTemplate(String name, String description) throws IOException {
        var criteria = QueryBuilders.bool(builder -> builder.must(
                match(queryName -> queryName.field("name").query(name)),
                match(queryDescription -> queryDescription.field("description").query(description))
              //  match(queryAddressOrder -> queryAddressOrder.field("addressOrder").query(addressOrder))
                //match(queryCountrycode -> queryCountrycode.field("countrycode").query(countrycode))
        ));
        List<Product> product = elasticsearchTemplate.search(NativeQuery.builder().withQuery(criteria).build(), Product.class)
                .stream().map(SearchHit::getContent).toList();
        return product;
    }

    public List<Product> boolQueryTemplateNested(String name, String description) throws IOException {



//        QueryBuilders.bool().must(nested("XX", QueryBuilders.bool(builder -> builder.must(
//                match(queryName -> queryName.field("name").query(name)));

        var addressesType = MatchQuery.of(ts -> ts.field("addresses.customerAddressId").query("458"))._toQuery();
        var innerQueryBuilder = BoolQuery.of(bq -> bq.filter(addressesType));
        Query q = NestedQuery.of(n -> n.path("addresses").query(innerQueryBuilder._toQuery()).scoreMode(ChildScoreMode.None))._toQuery();
        var request = SearchRequest.of(s -> s.query(q));

                var criteria = QueryBuilders.bool(builder -> builder.must(
                match(queryName -> queryName.field("name").query(name)),
                match(queryDescription -> queryDescription.field("description").query(description))

        ));
        List<Product> product = elasticsearchTemplate.search(NativeQuery.builder().withQuery(criteria).build(), Product.class)
                .stream().map(SearchHit::getContent).toList();
        return product;
    }

}
