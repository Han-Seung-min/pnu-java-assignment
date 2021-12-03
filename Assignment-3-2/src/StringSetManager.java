import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StringSetManager {
    static int stringSetLength;

    enum StringCommand{
        ADD, SORT, REMOVE, CLEAN, QUIT, INVALID;
        private StringCommand(){}
    }

    public static void main(String[] args) {
        //scanner, string set 준비
        final Scanner scanner = new Scanner(System.in);
        String[] stringSet = new String[100];
        Arrays.fill(stringSet, "");
        stringSetLength = 0;

        //command 수행
        while(true){
            final StringCommand command = getCommand(scanner);
            if(command == StringCommand.QUIT){
                System.out.println("BYE!"); break;
            }
            switch (command){
                case ADD:{
                    final String str = getString(scanner);
                    add(stringSet, str);
                    break;
                }
                case SORT:{
                    final String order = getString(scanner);
                    sort(stringSet, order);
                    break;
                }
                case REMOVE:{
                    final String str = getString(scanner);
                    remove(stringSet, str);
                    break;
                }
                case CLEAN:{
                    clean(stringSet);
                    break;
                }
                case INVALID:{
                    System.out.println("Invalid Command");
                    break;
                }
                default:{
                    //do nothing
                }
            }
            print(stringSet);
        }

        scanner.close();
    }

    protected static StringCommand getCommand(Scanner scanner){
        String input = scanner.next().toUpperCase();
        StringCommand command;

        switch (input){
            case "ADD":
                command = StringCommand.ADD;
                break;
            case "SORT":
                command = StringCommand.SORT;
                break;
            case "REMOVE":
                command = StringCommand.REMOVE;
                break;
            case "CLEAN":
                command = StringCommand.CLEAN;
                break;
            case "QUIT":
                command = StringCommand.QUIT;
                break;
            default:
                command = StringCommand.INVALID;
        }

        return command;
    }

    protected static String getString(Scanner scanner){
        String input = scanner.next();
        return input;
    }

    protected static void add(String[] stringSet, String str){
        boolean isDuplicate = false;

        for (int i = 0; i < stringSetLength; i++){
            if(stringSet[i].equals(str)){
                isDuplicate = true;
                break;
            }
        }

        if(!isDuplicate) {
            stringSet[stringSetLength] = str;
            stringSetLength++;
        }
    }

    protected static void sort(String[] stringSet, String order){
        String param = order.toUpperCase();
        switch (param){
            case "ASC":{
                Arrays.sort(stringSet, 0, stringSetLength);
                break;
            }
            case "DESC":{
                Arrays.sort(stringSet, 0, stringSetLength, Comparator.reverseOrder());
                break;
            }
            default:{
                //do nothing
            }
        }
    }

    protected static void remove(String[] stringSet, String str){
        boolean isRemoved = false;

        for (int i = 0; i < stringSetLength; i++) {
            if((i+1) == stringSetLength){
                break;
            }

            if(stringSet[i].equals(str) && (isRemoved == false)){
                stringSet[i] = "";
                isRemoved = true;
            }

            if(isRemoved){
                stringSet[i] = stringSet[i+1];
                stringSet[i+1] = "";
            }
        }

        if(isRemoved){
            stringSetLength--;
        }
    }

    protected static void clean(String[] stringSet){
        Arrays.fill(stringSet, "");
        stringSetLength = 0;
    }

    protected static void print(String[] stringSet){
        System.out.printf("Element Size: %d, Values = ", stringSetLength);
        System.out.print("[");

        for (int i = 0; i < stringSetLength; i++) {
            System.out.print(stringSet[i]);
            if((i+1) != stringSetLength){
                System.out.print(", ");
            }
        }

        System.out.print("]");
    }
}
