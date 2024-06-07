package com.example.FXDealManager.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealRequest {

    @NotBlank(message = "Deal Unique Id is required")
    private String dealUniqueId;

    @NotBlank(message = "From Currency ISO Code is required")
    private String fromCurrencyIsoCode;

    @NotBlank(message = "To Currency ISO Code is required")
    private String toCurrencyIsoCode;

    private LocalDate dealTimestamp;

    @NotNull(message = "Deal Amount is required")
    @Positive(message = "Deal Amount must be greater than 0")
    private Double dealAmount;
}
