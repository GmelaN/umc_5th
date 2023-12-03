package com.umc.springboot.service;

import com.umc.springboot.domain.Mission;
import com.umc.springboot.domain.Review;
import com.umc.springboot.domain.Store;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);

    Page<Review> getReview(Long storeId, Integer page);
    Page<Mission> getMission(Long storeId, Integer page);
}
