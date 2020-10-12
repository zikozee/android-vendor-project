package com.zikozee.androidvendorproject.model.vendor;

import com.zikozee.androidvendorproject.model.state.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendorDTO {

    private Long id;
    private String name;
    private String headOfficeContact;

    private Set<State> state;
}
