package com.example.FXDealManager.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "mst_deals")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deal_unique_id", nullable = false, unique = true)
    private String dealUniqueId;

    @Column(name = "from_currency_iso_code", nullable = false)
    private String fromCurrencyIsoCode;

    @Column(name = "to_currency_iso_code", nullable = false)
    private String toCurrencyIsoCode;

    @Column(name = "deal_timestamp", nullable = false)
    private LocalDate dealTimestamp;

    @Column(name = "deal_amount", nullable = false)
    private Double dealAmount;

}
