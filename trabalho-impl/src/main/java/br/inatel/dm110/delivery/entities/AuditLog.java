package br.inatel.dm110.delivery.entities;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditLog {

    private static final Logger logger = LoggerFactory.getLogger(AuditLog.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registerCode;
    private String operation;
    private LocalDateTime timestamp;

    public void logAuditEntry() {
        logger.info("Audit Log Entry - ID: {}, Register Code: {}, Operation: {}, Timestamp: {}",
                id, registerCode, operation, timestamp);
    }
}