package com.example.subscriber.repository;

import com.example.subscriber.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

    public Subscriber findByMsisdn(long msisdn);

}
