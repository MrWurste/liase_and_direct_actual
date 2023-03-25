package com.codecool.liase_and_direct.controllers;

import com.codecool.liase_and_direct.models.messages.Message;
import com.codecool.liase_and_direct.models.messages.MessageReguestSpecific;
import com.codecool.liase_and_direct.models.messages.MessageRequest;
import com.codecool.liase_and_direct.models.messages.MessageResponse;
import com.codecool.liase_and_direct.repos.MessageRepository;
import com.codecool.liase_and_direct.repos.UserRepository;
import com.codecool.liase_and_direct.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/messenger")
public class MessageController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MessageRepository messageRepository;

    /**
     * Send message to user with given email. Sender data is saved.
     * @param messageRequest addressed to (email) and from (email)
     * @return
     */
    @PostMapping
    ResponseEntity sendMessage(@RequestBody MessageRequest messageRequest) {
        final User[] addressedTo = new User[1];
        Optional<User> a = userRepository.findByEmail(messageRequest.getAddressedTo());
        a.ifPresent(u -> {
            addressedTo[0] = a.get();
        });
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> from = userRepository.findByEmail(authentication.getName());
        from.ifPresent(f -> {
            Message message = new Message(null,addressedTo[0],f, messageRequest.getMessage());
            messageRepository.save(message);
        });
        return ResponseEntity.ok("Message sent");
    }

    /**
     * Get all messages addressed to current user.
     * @return Set of all messages
     */
    @GetMapping("/all")
    public ResponseEntity<Set<MessageResponse>> getMessages() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentEmail = authentication.getName();
        Set<MessageResponse> messages = new HashSet<>();
        Optional<User> me = userRepository.findByEmail(currentEmail);
        me.ifPresent(I -> {
            for (Message m: messageRepository.findAllByAddressedTo(me.get())) {
                messages.add(new MessageResponse(m.getId(),m.getMessage(),m.getFrom().getFirstname(),m.getFrom().getLastname(),m.getFrom().getEmail()));
            }
        });
        if(messages.isEmpty()) {
            messages.add(new MessageResponse("No messages yet", "Chat", "Bot", ""));
        }
        return ResponseEntity.ok(messages);
    }

    /**
     * Get messages from specific user
     * @param specific from (email)
     * @return Set of messages only from specified user
     */
    @GetMapping("/from")
    public ResponseEntity<Set<MessageResponse>> getMessagesFrom(@RequestBody MessageReguestSpecific specific) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentEmail = authentication.getName();
        Set<MessageResponse> messages = new HashSet<>();
        Optional<User> me = userRepository.findByEmail(currentEmail);
        Optional<User> from = userRepository.findByEmail(specific.getFrom());
        me.ifPresent(I -> {
            for (Message ms: messageRepository.findAllByAddressedToAndFrom(me.get(),from.get())) {
                messages.add(new MessageResponse(ms.getMessage(),ms.getFrom().getFirstname(),ms.getFrom().getLastname(),ms.getFrom().getEmail()));
            }
        });
        if(messages.isEmpty()) {
            messages.add(new MessageResponse("No messages yet", "Chat", "Bot", ""));
        }
        return ResponseEntity.ok(messages);
    }
}
