package com.etfdoc.etfdoc.Repositories;

import com.etfdoc.etfdoc.Models.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAccountRepository extends PagingAndSortingRepository<Account, Long> {

    Account getAccountById(Long id);

    Account getAccountByEmail(String email);

}
