package com.codecool.liase_and_direct.models.messages;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * REQUEST TYPE: POST
 * Model of request that contains message and to who message should be sent
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    String addressedTo;
    String message;
}
