package com.example.SpringDemo.service;

import com.example.SpringDemo.entity.Product;
import com.example.SpringDemo.repository.ProductRepository;
import com.example.SpringDemo.utility.IService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProductService implements IService<Product, Long> {
    private final ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(Product.builder()
                        .productName(product.getProductName())
                        .productCategory(product.getProductCategory())
                        .productPrice(product.getProductPrice())
                        .productUnitlnStock(product.getProductUnitlnStock())
                        .productDescription(product.getProductDescription())
                .build());
    }

    @Override
    public Product update(Product product) {
        Optional<Product> product1=productRepository.findById(product.getId());
        if (product1.isEmpty()){
            //exception fırlatıyoruz
        }
        return productRepository.save(product);
    }

    @Override
    public Iterable<Product> saveAll(Iterable<Product> t) {
        return null;
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void deleteById(Long aLong) {
        productRepository.deleteById(aLong);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    public Optional<Product> findByProductNameIgnoreCase(String productName){
        return productRepository.findByProductNameIgnoreCase(productName);
    }
    public Optional<Product> FindByProductname(String productName){
        if (productName.equalsIgnoreCase(productRepository.findByProductName(productName).get().getProductName())){
            return productRepository.findByProductName(productName);
        }
        return null;
    }
    public List<Product> FindAllByProductnameLike(String productName){
        return productRepository.findAllByProductNameLike(productName);
    }
    public List<Product> FindAllByProductPriceBetween(Double start, Integer end){
        return productRepository.findAllByProductPriceBetween(start,end);
    }
    public List<Product> findAllByProductNameContainingIgnoreCase(String productName){
        return productRepository.findAllByProductNameContainingIgnoreCase(productName);
    }
    public List<Product> findAllByProductPriceGreaterThan(Double productPrice){
        return productRepository.findAllByProductPriceGreaterThan(productPrice);
    }
    public List<Product> findAllByProductUnitlnStockGreaterThan(Integer productUnitlnStock){
        return productRepository.findAllByProductUnitlnStockGreaterThan(productUnitlnStock);
    }
    public List<Product> findByProductPriceGreaterThanEqual(Double productPrice){
        return productRepository.findByProductPriceGreaterThanEqual(productPrice);
    }
    public Long countByProductCategory(String productCategory){
        return productRepository.countByProductCategory(productCategory);
    }
    public Long countByProductName(String productName){
        return productRepository.countByProductName(productName);
    }
    public boolean existsByProductCategory(String productCategory){
        return productRepository.existsByProductCategory(productCategory);
    }
    public List<Product> findByProductCategoryIsNull(){
        return productRepository.findByProductCategoryIsNull();
    }
    public List<Product> findByProductCategoryStartingWith(String productCategory){
        return productRepository.findByProductCategoryStartingWith(productCategory);
    }





}
