package ir.calculator.controller;

import io.swagger.v3.oas.annotations.Operation;
import ir.calculator.entity.MessageResponse;
import ir.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculate")
    @Operation(
            summary = "Perform a calculation",
            description = "Enter the following parameters:\n\n" +
                    "- **num1**: The first number (e.g., 5).\n\n" +
                    "- **num2**: The second number (e.g., 3, or `null` for operations that only require one number, such as square root or inverse).\n\n" +
                    "- **operation**: The type of operation to perform:\n\n" +
                    "  - Addition: `add` or `+`\n\n" +
                    "  - Subtraction: `subtract` or `-`\n\n" +
                    "  - Multiplication: `multiply` or `*`\n\n" +
                    "  - Division: `divide` or `/`\n\n" +
                    "  - Power: `power` or `^`\n\n" +
                    "  - Square root: `sqrt` or `r`\n\n" +
                    "  - Inverse: `inverse`, `1/x`, or `inv`\n\n" +
                    "  - Percentage: `percent` or `%`"
    )
    public MessageResponse calculate(@RequestParam double num1,
                                     @RequestParam(required = false) Double num2,
                                     @RequestParam String operation) {
        try {
            double result = calculatorService.performOperation(num1, num2, operation);
            return new MessageResponse("The result of your calculation is: " + result);
        } catch (IllegalArgumentException | ArithmeticException ex) {
            return new MessageResponse("Error: " + ex.getMessage());
        }
    }
}
