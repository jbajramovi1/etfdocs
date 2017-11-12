package ba.services;

import ba.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ba.repositories.AccountRepository;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class AccountService implements UserDetailsService {


    AccountRepository repository;

    @Autowired
    void setRepository(AccountRepository accountRepository){
        this.repository=accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String data) throws UsernameNotFoundException {

        Account account = repository.findByUsername(data);
        if(account == null) {
            throw new UsernameNotFoundException("Authentication error occured");
        }
        return new User(account.getEmail(), account.getPassword(), getGrantedAuthorities(account));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(Account account) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(account.getEmail()));
        return authorities;
    }

    public Account getAccountByEmail(String email) {
        Account account = repository.findByUsername(email);
        return account;

    }

    public ResponseEntity register(Account account) {
        if (account.getEmail()=="")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username ne može biti prazno");
        else if (repository.findByUsername(account.getEmail())!=null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username mora biti jedinstven");
        else if (account.getPassword()=="")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password ne može biti prazno");


        account.setPassword(toMD5(account.getPassword()));
        Account acc = repository.save(account);

        return ResponseEntity.status(HttpStatus.OK).body( acc != null);

    }

    public String toMD5(String str)
    {
        byte[] pass = null;

        try {
            pass = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        StringBuffer hexString = new StringBuffer();

        byte[] passHash = m.digest(pass);

        for (int i = 0; i < passHash.length; i++) {
            if ((0xff & passHash[i]) < 0x10) {
                hexString.append("0"
                        + Integer.toHexString((0xFF & passHash[i])));
            } else {
                hexString.append(Integer.toHexString(0xFF & passHash[i]));
            }
        }

        return hexString.toString();
    }
}
