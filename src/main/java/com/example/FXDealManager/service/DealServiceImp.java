package com.example.FXDealManager.service;

import com.example.FXDealManager.dto.DealRequest;
import com.example.FXDealManager.dto.DealResponse;
import com.example.FXDealManager.mapper.DealMapper;
import com.example.FXDealManager.model.Deal;
import com.example.FXDealManager.repository.DealRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.slf4j.Logger;
@Service
public class DealServiceImp implements DealService{
    private final DealRepository dealRepository;
    private final DealMapper dealMapper;
    private static final Logger logger = LoggerFactory.getLogger(DealServiceImp.class);


    public DealServiceImp(DealRepository dealRepository, DealMapper dealMapper) {
        this.dealRepository = dealRepository;
        this.dealMapper = dealMapper;
    }

    @Override
    public DealResponse saveDeal(DealRequest dealRequest) {
        logger.info("Saving deal: {}", dealRequest);

        Deal deal = dealMapper.convertToDealEntity(dealRequest);
        Optional<Deal> existingDeal = dealRepository.findByDealUniqueId(dealRequest.getDealUniqueId());


        Deal savedDeal = dealRepository.save(deal);
        logger.info("Deal saved successfully: {}", savedDeal);

        return dealMapper.convertToDealResponse(savedDeal);
    }
}
