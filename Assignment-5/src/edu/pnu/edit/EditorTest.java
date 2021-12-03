package edu.pnu.edit;

import java.util.Scanner;
import edu.pnu.shape.*;

enum Command {
    ADDR,
    ADDC,
    LIST,
    CLEAR,
    QUIT,
    INVALID
}
public class EditorTest {
    private static Editor editor = new Editor();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        while (true){
            final Command cmd = getCommand(scanner);
            if(cmd == Command.QUIT){
                System.out.println("Bye"); break;
            }
            if(cmd == Command.INVALID){
                System.out.println("Invalid Operation!"); continue;
            }
            switch (cmd){
                case ADDR : {
                    final Rectangle newRectangle = createRectangle(scanner);
                    System.out.println(newRectangle);
                    editor.add(newRectangle); break;
                }
                case ADDC : {
                    final Circle newCircle = createCircle(scanner);
                    System.out.println(newCircle);
                    editor.add(newCircle); break;
                }
                case CLEAR : editor.clear(); break;
                case LIST : editor.list(); break;
                default : break;
            }
        }
        scanner.close();
    }

    private static Circle createCircle(final Scanner scanner){
        final int x = scanner.nextInt();
        final int y = scanner.nextInt();
        final int radius = scanner.nextInt();

        final Circle newCircle = new Circle(new Point(x,y), radius);
        return newCircle;
    }

    private static Rectangle createRectangle(final Scanner scanner){
        final int x1 = scanner.nextInt(); final int y1 = scanner.nextInt();
        final int x2 = scanner.nextInt(); final int y2 = scanner.nextInt();

        final Rectangle newRectangle = new Rectangle(x1, y1, x2, y2);
        return newRectangle;
    }

    private static Command getCommand(Scanner scanner){
        System.out.print("Enter Operation String!");
        final String operation = scanner.next();

        Command kind;
        try{
            kind = Command.valueOf(operation.toUpperCase());
        }
        catch (IllegalArgumentException e){
            kind = Command.INVALID;
        }
        return kind;
    }
}
