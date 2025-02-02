package in.sanjayanbu.banking.management.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Amount request payload")
public class AmountDto {
	
	@NotNull
	@Schema(description = "Amount to be deposited/withdrawn", example="200")
	private Double amount;

}
