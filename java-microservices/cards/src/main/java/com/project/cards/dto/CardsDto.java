package com.project.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
@Schema(
        name = "Cards",
        description = "Schema to hold cards information"
)
@Data
public class CardsDto {
    @Schema(description = "Mobile number of Customer", example = "0123456789")
    @NotEmpty(message = "Mobile number can't be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(description = "Card number of Customer", example = "111111111123")
    @NotEmpty(message = "Customer number of can't be null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Card number must be 12 digits")
    private String cardNumber;

    @Schema(description = "Type of the card", example = "Credit Card")
    @NotEmpty(message = "Card Type can't be null or empty")
    private String cardType;

    @Schema(description = "Total limit available against the card", example = "100000")
    @Positive(message = "Total card should be greater than zero")
    private int totalLimit;

    @Schema(description = "Total amount used by a customer", example = "1000")
    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")
    private int amountUsed;

    @Schema(description = "Total available amount against the card", example = "90000")
    @PositiveOrZero(message = "Total available amount should be equal or greater than zero")
    private int availableAmount;
}
