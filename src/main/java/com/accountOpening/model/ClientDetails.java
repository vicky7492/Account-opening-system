package com.accountOpening.model;

import javax.persistence.*;

@Entity
public class ClientDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long clientId;
    String clientName;
    String clientMobile;
    String clientAge;
    String pan;

    public ClientDetails() {
        super();
    }

    public ClientDetails(Long clientId, String clientName, String clientMobile, String clientAge, String pan) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientMobile = clientMobile;
        this.clientAge = clientAge;
        this.pan = pan;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientMobile() {
        return clientMobile;
    }

    public void setClientMobile(String clientMobile) {
        this.clientMobile = clientMobile;
    }

    public String getClientAge() {
        return clientAge;
    }

    public void setClientAge(String clientAge) {
        this.clientAge = clientAge;
    }

    public String getPAN() {
        return pan;
    }

    public void setPAN(String pan) {
        this.pan = pan;
    }
}
