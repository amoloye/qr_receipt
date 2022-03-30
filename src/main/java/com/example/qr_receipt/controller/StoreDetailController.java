package com.example.qr_receipt.controller;


import com.example.qr_receipt.entity.StoreDetail;
import com.example.qr_receipt.service.StoreDetailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
public class StoreDetailController {

    private StoreDetailService storeDetailService;

    @PostMapping("/store")
    public StoreDetail createStoreDetail(@Valid @RequestBody StoreDetail storeDetail){
        return storeDetailService.saveStoreDetail(storeDetail);

    }

    @GetMapping("/store/{id}")
    public StoreDetail fetchStoreDetailById(@PathVariable ("id") Long storeId) throws Exception {
        return storeDetailService.fetchStoreDetailById(storeId);
    }

    @PutMapping("/store/{id}")
    public StoreDetail updateStoreDetail(@Valid  @PathVariable("id") Long storeId,
                                         @RequestBody StoreDetail storeDetail){
        return  storeDetailService.updateStoreDetail(storeId,storeDetail);

    }

    @DeleteMapping("/store/{id}")
    public String deleteStoreDetailById(@PathVariable ("id") Long storeId ){
        storeDetailService.deleteStoreDetailById(storeId);
        return "Deleted Successfully";
    }
}
