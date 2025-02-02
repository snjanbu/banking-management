package in.sanjayanbu.banking.management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sanjayanbu.banking.management.dto.AccountDto;
import in.sanjayanbu.banking.management.entity.Account;
import in.sanjayanbu.banking.management.mapper.AccountMapper;
import in.sanjayanbu.banking.management.repository.AccountRepository;
import in.sanjayanbu.banking.management.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountDto createAccount(AccountDto accountDto) {

		Account account = AccountMapper.mapToEntity(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		
		return accountRepository.findById(id)
				.map(AccountMapper::mapToDto)
				.orElseThrow(() -> new RuntimeException("Account does not exist"));
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		
		accountRepository.findById(id)
				.ifPresent(account -> {
					account.setBalance(account.getBalance() + amount);
					accountRepository.save(account);
				});
		
		return getAccountById(id);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {

		accountRepository.findById(id)
			.ifPresent(account -> {
				Double balance = account.getBalance() - amount;
				if (balance < 0) {
					throw new RuntimeException("Not sufficient balance to withdraw the amount");
				}
				account.setBalance(account.getBalance() - amount);
				accountRepository.save(account);
			});
		return getAccountById(id);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		
		return accountRepository.findAll().stream()
				.map(AccountMapper::mapToDto)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteAccountById(Long id) {

		accountRepository.deleteById(id);
	}

}
