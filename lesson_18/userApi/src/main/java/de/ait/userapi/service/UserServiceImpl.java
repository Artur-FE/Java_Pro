package de.ait.userapi.service;

import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.exceptions.BadRoleException;
import de.ait.userapi.exceptions.UserNotFoundException;
import de.ait.userapi.mapper.UserMapper;
import de.ait.userapi.model.Role;
import de.ait.userapi.model.User;
import de.ait.userapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository repository;
    private final UserMapper maper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponseDto> getAllUsers() {
        return maper.toDtoList(repository.findAll());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = repository.findById(id).get();
        if(user!=null){
            return maper.toDto(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public UserResponseDto addUser(UserRequestDto dto) {
        User user = maper.fromDto(dto);
        user.addRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = repository.save(user);
        if(savedUser!=null){
            return maper.toDto(savedUser);
        } else {
            throw  new RuntimeException("Error create new user");
        }

    }

    private static Role roleOf(String strRole){
        try{
           return Role.valueOf(strRole.toUpperCase().trim());
        } catch (Exception e){
            throw new BadRoleException();
        }
    }

    @Override
    public List<UserResponseDto> getUsersByRole(String strRole) {
        Role role = roleOf(strRole);
       return maper.toDtoList(repository.findByRolesContaining(role));
    }

    @Override
    public UserResponseDto assignRole(Long userId, String strRole) {
        Role role = roleOf(strRole);
        User user = repository.findById(userId).orElseThrow(UserNotFoundException::new);
        user.addRole(role);
        repository.save(user);
        return maper.toDto(user);
    }

    @Override
    public UserResponseDto removeRole(Long userId, String strRole) {
        Role role = roleOf(strRole);
        User user = repository.findById(userId).orElseThrow(UserNotFoundException::new);
        user.removeRole(role);
        repository.save(user);
        return maper.toDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findUserByEmail(username).orElseThrow(()->new UsernameNotFoundException("username not found" + username));
    }
}
