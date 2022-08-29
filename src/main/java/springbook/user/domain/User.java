package springbook.user.domain;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private String password;
}
