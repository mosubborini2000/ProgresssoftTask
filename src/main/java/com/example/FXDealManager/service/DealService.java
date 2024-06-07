package com.example.FXDealManager.service;

import com.example.FXDealManager.dto.DealRequest;
import com.example.FXDealManager.dto.DealResponse;

public interface DealService {
    DealResponse saveDeal(DealRequest dealRequest);

}
