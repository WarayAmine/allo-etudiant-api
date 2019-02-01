package m2.eservices.alloetudiant.servicesImpl;

import m2.eservices.alloetudiant.pojos.Profile;
import m2.eservices.alloetudiant.services.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    ProfilesService profilesService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Profile profile = profilesService.findByEmail(email);
        if(profile == null)
            throw new UsernameNotFoundException("username given not found");
        if(!profile.isEnabled())
            throw new UsernameNotFoundException("email not confirmed");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        profile.getRoles().forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r));
        });
        return new User(profile.getEmail(), profile.getPassword(), authorities);
    }

}
