package com.example.SpringDemo.utility;

import com.example.SpringDemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IService<T,ID> {
     List<T> findAll();
     T save(T t);
     T update(T t);
     Iterable<T> saveAll(Iterable<T> t);
     void delete(T t);
     void deleteById(ID id);
     Optional<T> findById(ID id);
}
