package com.ivispl.candidate.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UserDto {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private boolean isEnabled;

}
