package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "kits")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kit {

    @Id
    private String kitId;

    private String kitName;
}
