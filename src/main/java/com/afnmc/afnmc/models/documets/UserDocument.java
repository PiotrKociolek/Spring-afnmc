package com.afnmc.afnmc.models.documets;

import com.afnmc.afnmc.models.flags.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class UserDocument {
    @Id
    private String id;
    private String password;
    private String name;
    private String surname;
    private String email;
    private PermissionType permissionType;
}
