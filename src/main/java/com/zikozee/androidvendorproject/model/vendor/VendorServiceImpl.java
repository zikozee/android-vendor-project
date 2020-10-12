package com.zikozee.androidvendorproject.model.vendor;


import com.zikozee.androidvendorproject.model.state.State;
import com.zikozee.androidvendorproject.model.state.StateDTO;
import com.zikozee.androidvendorproject.model.state.StateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {
    private final StateService stateService;
    private final VendorRepo vendorRepo;
    private final ModelMapper modelMapper;

    @Override
    public VendorDTO createOne(VendorDTO vendorDTO) {
        Vendor vendor = modelMapper.map(vendorDTO, Vendor.class);
        return modelMapper.map(vendorRepo.save(vendor), VendorDTO.class);
    }

    @Override
    public VendorDTO findById(Long id) {
        return modelMapper.map(vendorRepo.findById(id), VendorDTO.class);
    }

    @Override
    public VendorDTO findByName(String name) {

        Vendor vendor = vendorRepo.findByName(name);
        List<StateDTO> stateDTOS = stateService.findByVendor(vendor);

        Set<State> states = stateDTOS
                .stream()
                .map(stateDTO -> modelMapper.map(stateDTO, State.class))
                .collect(Collectors.toSet());

        vendor.setState(states);


        return modelMapper.map(vendor, VendorDTO.class);
    }

    @Override
    public List<VendorDTO> findAll() {
        List<String> vendorNames = new ArrayList<>();
        vendorRepo.findAll().forEach(vendor ->  vendorNames.add(vendor.getName()));

        return vendorNames
                .stream()
                .map(this::findByName)
                .collect(Collectors.toList());
    }


}
