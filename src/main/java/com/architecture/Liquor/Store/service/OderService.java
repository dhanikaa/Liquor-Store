package com.architecture.Liquor.Store.service;

import com.architecture.Liquor.Store.dto.OderDto;
import com.architecture.Liquor.Store.entity.Oder;
import com.architecture.Liquor.Store.repository.OderRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class OderService {

    @Autowired
    private OderRepository oderRepository;
    @Autowired
    private ModelMapper modelMapper;

    public OderDto saveOder(OderDto oderDto) {
        oderRepository.save(modelMapper.map(oderDto, Oder.class));

        return oderDto;

    }

    public List<OderDto>getAllOders() {

          List<Oder>oderList= oderRepository.findAll();
          return modelMapper.map(oderList,new TypeToken<List<OderDto>>(){}.getType());
    }

    public OderDto updateOders(OderDto oderDto) {
        oderRepository.save(modelMapper.map(oderDto, Oder.class));
        return oderDto;

    }

    public boolean deleteOders(OderDto oderDto) {
        oderRepository.delete(modelMapper.map(oderDto, Oder.class));
        return true;

    }

}

