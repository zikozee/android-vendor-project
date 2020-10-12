package com.zikozee.androidvendorproject.loader;

import com.zikozee.androidvendorproject.model.state.StateDTO;
import com.zikozee.androidvendorproject.model.state.StateService;
import com.zikozee.androidvendorproject.model.vendor.Vendor;
import com.zikozee.androidvendorproject.model.vendor.VendorDTO;
import com.zikozee.androidvendorproject.model.vendor.VendorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class Loader implements CommandLineRunner {

    private final VendorService vendorService;
    private final StateService stateService;
    private final ModelMapper modelMapper;

    private boolean alreadySetup = false;

    @Transactional
    @Override
    public void run(String... args) {
        if (alreadySetup) {
            return;
        }


        VendorDTO vendorDTO = VendorDTO.builder()
                .name("God is Good")
                .headOfficeContact("24 sakpomba road benin-city Edo state")
                .build();

        VendorDTO createdVendor1 = vendorService.createOne(vendorDTO);

        StateDTO stateDTO1 = StateDTO.builder()
                .name("Lagos")
                .startLocation("Yaba")
                .destinationCity("Benin")
                .destinationState("Edo")
                .farePrice(5000.0)
                .vendor(modelMapper.map(createdVendor1, Vendor.class))
                .build();

        StateDTO stateDTO2 = StateDTO.builder()
                .name("Edo")
                .startLocation("Maiduguri")
                .destinationCity("Maiduguri")
                .destinationState("Borno")
                .farePrice(11000.0)
                .vendor(modelMapper.map(createdVendor1, Vendor.class))
                .build();

        stateService.createOne(stateDTO1);
        stateService.createOne(stateDTO2);

        VendorDTO vendorDTO2 = VendorDTO.builder()
                .name("Ifesinachi Transport Ltd")
                .headOfficeContact("23 Godwills road yaba lagos")
                .build();

        VendorDTO createdVendor2 = vendorService.createOne(vendorDTO2);

        StateDTO stateDTO3 = StateDTO.builder()
                .name("Lagos")
                .startLocation("Ikorodu")
                .destinationCity("Port-Harcourt")
                .destinationState("Rivers")
                .farePrice(9000.0)
                .vendor(modelMapper.map(createdVendor2, Vendor.class))
                .build();

        StateDTO stateDTO4 = StateDTO.builder()
                .name("Edo")
                .startLocation("Shagamu")
                .destinationCity("Shagamu")
                .destinationState("Ogun")
                .farePrice(3500.0)
                .vendor(modelMapper.map(createdVendor2, Vendor.class))
                .build();

        stateService.createOne(stateDTO3);
        stateService.createOne(stateDTO4);



        alreadySetup = true;
    }
}
