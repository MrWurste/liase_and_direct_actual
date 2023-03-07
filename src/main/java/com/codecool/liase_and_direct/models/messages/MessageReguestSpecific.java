package com.codecool.liase_and_direct.models.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * REQEST TYPE: GET
 * Model of request just to specify from which user messages should be shown
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageReguestSpecific {
    String from;
}
