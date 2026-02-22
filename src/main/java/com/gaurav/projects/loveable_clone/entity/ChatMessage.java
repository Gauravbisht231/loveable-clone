package com.gaurav.projects.loveable_clone.entity;

import com.gaurav.projects.loveable_clone.enums.MessageRole;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ChatMessage
{
    Long id;
    ChatSession chatSession;
    MessageRole role;
    String content;
    String toolCalling; // json array of tools called
    Integer tokensUsed;
    Instant createdAt;
}
