package in.sanjayanbu.banking.management.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Account request payload")
public class AccountDto {
	
	@Schema(hidden = true)
	private Long id;
	
	@NotNull
	@NotEmpty(message = "Name is required")
	@Schema(description = "Name of the account", example="John Doe")
	private String accountHolderName;
	
	@NotNull(message = "Balance is required")
	@Schema(description = "Balance of the account", example="100")
	private Double balance;
}
