package com.invillia.bank_api.domain.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class WithdrawRequest {

    @NotNull(message = "This field cannot be Null!")
    @Min(value = 0, message = "Value cannot be negative")
    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
