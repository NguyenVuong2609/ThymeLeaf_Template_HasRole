package nguyen.vuong.service.role;

import nguyen.vuong.model.Role;
import nguyen.vuong.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Iterable<Role> findAll();
    Optional<Role> findByRoleName(RoleName roleName);
    void setDefaultRoleName();
}
