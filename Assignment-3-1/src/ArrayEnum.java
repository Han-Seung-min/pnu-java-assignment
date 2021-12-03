import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

public class ArrayEnum {
    enum Command{
        ADD,
        LIST,
        SRTA,
        SRTD,
        SUM,
        QUIT,
        INVALID;

        private Command(){}
    }

    enum Order{
        ASC,
        DSC;

        private Order(){}
    }

    public static void main(String[] args) {
        //결과를 담을 list 생성
        int[] values = new int[100];
        int index = 0;

        //scanner 생성
        final Scanner scanner = new Scanner(System.in);

        while (true){
            final Command command = getCommand(scanner); //Command is enum

            //QUIT command exec
            if(command == Command.QUIT){
                System.out.println("Bye!");
                break;
            }

            //command 구분
            switch (command){
                case ADD:
                    final int newValue = getValue(scanner);
                    values[index] = newValue;
                    index++;
                    break;
                case LIST:
                    printList(values, index);
                    break;
                case SRTA:
                    printList(sort(values, index, Order.ASC), index);
                    break;
                case SRTD:
                    printList(sort(values, index, Order.DSC), index);
                    break;
                case SUM:
                    System.out.println(sum(values, index));
                    break;
                default:
                    System.out.println("Invalid Command");
            }
        }

        scanner.close();
    }

    protected static Command getCommand(Scanner scanner){
        String input = scanner.next().toUpperCase();
        Command command;

        switch (input) {
            case "ADD":
                command = Command.ADD;
                break;
            case "LIST":
                command = Command.LIST;
                break;
            case "SRTA":
                command = Command.SRTA;
                break;
            case "SRTD":
                command = Command.SRTD;
                break;
            case "SUM":
                command = Command.SUM;
                break;
            case "QUIT":
                command = Command.QUIT;
                break;
            default:
                command = Command.INVALID;
        }

        return command;
    }

    protected static int getValue(Scanner scanner){
        int input = scanner.nextInt();
        return input;
    }

    protected static void printList(final int[] values, int index){
        for (int i = 0; i < index; i++) {
            System.out.print(values[i]);
            if((i+1) != index){
                System.out.print(" ");
            }
            else{
                System.out.println("");
            }
        }
    }

    protected static int[] sort(final int[] values, int index, Order order){
        Integer[] temps = Arrays.stream(values).boxed().toArray(Integer[]::new);

        if(order == Order.ASC) {
            Arrays.sort(temps, 0, index);
        }
        else if(order == Order.DSC) {
            Arrays.sort(temps, 0, index, Comparator.reverseOrder());
        }
        else {
            //do nothing
        }

        int[] sortedValues = Arrays.stream(temps).mapToInt(Integer::intValue).toArray();
        return sortedValues;
    }

    protected static int sum(final int[] values, int index){
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += values[i];
        }
        return sum;
    }
}
