package in.sanjayanbu.banking.management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sanjayanbu.banking.management.dto.StaffDto;
import in.sanjayanbu.banking.management.entity.Staff;
import in.sanjayanbu.banking.management.mapper.StaffMapper;
import in.sanjayanbu.banking.management.repository.StaffRepository;
import in.sanjayanbu.banking.management.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffRepository staffRepository;

	@Override
	public StaffDto createStaff(StaffDto staffDto) {
		
		Staff staff = StaffMapper.convertToEntity(staffDto);
		staffRepository.save(staff);
		return StaffMapper.convertToDto(staff);
	}

	@Override
	public StaffDto getStaffById(Long id) {

		return staffRepository.findById(id)
				.map(StaffMapper::convertToDto)
				.orElseThrow(() -> new RuntimeException("Staff Not Found"));
	}

	@Override
	public List<StaffDto> getAllStaffs() {
		
		return staffRepository.findAll().stream()
				.map(StaffMapper::convertToDto)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteStaffById(Long id) {

		staffRepository.deleteById(id);
	}

}
