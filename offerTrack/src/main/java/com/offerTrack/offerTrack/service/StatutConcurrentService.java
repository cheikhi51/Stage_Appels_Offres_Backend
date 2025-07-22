package com.offerTrack.offerTrack.service;

import com.offerTrack.offerTrack.model.StatutConcurrent;

import java.util.List;

public interface StatutConcurrentService {
    List<StatutConcurrent> getAllStatutConcurrent();
    StatutConcurrent getStatutConcurrentById(int id);
    String createStatutConcurrent(StatutConcurrent statutConcurrent);
    String updateStatutConcurrentById(int id, StatutConcurrent statutConcurrent);
    String deleteStatutConcurrent(int id);
}
