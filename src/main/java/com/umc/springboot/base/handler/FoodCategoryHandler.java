package com.umc.springboot.base.handler;

import com.umc.springboot.api.code.BaseErrorCode;
import com.umc.springboot.base.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode code) {
        super(code);
    }
}
