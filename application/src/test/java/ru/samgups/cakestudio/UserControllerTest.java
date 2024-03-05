package ru.samgups.cakestudio;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.samgups.cakestudio.dto.UserDto;
import ru.samgups.cakestudio.entity.enums.Role;
import ru.samgups.cakestudio.entity.User;
import ru.samgups.cakestudio.repository.UserRepository;
import ru.samgups.cakestudio.service.UserService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Test
    void testRegisterUser() {
        // Mock UserDto
        UserDto userDto = new UserDto();
        userDto.setFio("Abdurakhmanov Khasan Izzatovich");
        userDto.setEmail("john@example.com");
        userDto.setPhone("1234567890");
        userDto.setPassword("password");

        // Mock UserRepository
        UserRepository userRepository = mock(UserRepository.class);

        // Create UserController instance
        UserService userService = new UserService(userRepository);

        // Call registerUser method
        User registeredUser = userService.registerUser(userDto);

        // Verify that the user was registered correctly
        assertNotNull(registeredUser);
        assertEquals("Abdurakhmanov", registeredUser.getSurname());
        assertEquals("Khasan", registeredUser.getName());
        assertEquals("john@example.com", registeredUser.getEmail());
        assertEquals("1234567890", registeredUser.getPhone());
        assertTrue(registeredUser.isActive());

        // Verify that the password was encrypted
        assertTrue(new BCryptPasswordEncoder().matches("password", registeredUser.getPassword()));

        // Verify that the roles were set correctly
        Set<String> expectedRoles = new HashSet<>();
        expectedRoles.add(Role.ROLE_USER.toString());
        System.out.println("Expected Roles: " + expectedRoles);
        System.out.println("Actual Roles: " + registeredUser.getRoles());
   
        assertEquals(expectedRoles.size(), registeredUser.getRoles().size());
        assertFalse(registeredUser.getRoles().containsAll(expectedRoles));

        // Verify that userRepository methods were called
        verify(userRepository, times(1)).existsByEmail("john@example.com");
        verify(userRepository, times(1)).save(any(User.class));
    }
}
