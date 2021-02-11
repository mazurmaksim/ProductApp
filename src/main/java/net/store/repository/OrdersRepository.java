package net.store.repository;

import org.springframework.data.repository.CrudRepository;

import net.store.domain.entity.Orders;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long>{

}
