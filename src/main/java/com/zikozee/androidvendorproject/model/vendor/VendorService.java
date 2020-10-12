package com.zikozee.androidvendorproject.model.vendor;

import java.util.List;

public interface VendorService {

    VendorDTO createOne(VendorDTO vendorDTO);
    VendorDTO findById(Long id);
    VendorDTO findByName(String name);
    List<VendorDTO> findAll();
}
