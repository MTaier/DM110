package br.inatel.dm110.delivery.support;

import java.util.List;
import java.util.stream.Collectors;

import br.inatel.dm110.api.DeliveryTO;
import br.inatel.dm110.delivery.entities.Delivery;

public class DeliveryConverter {
    public static DeliveryTO toDeliveryTO(Delivery delivery) {
        return new DeliveryTO(
                delivery.getOrderCode(),
                delivery.getCpf(),
                delivery.getDeliveryDate(),
                delivery.getCep(),
                delivery.getDeliveryStatus());
    }

    public static Delivery toEntity(DeliveryTO to) {
        return new Delivery(
                to.getOrderCode(),
                to.getCpf(),
                to.getDeliveryDate(),
                to.getCep(),
                to.getDeliveryStatus());
    }

    public static List<DeliveryTO> toTOList(List<Delivery> deliveryList) {
        return deliveryList.stream()
                .map(DeliveryConverter::toDeliveryTO)
                .collect(Collectors.toList());
    }
}
