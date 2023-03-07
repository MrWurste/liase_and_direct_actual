package com.codecool.liase_and_direct.controllers;

import com.codecool.liase_and_direct.models.announcements.Announcement;
import com.codecool.liase_and_direct.models.announcements.AnnouncementRequest;
import com.codecool.liase_and_direct.models.announcements.AnnouncementResponse;
import com.codecool.liase_and_direct.repos.AnnouncementRepository;
import com.codecool.liase_and_direct.repos.UserRepository;
import com.codecool.liase_and_direct.user.Role;
import com.codecool.liase_and_direct.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/announcements")
public class AnnouncemntController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AnnouncementRepository announcementRepository;

    /**
     * Allow Admin user to post new announcement.
     * Method check if user has an ADMIN role, if not new announcement is not posted and 401 code returned.
     * If user has an ADMIN role, method save new annoucemt.
     * Authentication is from spring security. Used to manipulate currently logged user - from JwtToken
     * @param announcementRequest
     * @return Authorized - ok | Unauthorized - 401
     */
    @PostMapping
    public ResponseEntity<String> test(@RequestBody AnnouncementRequest announcementRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().equals(Role.ADMIN)) {
            String currentEmail = authentication.getName();
            List<String> userEmails = announcementRequest.getUserEmails();
            String title = announcementRequest.getTitle(), body = announcementRequest.getBody();
            Set<User> showTo = new HashSet<>();
            for (String userEmail : userEmails) {
                showTo.add(userRepository.findByEmail(userEmail).get());
            }
            Optional<User> user = userRepository.findByEmail(currentEmail);

            user.ifPresent(createdBy -> {
                Announcement announcement = new Announcement(null, showTo, createdBy, title, body);
                announcementRepository.save(announcement);

            });
            return ResponseEntity.ok("Announcement created successfully");
        }
        else {
            return ResponseEntity.status(401).body("Not sufficient authority");
        }
    }

    /**
     * Show current user announcements that are adressed for him
     * @return Set of AnnouncemetsResponse. If no announcemets found, new user-friendly AnnoucemetResponse is created,
     * istead of title - null, body - null
     */
    @GetMapping
    public ResponseEntity<Set<AnnouncementResponse>> getAnnounement() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentEmail = authentication.getName();
        Set<User> userSet = new HashSet<>();
        userSet.add(userRepository.findByEmail(currentEmail).get());
        Set<AnnouncementResponse> announcements = new HashSet<>();
        for (Announcement a: announcementRepository.findAllByShowToIn(userSet)) {
            announcements.add(new AnnouncementResponse(a.getTitle(),a.getBody()));
        }
        if (announcements.isEmpty()) {
            AnnouncementResponse notFound = new AnnouncementResponse("NO ANNOUNCEMETS YET","New announcemets will be shown here");
            announcements.add(notFound);
            return ResponseEntity.ok(announcements);
        }
        return ResponseEntity.ok(announcements);
    }
}
