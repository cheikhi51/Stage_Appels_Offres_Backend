package com.offerTrack.offerTrack.service;

import com.offerTrack.offerTrack.model.IndicateursMaitreOuvrage;

import java.util.List;

public interface IndicateursMaitreOuvrageService {
    List<IndicateursMaitreOuvrage> getAllIndicateursMO();
    IndicateursMaitreOuvrage getIdicateursMOById(int id);
    String createIndicateursMO(IndicateursMaitreOuvrage indicateursMO);
    String updateIndicateursMO(int id, IndicateursMaitreOuvrage indicateursMO);
    String deleteIndicateursMO(int id);
}
