package com.codecool.liase_and_direct.models.announcements;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Model of request from frontend part. No more announcement values are needed.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementRequest {
    List<String> userEmails;
    String title;
    String body;
}
