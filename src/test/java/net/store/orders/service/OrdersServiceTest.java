package net.store.orders.service;

import net.store.domain.entity.Orders;
import net.store.domain.entity.ProductStatus;
import net.store.domain.entity.Products;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import net.store.repository.OrdersRepository;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class OrdersServiceTest {
	
	@Autowired
	private OrdersRepository repo;
	
	@Test
	@Rollback(false)
	public void testCreateOrder() {
		Orders orders = new Orders(ProductStatus.IN_STOCK);
		Orders saveOrder = repo.save(orders);

		assertNotNull(saveOrder);
	}
}
