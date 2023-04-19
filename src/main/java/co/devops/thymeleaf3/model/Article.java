package co.devops.thymeleaf3.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private UUID uuid;
    @NotBlank(message = "title is required ... !")
    private String title;
    private String thumnail;
    @NotBlank(message = "author is required ... !")
    private String author;
}
