package jwt.opa.poc.users;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private final  UserRepo userRepo;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = userRepo.findByusername(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(users.get(0).getUsername(), users.get(0).getPassword(), getAuthority(users));
    }

    private Set<SimpleGrantedAuthority> getAuthority(Collection<User> users) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (User user : users) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        }
        return authorities;
    }
}
