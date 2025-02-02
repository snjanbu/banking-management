package in.sanjayanbu.banking.management.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Staff types in the system")
public enum StaffType {
	
	@Schema(description="Manager role") MANAGER,
	@Schema(description="Cashier role") CASHIER,
	@Schema(description="CRM Executive role") CRM_EXECUTIVE
}
