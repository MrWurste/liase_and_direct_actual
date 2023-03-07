package com.codecool.liase_and_direct;

import com.codecool.liase_and_direct.models.announcements.Announcement;
import com.codecool.liase_and_direct.repos.UserRepository;
import com.codecool.liase_and_direct.user.Role;
import com.codecool.liase_and_direct.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class LiaseAndDirectApplicationTests {
	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
		Set<User> userSet = new HashSet<>();
		userSet.add(new User(null,"as","sa","ema@ema.pl","pass",Role.USER));
		userSet.add(new User(null,"as","sa","emas@ema.pl","pass",Role.USER));
		User user = new User(null,"asas","sasa","emaas@ema.pl","pass",Role.USER);
		Announcement announcement = new Announcement(null,userSet,user,"title","body");
	}

}
