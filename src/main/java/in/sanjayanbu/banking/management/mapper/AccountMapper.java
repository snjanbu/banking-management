package in.sanjayanbu.banking.management.mapper;

import in.sanjayanbu.banking.management.dto.AccountDto;
import in.sanjayanbu.banking.management.entity.Account;

public class AccountMapper {
	
	public static AccountDto mapToDto(Account account) {
		
		AccountDto accountDto = new AccountDto();
		accountDto.setId(account.getId());
		accountDto.setAccountHolderName(account.getName());
		accountDto.setBalance(account.getBalance());
		return accountDto;
	}
	
	public static Account mapToEntity(AccountDto accountDto) {
		
		Account account = new Account();
		account.setId(accountDto.getId());
		account.setName(accountDto.getAccountHolderName());
		account.setBalance(accountDto.getBalance());
		return account;
	}

}
