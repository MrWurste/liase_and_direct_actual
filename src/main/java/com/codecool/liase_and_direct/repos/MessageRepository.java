package com.codecool.liase_and_direct.repos;

import com.codecool.liase_and_direct.models.messages.Message;
import com.codecool.liase_and_direct.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository of Message. Because it extends JpaRepository no implementation is needed.
 * Model: typeOfMethod 'keyWord''fieldFromClass'(parameter type)
 * It's possible to add 'And' and another 'fieldFromClass' and so on.
 */
public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findAllByAddressedTo(User to);
    List<Message> findAllByAddressedToAndFrom(User to, User from);
}
