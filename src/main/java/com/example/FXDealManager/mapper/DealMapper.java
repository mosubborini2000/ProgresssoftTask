package com.example.FXDealManager.mapper;
import com.example.FXDealManager.dto.DealRequest;
import com.example.FXDealManager.dto.DealResponse;
import com.example.FXDealManager.model.Deal;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DealMapper {
    public Deal convertToDealEntity(DealRequest dealRequest) {
        return Deal.builder()
                .dealUniqueId(dealRequest.getDealUniqueId())
                .fromCurrencyIsoCode(dealRequest.getFromCurrencyIsoCode())
                .toCurrencyIsoCode(dealRequest.getToCurrencyIsoCode())
                .dealTimestamp(LocalDate.now())
                .dealAmount(dealRequest.getDealAmount())
                .build();
    }
    public DealResponse convertToDealResponse(Deal deal) {
        return DealResponse.builder()
                .id(deal.getId())
                .dealUniqueId(deal.getDealUniqueId())
                .fromCurrencyIsoCode(deal.getFromCurrencyIsoCode())
                .toCurrencyIsoCode(deal.getToCurrencyIsoCode())
                .dealTimestamp(deal.getDealTimestamp())
                .dealAmount(deal.getDealAmount())
                .build();
    }
}
