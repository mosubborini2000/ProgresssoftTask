package com.example.FXDealManager.controller;
import com.example.FXDealManager.dto.DealRequest;
import com.example.FXDealManager.dto.DealResponse;
import com.example.FXDealManager.service.DealService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/deals")
public class DealController {
    private final DealService dealService;


    public DealController(DealService dealService) {
        this.dealService = dealService;
    }
    @PostMapping("/save")
    public DealResponse saveDeal(@RequestBody @Valid DealRequest dealRequest){
        return dealService.saveDeal(dealRequest);
    }
}