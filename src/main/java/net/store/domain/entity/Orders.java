package net.store.domain.entity;

import javax.persistence.*;

import lombok.*;
import net.store.converter.impl.DateConverterImpl;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Builder
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<OrderItem> orderItem = new ArrayList<>();

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Column(name = "created_at")
    @CreationTimestamp
    @Convert(converter = DateConverterImpl.class)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createdAt;

    public Orders(final ProductStatus status) {
//        this.userId = userId;
        //        this.orderItem = orderItem;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Orders{" +
               "id=" +
               id +
               ", userId='" +
               userId +
               '\'' +
               ", orderItem=" +
               orderItem +
               ", status=" +
               status +
               ", createdAt='" +
               createdAt +
               '\'' +
               '}';
    }
}
