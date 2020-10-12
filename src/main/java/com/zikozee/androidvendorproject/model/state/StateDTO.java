package com.zikozee.androidvendorproject.model.state;

import com.zikozee.androidvendorproject.model.vendor.Vendor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StateDTO {

    private long id;
    private String name;
    private String startLocation;
    private String destinationState;
    private String destinationCity;
    private Double farePrice;
    private Vendor vendor;

}
