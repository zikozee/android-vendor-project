package com.zikozee.androidvendorproject.model.state;

import com.zikozee.androidvendorproject.model.vendor.Vendor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {
    private final StateRepo stateRepo;
    private final ModelMapper modelMapper;


    @Override
    public StateDTO createOne(StateDTO stateDTO) {
        State state = modelMapper.map(stateDTO, State.class);
        return modelMapper.map(stateRepo.save(state), StateDTO.class);
    }

    @Override
    public StateDTO findById(Long id) {
        return null;
    }

    @Override
    public List<StateDTO> findAll() {
        return null;
    }

    @Override
    public List<StateDTO> findByVendor(Vendor vendor) {
        List<State> states = stateRepo.findAllByVendor(vendor);

        return states.stream()
                .map(state -> modelMapper.map(state, StateDTO.class))
                .collect(Collectors.toList());
    }

}
