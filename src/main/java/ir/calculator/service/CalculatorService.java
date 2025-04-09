package ir.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    public double performOperation(double num1, Double num2, String operation) {
        logger.info("Received request to perform operation: {} with num1={} and num2={}", operation, num1, num2);

        double result;

        try {
            switch (operation.toLowerCase()) {
                case "add":
                case "+":
                    result = num1 + (num2 == null ? 0 : num2);
                    logger.info("Addition result: {}", result);
                    break;

                case "subtract":
                case "-":
                    result = num1 - (num2 == null ? 0 : num2);
                    logger.info("Subtraction result: {}", result);
                    break;

                case "multiply":
                case "*":
                    result = num1 * (num2 == null ? 1 : num2);
                    logger.info("Multiplication result: {}", result);
                    break;

                case "divide":
                case "/":
                    if (num2 == null || num2 == 0) {
                        logger.error("Division by zero attempted.");
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = num1 / num2;
                    logger.info("Division result: {}", result);
                    break;

                case "power":
                case "^":
                    result = Math.pow(num1, num2 == null ? 1 : num2);
                    logger.info("Power result: {}", result);
                    break;

                case "sqrt":
                case "r":
                    if (num1 < 0) {
                        logger.error("Square root of a negative number attempted.");
                        throw new ArithmeticException("Square root of a negative number is not allowed.");
                    }
                    result = Math.sqrt(num1);
                    logger.info("Square root result: {}", result);
                    break;

                case "inverse":
                case "1/x":
                case "inv":
                    if (num1 == 0) {
                        logger.error("Inverse of zero attempted.");
                        throw new ArithmeticException("Inverse of zero is not allowed.");
                    }
                    result = 1 / num1;
                    logger.info("Inverse result: {}", result);
                    break;


                case "percent":
                case "%":
                    result = num1 / 100;
                    logger.info("Percent result: {}", result);
                    break;

                default:
                    logger.error("Invalid operation: {}", operation);
                    throw new IllegalArgumentException("Invalid operation: " + operation);
            }
        } catch (ArithmeticException ex) {
            logger.error("ArithmeticException occurred: {}", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            logger.error("An unexpected error occurred: {}", ex.getMessage());
            throw ex;
        }

        return result;
    }
}
