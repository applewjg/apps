package com.applewjg.service;

import com.applewjg.domain.Account;
import com.applewjg.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by baidu on 16/4/22.
 */
@Service
/**
 * 一个自定义的service用来和数据库进行操作. 即以后我们要通过数据库保存权限.则需要我们继承UserDetailsService
 *
 * @author
 *
 */
public class CustomUserDetailsService implements UserDetailsService {

    protected static Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    @Autowired
    AccountRepository accountRepository;

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {

        UserDetails user = null;

        try {
            Account account = accountRepository.findByUsername(username);
            if (account == null) {
                account = accountRepository.findByTel(username);
                if (account == null) {
                    logger.warn("不存在用户");
                    throw new UsernameNotFoundException("此用户不存在");
                }
            }

            user = new User(account.getUsername(), account.getPassword(), true, true, true, true,
                    getAuthorities(account.getRole()));

        } catch (Exception e) {
            logger.error("Error in retrieving user");
            throw new UsernameNotFoundException("Error in retrieving user");
        }
        logger.warn("存在用户");
        return user;
    }

    /**
     * 获得访问角色权限
     *
     * @param access
     * @return
     */
    public Collection<GrantedAuthority> getAuthorities(Integer access) {

        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(2);

        // 所有的用户默认拥有ROLE_USER权限
        logger.debug("Grant ROLE_USER to this user");
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        // 如果参数access为1.则拥有ROLE_ADMIN权限
        if (access.compareTo(1) == 0) {
            logger.debug("Grant ROLE_ADMIN to this user");
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return grantedAuthorities;
    }
}
