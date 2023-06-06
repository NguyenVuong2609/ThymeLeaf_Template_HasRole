package nguyen.vuong.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import nguyen.vuong.model.Role;
@Repository
public interface
IRoleRepository extends CrudRepository<Role, Integer> {
}
