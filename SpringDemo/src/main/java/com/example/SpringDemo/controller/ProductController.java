package com.example.SpringDemo.controller;

import com.example.SpringDemo.entity.Product;
import com.example.SpringDemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    // localhost:8080/product/save?productName=TV&productCategory=Elektronik&productPrice=10000&productUnitlnStock=1000
    @GetMapping("/save")
    public Product save(Product product){
        return productService.save(product);
    }
    //GET PUT DELETE POST
    @GetMapping("/find-all")
    public List<Product> findAll(){
        return productService.findAll();
    }
    // localhost:8080/product/find-by-id?id=2
    @GetMapping("/find-by-id")
    public Optional<Product> findById(Long id){
        return productService.findById(id);
    }
    // http://localhost:8080/product/update?id=4&productName=Vestel&productCategory=furniture&productPrice=100
    @GetMapping("/update")//PutMapping ile yapmaya çalışırsan, put request yaparsan 405 döner
    public Product update(Product product){
        return productService.update(product);
    }
    @GetMapping("/find-by-name")
    public Optional<Product> FindByProductName(String productName){
        return productService.FindByProductname(productName);
    }
    @GetMapping("/find-all-by-productname-like")// containing kullan like çalışmıyor
    public List<Product> FindAllByProductNameLike(String productName){
        return productService.FindAllByProductnameLike(productName);
    }
    @GetMapping("/find-all-by-productprice-between")
    public List<Product> FindAllByProductPriceBetween(Double start, Integer end){
        return productService.FindAllByProductPriceBetween(start,end);
    }
    @GetMapping("/find-by-productname-ignore-case")
    public Optional<Product> findByProductNameIgnoreCase(String productName){
        return productService.findByProductNameIgnoreCase(productName);
    }
    @GetMapping("/find-all-by-productname-containing-ignore-case")
    public List<Product> findAllByProductNameContainingIgnoreCase(String productName){
        return productService.findAllByProductNameContainingIgnoreCase(productName);
    }
    @GetMapping("/find-all-by-productprice-greater-than")
    public List<Product> findAllByProductPriceGreaterThan(Double productPrice){
        return productService.findAllByProductPriceGreaterThan(productPrice);
    }
    @GetMapping("/find-all-by-productunitinstock-greater-than")
    public List<Product> findAllByProductUnitlnStockGreaterThan(Integer productUnitlnStock){
        return productService.findAllByProductUnitlnStockGreaterThan(productUnitlnStock);
    }
    @GetMapping("/find-all-by-productunitinstock-greater-than-equal")
    public List<Product> findByProductPriceGreaterThanEqual(Double productPrice){
        return productService.findByProductPriceGreaterThanEqual(productPrice);
    }
    @GetMapping("/count-by-productcategory")
    public Long countByProductCategory(String productCategory){
        return productService.countByProductCategory(productCategory);
    }
    @GetMapping("/count-by-productname")
    public Long countByProductName(String productName){
        return productService.countByProductName(productName);
    }
    @GetMapping("/exists-by-productcategory")
    public boolean existsByProductCategory(String productCategory){
        return productService.existsByProductCategory(productCategory);
    }
    @GetMapping("/find-by-productcategory-is-null")
    public List<Product> findByProductCategoryIsNull(){
        return productService.findByProductCategoryIsNull();
    }
    @GetMapping("/find-by-productcategory-starting-with")
    public List<Product> findByProductCategoryStartingWith(String productCategory){
        return productService.findByProductCategoryStartingWith(productCategory);
    }

}
