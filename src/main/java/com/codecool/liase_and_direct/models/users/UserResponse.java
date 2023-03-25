package com.codecool.liase_and_direct.models.users;

import com.codecool.liase_and_direct.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
}
