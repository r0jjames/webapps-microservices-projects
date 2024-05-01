package com.project.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {
    @NotEmpty(message = "Account number cannot be empty or null")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "AccountNumber must be 10 digits")
    private Long accountNumber;
    @NotEmpty(message = "AccountType cannot be empty or null")
    private String accountType;
    @NotEmpty(message = "BranchAddress cannot be empty or null")
    private String branchAddress;
}
