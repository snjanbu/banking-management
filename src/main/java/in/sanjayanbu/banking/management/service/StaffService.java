package in.sanjayanbu.banking.management.service;

import java.util.List;

import in.sanjayanbu.banking.management.dto.StaffDto;

public interface StaffService {

	StaffDto createStaff(StaffDto staffDto);
	
	StaffDto getStaffById(Long id);
	
	List<StaffDto> getAllStaffs();
	
	void deleteStaffById(Long id);
}
