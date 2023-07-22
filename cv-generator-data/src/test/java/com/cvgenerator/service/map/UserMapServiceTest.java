package com.cvgenerator.service.map;

import com.cvgenerator.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserMapServiceTest {

    UserMapService userMapService;
    User user;
    Long userId = 1L;

    @BeforeEach
    void setUp() {
        userMapService = new UserMapService();

        user = User.builder().id(userId).username("user 1").build();

        userMapService.save(user);
    }

    @Test
    void findAll() {
        Set<User> users = userMapService.findAll();

        assertEquals(1, users.size());
    }

    @Test
    void findById() {
        User foundUser = userMapService.findById(userId);

        assertEquals(userId, foundUser.getId());
        assertEquals(user.getUsername(), foundUser.getUsername());
    }

    @Test
    void saveExistId() {
        Long id = 2L;
        String username = "user 2";
        User savedUser = userMapService.save(User.builder().id(id).username(username).build());

        assertNotNull(savedUser);
        assertEquals(id, savedUser.getId());
        assertEquals(username, savedUser.getUsername());
    }

    @Test
    void saveNoId() {
        String username = "user 2";
        User savedUser = userMapService.save(User.builder().username(username).build());

        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());
        assertEquals(username, savedUser.getUsername());
    }

    @Test
    void delete() {
        userMapService.delete(user);

        assertEquals(0, userMapService.findAll().size());
    }

    @Test
    void deleteById() {
        userMapService.deleteById(userId);

        assertEquals(0, userMapService.findAll().size());
    }
}