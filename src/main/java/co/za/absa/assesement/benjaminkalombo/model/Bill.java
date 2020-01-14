package co.za.absa.assesement.benjaminkalombo.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionreference;
    private String clientswiftaddress;
    private String messagestatus;
    private String Currency;
    private float amount;
    @CreationTimestamp
    private LocalDateTime datetimecreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionreference() {
        return transactionreference;
    }

    public void setTransactionreference(String transactionreference) {
        this.transactionreference = transactionreference;
    }

    public String getClientswiftaddress() {
        return clientswiftaddress;
    }

    public void setClientswiftaddress(String clientswiftaddress) {
        this.clientswiftaddress = clientswiftaddress;
    }

    public String getMessagestatus() {
        return messagestatus;
    }

    public void setMessagestatus(String messagestatus) {
        this.messagestatus = messagestatus;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDateTime getDatetimecreated() {
        return datetimecreated;
    }

    public void setDatetimecreated(LocalDateTime datetimecreated) {
        this.datetimecreated = datetimecreated;
    }
}
