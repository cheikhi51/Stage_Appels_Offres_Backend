package com.offerTrack.offerTrack.service;

import com.offerTrack.offerTrack.model.IndicateursEntreprise;
import com.offerTrack.offerTrack.service.Implmentation.IIndicateursEntrepriseService;

import java.util.List;


public interface IndicateursEntrepriseService{
    List<IndicateursEntreprise> getAllIndicateursEnt();
    IndicateursEntreprise getIndicateursEntById(int id);
    IndicateursEntreprise getIndicateursEntByConId(int id_concurrent);
    String createIndicateursEnt(IndicateursEntreprise indicateursEntreprise);
    String updateIndicateursEntById(int id,IndicateursEntreprise indicateursEntreprise);
    String deleteIndicateursEntById(int id);

}
