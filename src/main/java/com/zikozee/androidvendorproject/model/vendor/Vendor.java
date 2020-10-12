package com.zikozee.androidvendorproject.model.vendor;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zikozee.androidvendorproject.model.state.State;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vendors")
@Data
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "head_office")
    private String headOfficeContact;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "vendor", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<State> state;
}
