package in.sanjayanbu.banking.management.dto;

import in.sanjayanbu.banking.management.enums.StaffType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Staff request payload")
public class StaffDto {

	@Schema(hidden = true)
	private Long id;
	
	@NotNull
	@NotEmpty(message = "Name is required")
	@Schema(description = "Name of the staff", example="John Doe")
	private String name;
	
	@NotNull(message = "Type is required")
	@Schema(description = "Type of the staff", example= "MANAGER")
	private StaffType type;
}
