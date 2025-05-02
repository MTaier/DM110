package br.inatel.dm110.impl;

import java.util.List;

import br.inatel.dm110.api.DeliveryInterface;
import br.inatel.dm110.api.DeliveryTO;
import br.inatel.dm110.interfaces.delivery.DeliveryLocal;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@RequestScoped
@Path("/delivery")
public class DeliveryResource implements DeliveryInterface {

    @EJB
    private DeliveryLocal deliveryBean;

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public void saveDelivery(DeliveryTO delivery) {
        deliveryBean.saveDelivery(delivery);
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<DeliveryTO> listAllDeliveries() {
        return deliveryBean.listAllDeliveries();
    }
}
