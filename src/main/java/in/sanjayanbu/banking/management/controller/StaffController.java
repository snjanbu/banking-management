package in.sanjayanbu.banking.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sanjayanbu.banking.management.dto.StaffDto;
import in.sanjayanbu.banking.management.service.StaffService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/staffs")
@Validated
@Tag(name= "Staffs", description = "APIs for staff management")
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	@PostMapping
	@Operation(description = "Create Staff")
	@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully created staff", 
                     content = @Content(schema = @Schema(implementation = StaffDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	public ResponseEntity<StaffDto> createStaff(@RequestBody @Valid StaffDto staffDto) {
		return new ResponseEntity<>(staffService.createStaff(staffDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	@Operation(description = "Get Staff By Id")
	@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully retrieved staff", 
                     content = @Content(schema = @Schema(implementation = StaffDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	public ResponseEntity<StaffDto> getStaffById(@Parameter(description = "ID of the staff to retrieve", example = "1") @PathVariable Long id) {
		return new ResponseEntity<>(staffService.getStaffById(id), HttpStatus.OK);
	}
	
	@GetMapping
	@Operation(description = "Get All Staffs")
	@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully retrieved staff list", 
                     content = @Content(array = @ArraySchema(schema = @Schema(implementation = StaffDto.class)))),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	public ResponseEntity<List<StaffDto>> getAllStaffs() {
		return new ResponseEntity<>(staffService.getAllStaffs(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Operation(description = "Delete Staff By Id")
	@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Deleted successfully"), 
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	public ResponseEntity<String> deleteStaffById(@Parameter(description = "ID of the staff to delete", example = "1") @PathVariable Long id) {
		staffService.deleteStaffById(id);
		return new ResponseEntity<>("Staff Deleted Successfully", HttpStatus.OK);
	}
}
