package br.inatel.dm110.interfaces.delivery;

import java.util.List;

import br.inatel.dm110.api.DeliveryTO;

public interface DeliveryLocal {

    public void saveDelivery(DeliveryTO deliveryTO);

    public List<DeliveryTO> listAllDeliveries();
}