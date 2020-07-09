package com.example.subscriber.repository;

import com.example.subscriber.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

    public Optional<Subscriber> findByMsisdn(long msisdn);

}
