package com.example.SpringDemo.repository;

import com.example.SpringDemo.entity.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findByProductName(String productName);
    Optional<Product> findByProductNameIgnoreCase(String productName);
    List<Product> findAllByProductNameLike(String productName);
    List<Product> findAllByProductNameContainingIgnoreCase(String productName);
    List<Product> findAllByProductPriceBetween(Double start, Integer end);
    List<Product> findAllByProductPriceGreaterThan(Double productPrice);
    List<Product> findAllByProductUnitlnStockGreaterThan(Integer productUnitlnStock);
    List<Product> findByProductPriceGreaterThanEqual(Double productPrice);
    Long countByProductCategory(String productCategory);
    Long countByProductName(String productName);
    boolean existsByProductCategory(String productCategory);
    List<Product> findByProductCategoryIsNull();
    List<Product> findByProductCategoryStartingWith(String productCategory);
}
