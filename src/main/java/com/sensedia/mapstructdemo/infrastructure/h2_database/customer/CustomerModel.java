package com.sensedia.mapstructdemo.infrastructure.h2_database.customer;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_CUSTOMER")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerModel {
    
    @Id
    private String id;

    @Column(name = "NAME")
    @Nonnull
    private String name;

    @Column(name = "STREET")
    @Nonnull
    private String street;

    @Column(name = "NUMBER")
    @Nonnull
    private Integer number;

    @Column(name = "ZIP_CODE")
    @Nonnull
    private Integer zipCode;

    @Column(name = "CITY")
    @Nonnull
    private String city;

    @Column(name = "ACTIVE")
    @Nonnull
    private Boolean active;
}
