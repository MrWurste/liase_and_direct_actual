package com.codecool.liase_and_direct.models.announcements;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model of response from backend api. Only title and body from announcement need to be sent.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementResponse {
    String title;
    String body;
}
