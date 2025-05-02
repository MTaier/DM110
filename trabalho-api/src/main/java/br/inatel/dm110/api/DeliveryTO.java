package br.inatel.dm110.api;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryTO implements Serializable {
    private Long orderCode;
    private String cpf;
    private LocalDate deliveryDate;
    private String cep;
    private String deliveryStatus;
}
