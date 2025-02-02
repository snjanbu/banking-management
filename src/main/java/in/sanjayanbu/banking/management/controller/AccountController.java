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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sanjayanbu.banking.management.dto.AmountDto;
import in.sanjayanbu.banking.management.dto.AccountDto;
import in.sanjayanbu.banking.management.service.AccountService;
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
@RequestMapping("/api/accounts")
@Validated
@Tag(name= "Accounts", description = "APIs for account management")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping
	@Operation(description = "Create Account")
	@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully created account", 
                     content = @Content(schema = @Schema(implementation = AccountDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	public ResponseEntity<AccountDto> createAccount(@RequestBody @Valid AccountDto accountDto) {
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	@Operation(description = "Get Account By Id")
	@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully retrieved account", 
                     content = @Content(schema = @Schema(implementation = AccountDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	public ResponseEntity<AccountDto> getAccountById(@Parameter(description = "ID of the account to retrieve", example = "1") @PathVariable Long id) {
		return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}/deposit")
	@Operation(description = "Deposit Amount")
	@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully deposited amount", 
                     content = @Content(schema = @Schema(implementation = AccountDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	public ResponseEntity<AccountDto> depositAmountById(@Parameter(description = "ID of the account to deposit", example = "1") @PathVariable Long id, @RequestBody @Valid AmountDto amountDto) {
		return new ResponseEntity<>(accountService.deposit(id, amountDto.getAmount()), HttpStatus.OK);
	}
	
	@PutMapping("/{id}/withdraw")
	@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully withdrawn amount", 
                     content = @Content(schema = @Schema(implementation = AccountDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	public ResponseEntity<AccountDto> withdrawAmountById(@Parameter(description = "ID of the account to withdraw", example = "1") @PathVariable Long id, @RequestBody @Valid AmountDto amountDto) {
		return new ResponseEntity<>(accountService.withdraw(id, amountDto.getAmount()), HttpStatus.OK);
	}
	
	@GetMapping
	@Operation(description = "Get All Accounts")
	@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully retrieved account list", 
                     content = @Content(array = @ArraySchema(schema = @Schema(implementation = AccountDto.class)))),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	public ResponseEntity<List<AccountDto>> getAllAccounts() {
		return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Operation(description = "Delete Account By Id")
	@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Deleted successfully"), 
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })

	public ResponseEntity<String> deleteAccountById(@Parameter(description = "ID of the account to delete", example = "1") @PathVariable Long id) {
		accountService.deleteAccountById(id);
		return new ResponseEntity<>("Account Deleted Successfully", HttpStatus.OK);
	}
}
