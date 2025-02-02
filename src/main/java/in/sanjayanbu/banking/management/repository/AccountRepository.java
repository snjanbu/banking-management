package in.sanjayanbu.banking.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.sanjayanbu.banking.management.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
