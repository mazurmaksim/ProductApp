package net.store.loader;

import lombok.*;
import net.store.repository.OrdersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Component
public class ProductRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(ProductRunner.class);

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public void run(final String... args) throws Exception {
        ordersRepository.findAll().forEach((userId) -> {
//            logger.info("{}", userId);
            System.out.println(userId);
        });
    }
}
