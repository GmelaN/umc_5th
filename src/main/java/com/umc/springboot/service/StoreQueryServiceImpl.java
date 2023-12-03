package com.umc.springboot.service;

import com.umc.springboot.api.code.status.ErrorStatus;
import com.umc.springboot.base.handler.StoreHandler;
import com.umc.springboot.domain.Mission;
import com.umc.springboot.domain.Review;
import com.umc.springboot.domain.Store;
import com.umc.springboot.repository.MissionRepository;
import com.umc.springboot.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StoreQueryServiceImpl implements StoreQueryService {
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<Review> getReview(Long storeId, Integer page) {
        Store targetStore = this
                .findStore(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND))
                ;

        Page<Review> storePage = reviewRepository
                .findAllByStore(
                        targetStore,
                        PageRequest.of(page, 10)
                );

        return storePage;
    }

    @Override
    public Page<Mission> getMission(Long storeId, Integer page) {
        Store targetStore = this
                .findStore(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND))
                ;

        Page<Mission> storePage = missionRepository
                .findAllByStore(
                        targetStore,
                        PageRequest.of(page, 10)
                );

        return storePage;

    }
}
