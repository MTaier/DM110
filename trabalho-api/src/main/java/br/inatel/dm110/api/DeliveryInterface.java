package br.inatel.dm110.api;

import java.util.List;

public interface DeliveryInterface {

    public void saveDelivery(DeliveryTO delivery);

    public List<DeliveryTO> listAllDeliveries();
}