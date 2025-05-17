package com.example.demo.service;

import com.example.demo.dto.KitDTO;
import com.example.demo.model.Kit;
import com.example.demo.repository.KitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KitService {

    @Autowired
    private KitRepository kitRepository;

    public Kit addKit(KitDTO kitDTO) {
        Kit kit = Kit.builder()
                .kitId(kitDTO.getKitId())
                .kitName(kitDTO.getKitName())
                .build();

        return kitRepository.save(kit);
    }
}
