package com.example.springkafkahelloworld.message;


import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RandomClassObjectDto {

    private List<UUID> documentIds;

    private String receiverEmail;

    private String organizationId;

    private String requestId;
}
