package bassi.lindman.junit;

import bassi.lindman.junit.Calculadora;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {


    private Calculadora calculadora = new Calculadora();

    @Nested
    class somar{

        @Test
        @DisplayName("Should add two numbers")
        public void shouldAddTwoNumbers(){

            // Triple AAA(Arrange, Act, Assert)

            //Arrange
            int a = 2;
            int b = 3;

            //Act
            var output = calculadora.somar(a,b);

            //Assert
            assertEquals(5,output);
        }
        @Test
        @DisplayName("Should add when two numbers are zero")
        void shouldAddWhenTwoNumbersIsZero() {

            //Arrange
            int a = 0;
            int b = 0;

            //Act
            var output = calculadora.somar(a,b);

            //Assert
            assertEquals(0,output);
        }
    }
    @Nested
    class subtrair{
        @Test
        @DisplayName("One number minus the other should be more than than two")
        void xMinusYShouldBeMoreThanTwo(){
            int a = 7;
            int b = 5;

            var output = calculadora.subtrair(a,b);

            Assertions.assertEquals(2,output);
        }
    }

    @Nested
    class multiplicar {
        @Test
        @DisplayName("One number multiply by the other should be then")
        void multiplyShouldBeThen() {
            int a = 5;
            int b = 2;

            var output = calculadora.multiplicar(a, b);

            Assertions.assertEquals(10, output);
        }
    }

    @Nested
    class dividir{
        @Test
        @DisplayName("Should throw error when divided to zero")
        void shouldThrowExceptionWhenDividedToZero(){

            int a = 4;
            int b = 0;

            //Act e Assert
            var ex = assertThrows(ArithmeticException.class, () ->{
                calculadora.dividir(4,0);
            });
            assertEquals("Divisão por zero não permitida.",ex.getMessage());
        }

        @Test
        @DisplayName("One number divided by the other should be five")
        void multiplyShouldBeThen(){
            int a = 10;
            int b = 2;

            var output = calculadora.dividir(a,b);

            Assertions.assertEquals(5,output);
        }
    }

    @Nested
    class potencial {
        @Test
        @DisplayName("Should calculate pow correctly")
        void shouldCalculatePowCorrectly(){
            int base = 2;
            int expoente = 2;

            var output = calculadora.potencia(base,expoente);

            Assertions.assertEquals(4,output);
        }
    }

    @Nested
    class raizQuadrada {
        @Test
        @DisplayName("Should throw exception when number is negative ")
        void shouldThrowExceptionWhenNumberIsNegative(){

            int number = -1;

            assertThrows(ArithmeticException.class,()->{
                calculadora.raizQuadrada(number);
            });
        }

        @Test
        @DisplayName("Should calculate sqrt correctly")
        void shouldCalculateSqrtCorrectly(){

            int number = 9;

            var output = calculadora.raizQuadrada(number);

            Assertions.assertEquals(3,output);
        }
    }


    @Nested
    class absoluto {
        @Test
        @DisplayName("Should calculate abs correctly")
        void shouldCalculateAbsCorrectly(){
            int number = -50;

            var output = calculadora.absoluto(number);

            Assertions.assertEquals(50,output);
        }
    }


    @Nested
    class ehPar {
        @Test
        @DisplayName("Should be true ")
        void shouldBeTrue(){
            int number = 4;

            var output = calculadora.ehPar(number);

            Assertions.assertTrue(output);
        }

        @Test
        @DisplayName("Should be false ")
        void shouldBeFalse(){
            int number = 3;

            var output = calculadora.ehPar(number);

            Assertions.assertFalse(output);
        }
    }


    @Nested
    class ehPrimo {
        @Test
        @DisplayName("Should be true when 3 ")
        void shouldBeTrueWhen3() {
            int number = 3;

            var output = calculadora.ehPrimo(number);

            Assertions.assertTrue(output);
        }
        @Test
        @DisplayName("Should be false when 4 ")
        void shouldBeFalseWhen4() {
            int number = 4;

            var output = calculadora.ehPrimo(number);

            Assertions.assertFalse(output);
        }
    }

    @Nested
    class maximo {
        @Test
        @DisplayName("Should be the max number ")
        void shouldBeTheMaxNumber() {
            int a = 3;
            int max = 10;

            var output = calculadora.maximo(a,max);

            Assertions.assertEquals(max,output);
        }

        @Test
        @DisplayName("Should be the min number ")
        void shouldBeTheMinNumber() {
            int min = 3;
            int b = 10;

            var output = calculadora.minimo(min,b);

            Assertions.assertEquals(min,output);
        }
    }
}