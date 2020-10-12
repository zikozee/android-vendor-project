package com.zikozee.androidvendorproject.model.state;



import com.zikozee.androidvendorproject.model.vendor.Vendor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StateRepo extends CrudRepository<State, Long> {

    List<State> findAllByVendor(Vendor vendor);
}
