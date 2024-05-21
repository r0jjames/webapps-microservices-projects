package com.project.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(
        name = "CustomerDetails",
        description = "Schema to hold Customer, Loans, Cards and Account Information"
)
@Data
public class CustomerDetailsDto {
    @Schema(
            description = "Name of customer", example = "RudzJeymz"
    )
    @NotEmpty(message = "Name cannot be a null or empty")
    @Size(min = 5, max = 30, message = "The length of customer should be between 5 and 30")
    private String name;

    @Schema(
            description = "Email address of Customer", example = "rudzjeymz@gmail.com"
    )
    @Email(message = "Email should be a valid value")
    private String email;

    @Schema(
            description = "Mobile number of customer",
            example = "0123456789"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account Details of the Customer"
    )
    private AccountsDto accountsDto;

    @Schema(
            description = "Loans Details of the Customer"
    )
    private LoansDto loansDto;

    @Schema(
            description = "Card Details of the Customer"
    )
    private CardsDto cardsDto;


}
