package com.umc.springboot.base.handler;

import com.umc.springboot.api.code.BaseErrorCode;
import com.umc.springboot.base.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
