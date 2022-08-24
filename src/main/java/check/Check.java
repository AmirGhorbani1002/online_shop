package check;

import entity.enums.product.book.BookSubject;
import entity.enums.product.book.BookType;
import entity.enums.product.shoes.Color;
import entity.enums.product.shoes.ShoesType;
import entity.enums.product.tv.DisplayType;

import java.util.Objects;
import java.util.Scanner;

public class Check {

    private final Scanner scanner = new Scanner(System.in);

    public String checkEnums(String input, String type) {
        while (true) {
            if (Objects.equals(type, "display")) {
                try {
                    DisplayType.valueOf(input);
                    return input;
                } catch (RuntimeException e) {
                    System.out.println("Wrong display. LED or LCD or QLED or OLED");
                    input = scanner.next().toUpperCase();
                }
            } else if (Objects.equals(type, "bookType")) {
                try {
                    BookType.valueOf(input);
                    return input;
                } catch (RuntimeException e) {
                    System.out.println("Wrong book type. book or magazine");
                    input = scanner.next().toUpperCase();
                }
            } else if (Objects.equals(type, "bookSubject")) {
                try {
                    BookSubject.valueOf(input);
                    return input;
                } catch (RuntimeException e) {
                    System.out.println("Wrong book subject. action or adventure or comic or horror or fantasy or historical_fiction");
                    input = scanner.next().toUpperCase();
                }
            } else if(Objects.equals(type, "color")){
                try {
                    Color.valueOf(input);
                    return input;
                } catch (RuntimeException e) {
                    System.out.println("Wrong color. black or blue or red or yellow or purple or white");
                    input = scanner.next().toUpperCase();
                }
            } else if(Objects.equals(type, "shoesType")){
                try {
                    ShoesType.valueOf(input);
                    return input;
                } catch (RuntimeException e) {
                    System.out.println("Wrong shoes type. sport or formal or slippers");
                    input = scanner.next().toUpperCase();
                }
            }
        }
    }

    public int checkInt(String input, boolean isZero) {
        while (true) {
            try {
                Integer.parseInt(input);
                if (isZero) {
                    if (Integer.parseInt(input) > 0)
                        return Integer.parseInt(input);
                    else {
                        System.out.println("Integer cannot be negative or zero");
                        input = scanner.next();
                    }
                }
                return Integer.parseInt(input);
            } catch (RuntimeException e) {
                System.out.println("Just Enter integer");
                input = scanner.next();
            }
        }
    }

    public float checkFloat(String input) {
        while (true) {
            try {
                Float.parseFloat(input);
                if (Float.parseFloat(input) > 0)
                    return Float.parseFloat(input);
                else {
                    System.out.println("price cannot be negative or zero");
                    input = scanner.next();
                }
            } catch (RuntimeException e) {
                System.out.println("Just Enter number");
                input = scanner.next();
            }
        }
    }

    public String checkYesOrNo(String input) {
        while (true) {
            if (Objects.equals(input, "yes") || Objects.equals(input, "no"))
                return input;
            System.out.println("Just enter yes or no");
            input = scanner.next();
        }
    }
}
