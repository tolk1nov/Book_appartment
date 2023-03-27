package entity;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rent {
    private final String id = UUID.randomUUID().toString();
    private String userlogin;
    private String bookTitle;
}
