package com.gaurav.projects.loveable_clone.entity;

import com.gaurav.projects.loveable_clone.enums.MessageRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    ChatSession chatSession;

    @Enumerated(EnumType.STRING)
    MessageRole role;
    String content;
    String toolCalling; // json array of tools called
    Integer tokensUsed;
    Instant createdAt;
}
