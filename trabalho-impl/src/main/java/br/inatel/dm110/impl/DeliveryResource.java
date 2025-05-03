package br.inatel.dm110.impl;

import java.util.List;
import java.time.LocalDateTime;

import br.inatel.dm110.api.DeliveryInterface;
import br.inatel.dm110.api.DeliveryTO;
import br.inatel.dm110.delivery.entities.AuditLog;
import br.inatel.dm110.interfaces.delivery.DeliveryLocal;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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
        registerAuditLog(String.valueOf(delivery.getOrderCode()), "SaveDelivery");
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<DeliveryTO> listAllDeliveries() {
        List<DeliveryTO> deliveries = deliveryBean.listAllDeliveries();
        registerAuditLog("N/A", "ListAllDeliveries");
        return deliveries;
    }

    private void registerAuditLog(String registerCode, String operation) {
        AuditLog auditLog = new AuditLog();
        auditLog.setRegisterCode(registerCode);
        auditLog.setOperation(operation);
        auditLog.setTimestamp(LocalDateTime.now());
        auditLog.logAuditEntry();
    }
}