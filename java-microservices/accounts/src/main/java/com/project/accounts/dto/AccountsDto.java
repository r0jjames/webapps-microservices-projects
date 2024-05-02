package com.project.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDto {
    @Schema(
            description = "Account number of customer",
            example = "31234556789"
    )
    @NotEmpty(message = "Account number cannot be empty or null")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "AccountNumber must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account Type of customer",
            example = "Savings"
    )
    @NotEmpty(message = "AccountType cannot be empty or null")
    private String accountType;

    @Schema(
            description = "Branch address of customer",
            example = "R Tower Metro Manila"
    )
    @NotEmpty(message = "BranchAddress cannot be empty or null")
    private String branchAddress;
}
