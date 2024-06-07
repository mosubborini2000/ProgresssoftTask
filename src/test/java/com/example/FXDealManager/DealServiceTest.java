package com.example.FXDealManager;

import com.example.FXDealManager.dto.DealRequest;
import com.example.FXDealManager.dto.DealResponse;
import com.example.FXDealManager.mapper.DealMapper;
import com.example.FXDealManager.model.Deal;
import com.example.FXDealManager.repository.DealRepository;
import com.example.FXDealManager.service.DealServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DealServiceTest {

    @Mock
    private DealRepository dealRepository;

    @Mock
    private DealMapper dealMapper;

    @InjectMocks
    private DealServiceImp dealService;

    @Test
    public void testSaveDeal_NewDeal_Success() {
        DealRequest request = DealRequest.builder()
                .dealUniqueId("test1")
                .fromCurrencyIsoCode("USD")
                .toCurrencyIsoCode("EUR")
                .dealTimestamp(LocalDate.now())
                .dealAmount(100.0)
                .build();

        Deal deal = Deal.builder()
                .dealUniqueId("test1")
                .fromCurrencyIsoCode("USD")
                .toCurrencyIsoCode("EUR")
                .dealTimestamp(LocalDate.now())
                .dealAmount(100.0)
                .build();

        Deal savedDeal = deal.toBuilder().id(1L).build();
        DealResponse response = DealResponse.builder()
                .id(1L)
                .dealUniqueId("test1")
                .fromCurrencyIsoCode("USD")
                .toCurrencyIsoCode("EUR")
                .dealTimestamp(LocalDate.now())
                .dealAmount(100.0)
                .build();

        when(dealRepository.findByDealUniqueId(request.getDealUniqueId())).thenReturn(Optional.empty());
        when(dealMapper.convertToDealEntity(request)).thenReturn(deal);
        when(dealRepository.save(deal)).thenReturn(savedDeal);
        when(dealMapper.convertToDealResponse(savedDeal)).thenReturn(response);

        DealResponse result = dealService.saveDeal(request);
        assertNotNull(result);
        assertEquals(response, result);

        verify(dealRepository, times(1)).findByDealUniqueId(request.getDealUniqueId());
        verify(dealRepository, times(1)).save(deal);
        verify(dealMapper, times(1)).convertToDealEntity(request);
        verify(dealMapper, times(1)).convertToDealResponse(savedDeal);
    }

    @Test
    public void testSaveDeal_ExistingDeal_Failure() {
        DealRequest request = DealRequest.builder()
                .dealUniqueId("test1")
                .fromCurrencyIsoCode("USD")
                .toCurrencyIsoCode("EUR")
                .dealTimestamp(LocalDate.now())
                .dealAmount(100.0)
                .build();

        Deal existingDeal = Deal.builder()
                .id(1L)
                .dealUniqueId("test1")
                .fromCurrencyIsoCode("USD")
                .toCurrencyIsoCode("EUR")
                .dealTimestamp(LocalDate.now())
                .dealAmount(100.0)
                .build();

        Deal invalidDeal = existingDeal.toBuilder()
                .build();

        DealResponse response = DealResponse.builder()
                .id(1L)
                .dealUniqueId("test1")
                .fromCurrencyIsoCode("USD")
                .toCurrencyIsoCode("EUR")
                .dealTimestamp(LocalDate.now())
                .dealAmount(100.0)
                .build();

        when(dealRepository.findByDealUniqueId(request.getDealUniqueId())).thenReturn(Optional.of(existingDeal));
        when(dealMapper.convertToDealEntity(request)).thenReturn(invalidDeal);
        when(dealRepository.save(invalidDeal)).thenReturn(invalidDeal);
        when(dealMapper.convertToDealResponse(invalidDeal)).thenReturn(response);

        DealResponse result = dealService.saveDeal(request);
        assertNotNull(result);

        assertEquals(response, result);

        verify(dealRepository, times(1)).findByDealUniqueId(request.getDealUniqueId());
        verify(dealRepository, times(1)).save(invalidDeal);
        verify(dealMapper, times(1)).convertToDealEntity(request);
        verify(dealMapper, times(1)).convertToDealResponse(invalidDeal);
    }
}
