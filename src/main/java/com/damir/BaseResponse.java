package com.damir;

import com.damir.model.ObjectDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {

    //private final String status;
    private final ObjectDTO status;

    public BaseResponse(ObjectDTO status) {
        this.status = status;
    }

}
