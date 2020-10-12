package com.zikozee.androidvendorproject.model.state;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.zikozee.androidvendorproject.model.vendor.Vendor;
import lombok.Data;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "states")
@Data
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String startLocation;

    @Column(name = "dest_state")
    private String destinationState;
    @Column(name = "dest_city")
    private String destinationCity;
    @Column(name = "fare_price")
    private Double farePrice;


    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendorId")
    @JsonBackReference
    private Vendor vendor;
}
