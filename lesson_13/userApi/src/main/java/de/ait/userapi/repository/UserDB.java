package de.ait.userapi.repository;

import de.ait.userapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class UserDB implements UserRepository{
    private Long lastId = 6L;
    private static HashMap<Long, User> map = new HashMap<>();
    static {
        map.put(1L, new User(1L,"Jack", "jack@mail.com", "123"));
        map.put(2L, new User(2L,"John", "john@mail.com","123"));
        map.put(3L, new User(3L,"Anna", "anna@mail.com","123"));
        map.put(4L, new User(4L,"Lena", "lena@mail.com","123"));
        map.put(5L, new User(5L,"Ira", "ira@mail.com","123"));
        map.put(6L, new User(6L,"Stepan", "stepan@mail.com","123"));
    }

    public List<User> findAll() {
        return map.values().stream().toList();
    }

    public User findById(Long id) {
        return map.get(id);
    }

    @Override
    public User save(User user) {
        user.setId(++lastId);
        map.put(user.getId(), user);
        return user;
    }
}
