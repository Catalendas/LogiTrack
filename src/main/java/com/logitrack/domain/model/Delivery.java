package com.logitrack.domain.model;

import com.logitrack.domain.model.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Delivery {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String decription;

    @Column(nullable = false)
    private DeliveryStatus status = DeliveryStatus.PENDING;

    @CreationTimestamp
    private LocalDateTime date;

    @ManyToOne
    private Usuario client;

    @ManyToOne
    private Usuario driver;

    @ManyToOne
    private Address origin;

    @ManyToOne
    private Address destination;

    @OneToMany
    private List<DeliveryUpdate> deliveryUpdates;

}
