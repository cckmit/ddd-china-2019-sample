package com.victory.ddd.china.sample.adapters.rest.resource.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    private String bio;
    private String image;
}
