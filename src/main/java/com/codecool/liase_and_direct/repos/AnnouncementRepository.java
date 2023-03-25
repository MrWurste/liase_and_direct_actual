package com.codecool.liase_and_direct.repos;

import com.codecool.liase_and_direct.models.announcements.Announcement;
import com.codecool.liase_and_direct.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Repository of Announcement. Because it extends JpaRepository no implementation is needed.
 * Model: typeOfMethod 'keyWord''fieldFromClass'(parameter type)
 */
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    List<Announcement> findAllByShowToIn(Set<User> s);
}
