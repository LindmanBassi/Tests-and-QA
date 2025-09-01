package bassi.lindman.bank;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransactionValidatorTest {

    private TransactionValidator validator = new TransactionValidator();

    @Nested
    class validateTransaction {

        @Test
        void shouldThrowIllegalArgumentWhenTransactionIsZero() {

            // Arrange
            var transaction = new Transaction(0,
                     "PIX", false, 0
            );

            // Act && Assert
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validateTransaction(transaction);
            });
        }

        @Test
        void shouldThrowIllegalArgumentWhenTransactionIsNegative() {

            // Arrange
            var transaction = new Transaction(-2,
                    "PIX", false, 0
            );

            // Act && Assert
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validateTransaction(transaction);
            });
        }

        @Test
        void shouldReturnBlockedWhenFailedAttemptsIsEqualTo3() {

            // Arrange
            var transaction = new Transaction(20,
                    "PIX", false, 3
            );

            // Act
            var output = validator.validateTransaction(transaction);

            // Assert
            assertEquals("BLOCKED", output);
        }

        @Test
        void shouldReturnBlockedWhenFailedAttemptsIsBiggerThan3() {

            // Arrange
            var transaction = new Transaction(20,
                    "PIX", false, 4
            );

            // Act
            var output = validator.validateTransaction(transaction);

            // Assert
            assertEquals("BLOCKED", output);
        }

        @Test
        void shouldReturnManualReviewWhenIsInternationalAndValueIsBiggerThan1000() {

            // Arrange
            var transaction = new Transaction(1001,
                    "PIX", true, 0
            );

            // Act
            var output = validator.validateTransaction(transaction);

            // Assert
            assertEquals("MANUAL REVIEW", output);
        }

        @Test
        void shouldReturnManualReviewWhenIsNotInternationalAndValueIsBiggerThan1000() {

            // Arrange
            var transaction = new Transaction(1001,
                    "PIX", false, 0
            );

            // Act
            var output = validator.validateTransaction(transaction);

            // Assert
            assertEquals("APPROVED", output);
        }

        @Test
        void shouldReturnApprovedWhenIsInternationalAndValueIsSmallerThan1000() {

            // Arrange
            var transaction = new Transaction(0.5,
                    "PIX", true, 0
            );

            // Act
            var output = validator.validateTransaction(transaction);

            // Assert
            assertEquals("APPROVED", output);
        }

        @Test
        void shouldReturnApprovedWhenIsInternationalAndValueIsEqualTo1000() {

            // Arrange
            var transaction = new Transaction(1000,
                    "PIX", true, 0
            );

            // Act
            var output = validator.validateTransaction(transaction);

            // Assert
            assertEquals("APPROVED", output);
        }

        @Test
        void shouldReturnManualReviewWhenIsPixAndIsBiggerThan5000() {

            // Arrange
            var transaction = new Transaction(5001,
                    "PIX", false, 0
            );

            // Act
            var output = validator.validateTransaction(transaction);

            // Assert
            assertEquals("MANUAL REVIEW", output);
        }

        @Test
        void shouldReturnApprovedWhenIsPixAndIsEqualTo5000() {

            // Arrange
            var transaction = new Transaction(5000,
                    "PIX", false, 0
            );

            // Act
            var output = validator.validateTransaction(transaction);

            // Assert
            assertEquals("APPROVED", output);
        }

        @Test
        void shouldReturnBlockedWhenIsBiggerThan10000() {

            // Arrange
            var transaction = new Transaction(10001,
                    "TED", false, 0
            );

            // Act
            var output = validator.validateTransaction(transaction);

            // Assert
            assertEquals("BLOCKED", output);
        }

        @Test
        void shouldReturnApprovedWhenTEDAndIsEqualTo10000() {

            // Arrange
            var transaction = new Transaction(10000,
                    "TED", false, 0
            );

            // Act
            var output = validator.validateTransaction(transaction);

            // Assert
            assertEquals("APPROVED", output);
        }

        @Test
        void shouldReturnApprovedWhenIsPixAndIsSmallerThan5000() {

            // Arrange
            var transaction = new Transaction(3500,
                    "PIX", false, 0
            );

            // Act
            var output = validator.validateTransaction(transaction);

            // Assert
            assertEquals("APPROVED", output);
        }

        @Test
        void shouldReturnApprovedWhenIsPixAndIsEqualToCents() {

            // Arrange
            var transaction = new Transaction(0.5,
                    "PIX", false, 0
            );

            // Act
            var output = validator.validateTransaction(transaction);

            // Assert
            assertEquals("APPROVED", output);
        }
    }
}