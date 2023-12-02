package com.umc.springboot.base.handler;

import com.umc.springboot.api.code.BaseErrorCode;
import com.umc.springboot.base.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode code) {
        super(code);
    }
}
