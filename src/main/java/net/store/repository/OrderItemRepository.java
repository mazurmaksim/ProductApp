package net.store.repository;

import org.springframework.data.repository.CrudRepository;

import net.store.domain.entity.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long>{

}
