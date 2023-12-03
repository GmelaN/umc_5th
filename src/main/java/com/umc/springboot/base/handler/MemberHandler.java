package com.umc.springboot.base.handler;

import com.umc.springboot.api.code.BaseErrorCode;
import com.umc.springboot.base.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode code) {
        super(code);
    }
}
