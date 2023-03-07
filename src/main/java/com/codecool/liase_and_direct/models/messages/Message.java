package com.codecool.liase_and_direct.models.messages;

import com.codecool.liase_and_direct.user.User;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    User addressedTo;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    User from;
    String message;
}
