package com.umc.springboot.base.handler;

import com.umc.springboot.api.code.BaseErrorCode;
import com.umc.springboot.base.exception.GeneralException;

public class StoreHandler extends GeneralException {

    public StoreHandler(BaseErrorCode code) {
        super(code);
    }
}
