package com.sensedia.mapstructdemo.infrastructure.h2_database.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerH2Repository extends JpaRepository<CustomerModel, String>{
    
}
