package authorization.model;

import authorization.entity.Account;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetailModel implements UserDetails {

    private UUID accountId;
    private String username;
    private String password;
    private String email;
    private Boolean isActive;
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public void setAccount(Account account,Collection<String> roles)
    {
        accountId = account.getAccountId();
        username = account.getUsername();
        password = account.getPassword();
        email = account.getEmail();
        isActive = account.getIsActive();
        
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String role:roles) {
            var authority = new SimpleGrantedAuthority(role);
            grantedAuthorities.add(authority);
        }
        authorities = grantedAuthorities;
    }

}
