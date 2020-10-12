package com.zikozee.androidvendorproject.model.vendor;


import org.springframework.data.repository.CrudRepository;

public interface VendorRepo extends CrudRepository<Vendor, Long> {

    Vendor findByName(String name);
}
