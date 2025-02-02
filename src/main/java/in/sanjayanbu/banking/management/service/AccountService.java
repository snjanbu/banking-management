package in.sanjayanbu.banking.management.service;

import java.util.List;

import in.sanjayanbu.banking.management.dto.AccountDto;

public interface AccountService {
	
	
	AccountDto createAccount(AccountDto account);
	
	AccountDto getAccountById(Long id);
	
	AccountDto deposit(Long id, double amount);
	
	AccountDto withdraw(Long id, double amount);
	
	List<AccountDto> getAllAccounts();
	
	void deleteAccountById(Long id);
}
