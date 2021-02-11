package net.store.products.service;

import net.store.domain.entity.ProductStatus;
import net.store.domain.entity.Products;
import net.store.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ProductServiceTest {
	
	@Autowired
	private ProductRepository repo;
	
	@Test
	@Rollback(false)
	void testCreateProduct() {
		Products product = new Products("Iphone 10", 789, ProductStatus.OUT_OF_STOCK);
		Products savedProduct = repo.save(product);
		
		assertNotNull(savedProduct);
	}

	@Test
	void testFindProductByName(){
		String name = "Iphone 10";

		Products product = repo.findByName(name);
		assertThat(product.getName()).isEqualTo(name);
	}

	@Test
	void testFindProductByNameNotExists(){
		String name = "Iphone 11";

		Products product = repo.findByName(name);
		Assertions.assertNull(product);
	}

}
