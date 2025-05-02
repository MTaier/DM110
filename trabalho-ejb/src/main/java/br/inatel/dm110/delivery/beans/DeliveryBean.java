package br.inatel.dm110.delivery.beans;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.logging.Logger;

import br.inatel.dm110.api.DeliveryTO;
import br.inatel.dm110.delivery.entities.Delivery;
import br.inatel.dm110.delivery.support.DeliveryConverter;
import br.inatel.dm110.interfaces.delivery.DeliveryLocal;

;

@Stateless
@Local(DeliveryLocal.class)
public class DeliveryBean implements DeliveryLocal {

    private static final Logger log = Logger.getLogger(DeliveryBean.class.getName());

    @PersistenceContext(unitName = "trabalho_dm110_pu")
    private EntityManager em;

    @Override
    public void saveDelivery(DeliveryTO deliveryTO) {
        Delivery entity = DeliveryConverter.toEntity(deliveryTO);
        em.persist(entity);
    }

    @Override
    public List<DeliveryTO> listAllDeliveries() {
        log.info("Listing all deliveries from the database.");

        String hql = "SELECT s FROM Delivery s";
        TypedQuery<Delivery> query = em.createQuery(hql, Delivery.class);
        List<Delivery> deliveyList = query.getResultList();
        return DeliveryConverter.toTOList(deliveyList);
    }

}
