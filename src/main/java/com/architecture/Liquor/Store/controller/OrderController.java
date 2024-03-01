package com.architecture.Liquor.Store.controller;


import com.architecture.Liquor.Store.dto.OderDto;
import com.architecture.Liquor.Store.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/oder")
@CrossOrigin
public class OrderController  {

        @Autowired
        private OderService oderService;
        @PostMapping("/saveOder")
        public OderDto saveOder(@RequestBody OderDto oderDto) {

            return oderService.saveOder(oderDto);


        }


        @GetMapping("/getOder")
        public List<OderDto> getOder() {
                return oderService.getAllOders();
        }


        @PutMapping("/updateOder")
        public String updateOders(@RequestBody OderDto oderDto){
                oderService.updateOders(oderDto);
                return "Oder Updated";
        }

        @DeleteMapping("/deleteOder")
        public String deleteOders(@RequestBody OderDto oderDto){
                oderService.deleteOders(oderDto);
                return "delete succesfully";
        }







}





