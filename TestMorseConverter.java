import java.util.Scanner;

public class TestMorseConverter {

    public static void main(String[] args) throws Exception {

        MorseCodeConvert morseCodeConvert;
        //morseCodeConvert = new MorseCodeConvert("NewMorseCodes.txt");
       // morseCodeConvert.printEncodingList();
       // System.out.printf("fsdfsd");


        try {

            morseCodeConvert = new MorseCodeConvert("MorseCodes.txt");

            int choice = 0;

            Scanner scanner = new Scanner(System.in);

            // show menu and prompt for an option
            while (choice != 4) {

                System.out.println("Select one of the following choices: ");
                System.out.printf("%2s1. Print conversion codes.%n", "");
                System.out.printf("%2s2. Convert string.%n", "");
                System.out.printf("%2s3. Convert file.%n", "");
                System.out.printf("%2s4. Exit.%n", "");
                System.out.print("Choice (1-4): ");

                String userInput = scanner.next();

                // error checking
                if (userInput.charAt(0) >= '1' && userInput.charAt(0) <= '4')
                    choice = Character.getNumericValue(userInput.charAt(0));

                scanner.nextLine();

                try {
                    switch (choice) {
                        case 1:
                            morseCodeConvert.printEncodingList();
                            break;
                        case 2:
                            // ensures the convertString method can handle null and empty string inputs
                           // morseCodeConvert.encodeString(null);
                           // morseCodeConvert.encodeString("");
                            System.out.print("Enter line to convert: ");
                            String line = scanner.nextLine();
                            morseCodeConvert.encodeString(line);
                            break;
                        case 3:
                            System.out.print("Enter file name: ");
                            String fileName = scanner.nextLine();
                            morseCodeConvert.encodeFile(fileName);
                            break;
                        case 4:
                            break;
                        default:
                            System.err.printf("%n\"%s\" is not a valid option. Try again!%n%n", userInput);
                    }
                }
                catch (Exception ex) {
                    System.err.println(ex.toString());
                }
            }

            scanner.close();
        }
        catch (Exception e) {

            e.printStackTrace();
        }

        System.out.println("\nProgram terminated");
    }
}
