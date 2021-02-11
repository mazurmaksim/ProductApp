package net.store.repository;

import org.springframework.data.repository.CrudRepository;

import net.store.domain.entity.Products;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Products, Integer>{
	Products findByName(String name);
}
