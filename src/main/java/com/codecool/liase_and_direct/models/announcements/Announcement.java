package com.codecool.liase_and_direct.models.announcements;

import com.codecool.liase_and_direct.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

/**
 * Model of announcement in database.
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> showTo;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User createdBy;

    private String title;
    private String body;
    //private Date creationDate; TODO add date

}
