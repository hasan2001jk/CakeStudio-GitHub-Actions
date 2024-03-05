package ru.samgups.cakestudio;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.samgups.cakestudio.service.UserService;
import ru.samgups.cakestudio.repository.UserRepository;
import ru.samgups.cakestudio.dto.UserDto;
import ru.samgups.cakestudio.entity.User;
import ru.samgups.cakestudio.CakestudioApplication;

@SpringBootTest(classes = CakestudioApplication.class)
class UserServiceTest {
    @Autowired
    UserService userService;
    @MockBean
    UserRepository userRepository;

    @Test
    void registerUser() {
        UserDto userDto = new UserDto();
        userDto.setFio("Test User");
        userDto.setEmail("test@example.com");
        userDto.setPhone("1234567890");
        userDto.setId(1L);
        userDto.setPassword("password");

        when(userRepository.existsByEmail(anyString())).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(new User());

        User registeredUser = userService.registerUser(userDto);

        assertNotNull(registeredUser);
        assertEquals(userDto.getEmail(), registeredUser.getEmail());
    }
}
