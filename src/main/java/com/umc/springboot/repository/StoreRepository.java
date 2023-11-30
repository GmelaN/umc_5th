package com.umc.springboot.repository;

import com.umc.springboot.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    
}
