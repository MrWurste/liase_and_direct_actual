package com.codecool.liase_and_direct.models.messages;

import com.codecool.liase_and_direct.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model of Message that will be returned to user
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
    Long id;
    String message;
    String firstname;
    String lastname;
    String email;

    /**
     * Model of Message that is sent from api
     * @param message content of message
     * @param firstname firstname of user that send the message
     * @param lastname lastname of user that send the message
     * @param email emal of user that send the message
     */
    public MessageResponse(String message, String firstname, String lastname, String email) {
        this.message=message; this.firstname=firstname; this.lastname=lastname; this.email=email;
    }
}
