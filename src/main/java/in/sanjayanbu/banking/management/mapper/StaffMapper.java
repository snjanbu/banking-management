package in.sanjayanbu.banking.management.mapper;

import in.sanjayanbu.banking.management.dto.StaffDto;
import in.sanjayanbu.banking.management.entity.Staff;

public class StaffMapper {
	
	public static StaffDto convertToDto(Staff staff) {
		
		StaffDto staffDto = new StaffDto();
		staffDto.setId(staff.getId());
		staffDto.setName(staff.getName());
		staffDto.setType(staff.getType());
		return staffDto;
	}

	public static Staff convertToEntity(StaffDto staffDto) {
		
		Staff staff = new Staff();
		staff.setId(staffDto.getId());
		staff.setName(staffDto.getName());
		staff.setType(staffDto.getType());
		return staff;
	}
}
