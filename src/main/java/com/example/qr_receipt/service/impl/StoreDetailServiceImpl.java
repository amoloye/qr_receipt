package com.example.qr_receipt.service.impl;

import com.example.qr_receipt.entity.StoreDetail;
import com.example.qr_receipt.repository.StoreDetailRepository;
import com.example.qr_receipt.service.StoreDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StoreDetailServiceImpl implements StoreDetailService {
    private static final String storeDetailNotFoundException= "store details is not found";


    private StoreDetailRepository storeDetailRepository;

    @Override
    public StoreDetail saveStoreDetail (StoreDetail storeDetail) {
        return storeDetailRepository.save(storeDetail);
    }

    @Override
    public StoreDetail fetchStoreDetailById (Long storeId) throws Exception {
        Optional<StoreDetail> storeDetail=storeDetailRepository.findById(storeId);
        if(storeDetail.isEmpty()){
            throw new Exception(storeDetailNotFoundException);
        }
        return  storeDetail.get();
    }

    @Override
    public void deleteStoreDetailById (Long storeId) {
         storeDetailRepository.deleteByStoreDetailId(storeId);


    }

    @Override
    public StoreDetail updateStoreDetail (Long storeId, StoreDetail storeDetail) {
        StoreDetail stDB = storeDetailRepository.findById(storeId).get();

        if (Objects.nonNull(storeDetail.getBusinessName())&&
                !"".equalsIgnoreCase(storeDetail.getBusinessName())){
            stDB.setBusinessName(storeDetail.getBusinessName());
        }
        if (Objects.nonNull(storeDetail.getStoreAddress())&&
                !"".equalsIgnoreCase(storeDetail.getStoreAddress())){
            stDB.setBusinessName(storeDetail.getStoreAddress());
        }

        if (Objects.nonNull(storeDetail.getCity())&&
                !"".equalsIgnoreCase(storeDetail.getCity())){
            stDB.setBusinessName(storeDetail.getCity());
        }

        if (Objects.nonNull(storeDetail.getState())&&
                !"".equalsIgnoreCase(storeDetail.getState())){
            stDB.setBusinessName(storeDetail.getState());
        }

        if (Objects.nonNull(storeDetail.getPhoneNumber())&&
                !"".equalsIgnoreCase(storeDetail.getPhoneNumber())){
            stDB.setBusinessName(storeDetail.getPhoneNumber());
        }

        return storeDetailRepository.save(stDB);

    }
}
