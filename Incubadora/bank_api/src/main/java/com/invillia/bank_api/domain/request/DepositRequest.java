package com.invillia.bank_api.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositRequest {

    @NotNull(message = "This field cannot be Null!")
    @Min(value = 0, message = "Value cannot be negative")
    private Double value;

    public Double getValue() {
        return value;
    }

}
