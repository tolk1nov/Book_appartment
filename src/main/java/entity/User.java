package entity;

import lombok.*;
import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {
    private final String id = UUID.randomUUID().toString();
    private String name;
    private String surname;
    private Integer age;
    private String login;
    private String password;

}
