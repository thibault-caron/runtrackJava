package jour01.job00;

public class job00 {
    
    public static void main(String[] args) {

        char character = 'A';
        String string = "Hello Java";
        int integer = 42;
        long longNumber = 9876543210L;
        float floatingNumber = 3.14f;
        boolean isTrue = true;
        
        System.out.println("char: " + character);
        System.out.println("String: " + string);
        System.out.println("int: " + integer);
        System.out.println("long: " + longNumber);
        System.out.println("float: " + floatingNumber);
        System.out.println("boolean: " + isTrue);
        
        // For int TOTO, store 3.817
        int TOTO = (int) 3.817;
        System.out.println("TOTO: " + TOTO);
        
        // 3.817 is truncated to 3 because converting a decimal number
        // to an integer removes the decimal part (truncation)
    }
}