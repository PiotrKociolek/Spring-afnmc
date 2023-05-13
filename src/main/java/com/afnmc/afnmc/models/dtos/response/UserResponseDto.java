package com.afnmc.afnmc.models.dtos.response;

import com.afnmc.afnmc.models.flags.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String id;
    private String password;
    private String name;
    private String surname;
    private String email;
    private PermissionType permissionType;
}
