package com.verby.restapi.account.command.application;

import com.verby.restapi.account.command.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountInfo signUp(SignUpRequest signUpRequest) {
        if(accountRepository.existsByLoginId(signUpRequest.getLoginId())) {
            throw new LoginIdDuplicateException(signUpRequest.getLoginId());
        }

        AccountRole role = roleRepository.findByName(Role.MEMBER);

        Account newAccount = new Account(signUpRequest.getLoginId(),
                passwordEncoder.encode(signUpRequest.getPassword()),
                signUpRequest.getName(),
                signUpRequest.getPhone(),
                AccountStatus.ACTIVE,
                new HashSet<>(List.of(role)),
                signUpRequest.getAllowToMarketingNotification()
        );

        accountRepository.save(newAccount);

        return AccountInfo.of(newAccount);
    }

}
