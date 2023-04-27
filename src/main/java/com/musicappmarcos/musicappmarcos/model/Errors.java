package com.musicappmarcos.musicappmarcos.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Errors {
    @NonNull
    private String message;


}
