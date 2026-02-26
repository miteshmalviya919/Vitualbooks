package com.example.VirtualBookStore.DTO;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterRequest {

    private String Username;
    private String Email;
    private String password;
}
