package com.offerTrack.offerTrack.service;


import com.offerTrack.offerTrack.model.RapportGenere;

import java.util.List;

public interface RapportGenereService {
    List<RapportGenere> getAllRapport();
    RapportGenere getRapportById(int id);
    String createRapport(RapportGenere rapportGenere);
    String updateRapport(int id,RapportGenere rapportGenere);
    String deleteRapport(int id);
}
