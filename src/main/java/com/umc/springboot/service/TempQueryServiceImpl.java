package com.umc.springboot.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.umc.springboot.api.code.status.ErrorStatus;
import com.umc.springboot.base.handler.TempHandler;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Primary
public class TempQueryServiceImpl implements TempQueryService {
    @Override
    public void checkFlag(Integer flag) {
        if(flag == 1) throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
