package com.offerTrack.offerTrack.service;

import com.offerTrack.offerTrack.model.MontantConcurrent;

import java.util.List;

public interface MontantConcurrentService {
    List<MontantConcurrent> getAllMontantConcurrent();
    MontantConcurrent getMontantConcurrentById(int id);
    String createMontantConcurrent(MontantConcurrent montantConcurrent);
    String updateMontantConcurrentById(int id,MontantConcurrent montantConcurrent);
    String deleteMontantConcurrentById(int id);
}
