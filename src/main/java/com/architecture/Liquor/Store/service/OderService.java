package com.architecture.Liquor.Store.service;

import com.architecture.Liquor.Store.dto.CartItemDto;
import com.architecture.Liquor.Store.dto.OderDto;
import com.architecture.Liquor.Store.entity.CartItem;
import com.architecture.Liquor.Store.entity.Oder;
import com.architecture.Liquor.Store.repository.CartItemRepository;
import com.architecture.Liquor.Store.repository.OderRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class OderService {

        @Autowired
        private OderRepository oderRepository;
        @Autowired
        private ModelMapper modelMapper;
        public OderDto saveOder(OderDto oderDto) {
            oderRepository.save(modelMapper.map(oderDto,Oder.class));

            return oderDto;

        }


    }

