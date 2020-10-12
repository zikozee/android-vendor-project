package com.zikozee.androidvendorproject.model.vendor;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("vendors")
public class VendorController {

    private final VendorService vendorService;

    @GetMapping
    public List<VendorDTO> findAllVendors(){
        return vendorService.findAll();
    }
}
