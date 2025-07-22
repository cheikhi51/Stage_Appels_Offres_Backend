package com.offerTrack.offerTrack.service;

import com.offerTrack.offerTrack.model.Offre;

import java.util.List;

public interface OffreService {
    List<Offre> getAllOffres();
    Offre getOffreById(int id);
    String createOffre(Offre offre);
    String updateOffreById(int id,Offre offre);
    String deleteOffreById(int id);
}
