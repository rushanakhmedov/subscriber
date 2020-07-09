package com.example.subscriber.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subscriber")
public class Subscriber extends BaseEntity {

    @Column(name = "msisdn", nullable = false, unique = true)
    private Long msisdn;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriber")
    private List<Purchase> purchases = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriber")
    private List<Subscription> subscriptions = new ArrayList<>();

    public Subscriber() {
    }

    public Long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(Long msisdn) {
        this.msisdn = msisdn;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
