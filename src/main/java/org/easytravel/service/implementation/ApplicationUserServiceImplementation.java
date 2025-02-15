package org.easytravel.service.implementation;

import lombok.AllArgsConstructor;
import org.easytravel.model.ApplicationUser;
import org.easytravel.repository.ApplicationUserRepository;
import org.easytravel.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ApplicationUserServiceImplementation implements ApplicationUserService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ApplicationUser> applicationUser = applicationUserRepository.findByUsername(username);
        if(applicationUser.isPresent()) {
            var userObj = applicationUser.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .build();
        }
        else{
            throw new UsernameNotFoundException(username);
        }
    }

    @Override
    public ApplicationUser save(ApplicationUser user) {
        return applicationUserRepository.save(user);
    }
}
