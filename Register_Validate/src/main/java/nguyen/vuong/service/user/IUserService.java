package nguyen.vuong.service.user;

import nguyen.vuong.model.User;

import java.util.Optional;

public interface IUserService {
    Iterable<User> findAll();
    Optional<User> findById(Long id);
    void save(User user);
    void deleteById(Long id);
    boolean existedByEmail(String email);
}
