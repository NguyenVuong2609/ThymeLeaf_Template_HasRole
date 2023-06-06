package nguyen.vuong.repository;

import nguyen.vuong.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User,Long> {
    boolean existsUserByEmail(String email);
}
