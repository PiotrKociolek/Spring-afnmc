package com.afnmc.afnmc.models.dtos.request;

import com.afnmc.afnmc.models.flags.PermissionType;
import com.afnmc.afnmc.utilities.validation.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    @Id
    private String id;
    @NotBlank
    @NotNull
    @ValidPassword
    private String password;
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String surname;
    @NotBlank
    @NotNull
    @Email
    private String email;
    @NotNull
    private PermissionType permissionType;
}
