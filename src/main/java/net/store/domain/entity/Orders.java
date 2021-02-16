package net.store.domain.entity;

import javax.persistence.*;

import lombok.*;
import net.store.converter.impl.DateConverterImpl;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Builder
@Table(name = "orders")
public class Orders {

    private static final AtomicInteger counter = new AtomicInteger();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Integer userId = UserId.nextValue();

    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<OrderItem> orderItem = new ArrayList<>();

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Column(name = "created_at")
    @CreationTimestamp
    @Convert(converter = DateConverterImpl.class)
    private Date createdAt;

    public Orders(final ProductStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Orders{" +
               "id=" +
               id +
               ", userId=" +
               userId +
               ", status=" +
               status +
               ", createdAt=" +
               createdAt +
               '}';
    }
}
