package com.logitrack.domain.model.enums;

public enum DeliveryStatus {
    PENDING,         // aguardando início da entrega
    PICKED_UP,       // retirada feita pelo motorista
    IN_TRANSIT,      // em trânsito
    DELAYED,         // atrasada
    DELIVERED,       // entregue com sucesso
    CANCELED         // cancelada
}
