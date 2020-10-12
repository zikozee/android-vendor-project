package com.zikozee.androidvendorproject.model.state;


import com.zikozee.androidvendorproject.model.vendor.Vendor;

import java.util.List;

public interface StateService {

    StateDTO createOne(StateDTO stateDTO);
    StateDTO findById(Long id);
    List<StateDTO> findAll();

    List<StateDTO> findByVendor(Vendor vendor);

}
