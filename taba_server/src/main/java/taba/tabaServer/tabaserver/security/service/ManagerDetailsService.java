package taba.tabaServer.tabaserver.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import taba.tabaServer.tabaserver.domain.Manager;
import taba.tabaServer.tabaserver.repository.ManagerRepository;

@Service
@RequiredArgsConstructor
@Primary
public class ManagerDetailsService implements UserDetailsService {
    private final ManagerRepository managerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Manager manager = managerRepository.findByLoginId(username);
        if (manager == null) {
            throw new UsernameNotFoundException("Manager not found with login id: " + username);
        }

        return User.builder()
                .username(manager.getLoginId())
                .password(manager.getPassword())
                .authorities("ROLE_" + manager.getManagerType().name()) // Assuming ManagerType is an enum that represents the role
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
