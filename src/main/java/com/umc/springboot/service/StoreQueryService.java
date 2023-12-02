package com.umc.springboot.service;

import com.umc.springboot.web.dto.StoreResponseDTO;

public interface StoreQueryService {
    StoreResponseDTO.StoreDTO findStoreById(Long storeId);
}
