package com.example.VirtualBookStore.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String username;
    private String email;

//    public UserDTO(Long id, String username, String email) {
//         this.id=id;
//         this.username=username;
//         this.email = email;
//    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
