package net.store.domain.entity;


import javax.persistence.*;

import lombok.*;
import net.store.converter.impl.ProductStatusConverterImpl;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Data
@EnableJpaAuditing
@Table(name = "products")
public class Products {

    public Products(final String name, final Integer price, final ProductStatus status) {
        this.name = name;
        this.price = price;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "products", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<OrderItem> orderItem = new ArrayList<>();

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "status")
    @Convert(converter = ProductStatusConverterImpl.class)
    private ProductStatus status;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;
}
