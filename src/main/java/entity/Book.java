package entity;

import lombok.*;
import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Book {
    private final String id = UUID.randomUUID().toString();
    private String title;
    private String author;
    private String ISBN;
    private String year;
}
