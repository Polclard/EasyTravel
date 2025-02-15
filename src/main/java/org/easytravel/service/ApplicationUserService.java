package org.easytravel.service;

import org.easytravel.model.ApplicationUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ApplicationUserService extends UserDetailsService {
    ApplicationUser save(ApplicationUser user);
}
