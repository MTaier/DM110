# Trabalho DM110

# 🚀 Delivery Management System

## 📌 Sobre o Projeto

O **Delivery Management System** é uma API REST desenvolvida para gerenciar entregas de pedidos. Ele permite registrar,
listar e auditar operações relacionadas às entregas, garantindo rastreabilidade e transparência no sistema.

## 🛠️ Tecnologias Utilizadas

- **Java EE (Jakarta EE)**
- **JPA (Java Persistence API)**
- **EJB (Enterprise Java Beans)**
- **SLF4J (Logging)**
- **RESTful API com Jakarta WS**
- **Banco de Dados Relacional (MySQL/PostgreSQL, etc.)**

## 📂 Estrutura do Projeto

```
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── br.inatel.dm110.delivery.entities
│   │   │   │   ├── Delivery.java
│   │   │   │   ├── AuditLog.java
│   │   │   ├── br.inatel.dm110.impl
│   │   │   │   ├── DeliveryResource.java
│   │   │   ├── br.inatel.dm110.interfaces.delivery
│   │   │   │   ├── DeliveryLocal.java
│   │   │   │   ├── DeliveryRemote.java
│   ├── resources
│   │   ├── META-INF
│   │   │   ├── persistence.xml
```

## 🚚 Entidades do Projeto

### **Delivery (Entregas)**

Classe responsável por armazenar os dados de cada entrega registrada no sistema.

```java

@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderCode;
    private String cpf;
    private LocalDate deliveryDate;
    private String cep;
    private String deliveryStatus;
}
```

### **AuditLog (Registro de Auditoria)**

Classe usada para manter o histórico de operações realizadas no sistema.

```java

@Entity
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registerCode;
    private String operation;
    private LocalDateTime timestamp;

    public void logAuditEntry() {
        logger.info("Audit Log - Register Code: {}, Operation: {}, Timestamp: {}",
                registerCode, operation, timestamp);
    }
}
```

## 🌐 Endpoints

### **1️⃣ Registrar nova entrega**

- **URL:** `/delivery/save`
- **Método:** `POST`
- **Corpo da Requisição (JSON)**:

```json
{
  "orderCode": 12345,
  "cpf": "12345678900",
  "deliveryDate": "2025-05-02",
  "cep": "37540-000",
  "deliveryStatus": "Pendente"
}
```

- **Resposta:** `200 OK`

### **2️⃣ Listar todas as entregas**

- **URL:** `/delivery/list`
- **Método:** `GET`
- **Resposta:** Lista com todas as entregas registradas.

### **3️⃣ Registrar auditoria**

Cada ação realizada no sistema (salvar ou listar entregas) é registrada automaticamente no **AuditLog**, garantindo
rastreabilidade.

## ✅ Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-repositorio/delivery-system.git
   ```
2. Configure o banco de dados no `persistence.xml`.
3. Compile e execute a aplicação:
   ```bash
   mvn clean install
   mvn wildfly:run
   ```
4. Teste os endpoints via **Postman** ou `curl`.
