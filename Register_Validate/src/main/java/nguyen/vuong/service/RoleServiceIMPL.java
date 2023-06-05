package nguyen.vuong.service;

import nguyen.vuong.model.Role;
import nguyen.vuong.model.RoleName;
import nguyen.vuong.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceIMPL implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findByRoleName(RoleName roleName) {
        Iterable<Role> roles = findAll();
        for (Role r : roles) {
            if (r.getRoleName() == roleName){
                return roleRepository.findById(r.getId());
            }
        }
        return Optional.empty();
    }

    @Override
    public void setDefaultRoleName() {
        Iterable<Role> roles = findAll();
        long roleSize = roles.spliterator().getExactSizeIfKnown();
        if (roleSize == 0) {
            List<Role> roleList = new ArrayList<>();
            roleList.add(new Role(1, RoleName.ADMIN));
            roleList.add(new Role(2, RoleName.PM));
            roleList.add(new Role(3, RoleName.USER));
            roleRepository.saveAll(roleList);
        }
    }
}
