import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConvert {
   private ArrayList<MorseCode> listMorseCodes = new ArrayList<MorseCode>();// holds objects of type MorseCode Which then holds character and encoding

    MorseCode Morse1 = new MorseCode();
//TODO For skipped lines, print the message 𝐼𝑛𝑣𝑎𝑙𝑖𝑑 𝑙𝑖𝑛𝑒: ≪ 𝑡ℎ𝑒 𝑠𝑘𝑖𝑝𝑝𝑒𝑑 𝑙𝑖𝑛𝑒 ≫ and continue with the next line

    MorseCodeConvert(String FileName) throws Exception {

        Scanner sc = null;
        try{
            String morseChar; //holds all the characters but in type string
            String morseEnc; // holds encoding
            char morseChar2; //converts ch into char type

            sc = new Scanner(new File(FileName));
            String line;
            while(sc.hasNext()){
                line = sc.nextLine();
                if (line.isEmpty()|| !line.contains("\t")) {// do not read empty lines or line without two entries seperated by tab
                    System.out.printf("Invalid line: %s%n",line);
                    continue;
                }
                String[] arr = line.split("\t");
                morseChar = arr[0];
                morseChar2 = morseChar.charAt(0);
                morseEnc = arr[1];
                Morse1 = new MorseCode(morseChar2,morseEnc);
                listMorseCodes.add(Morse1);
            }
        }

        catch(FileNotFoundException e){
            System.out.printf("Failed to open the file:",FileName);
        }
        finally{
            if (sc != null){
                sc.close();
            }
        }
        }

    // prints every line in arraylist
    public void printEncodingList(){
        for(int i = 0; i < listMorseCodes.size(); i++){
            System.out.printf("%s%n",listMorseCodes.get(i));
        }
    }

    //gets the index of the object containing a specific character in the arraylist
    public int getIndex(Character itemName )
    {
        for(int i = 0; i< listMorseCodes.size(); i++){
            Morse1 = listMorseCodes.get(i);
            if(itemName.equals(Morse1.getCharacter())){
                return i;
            }
        }
        return -1;
    }

    //  takes a string and converts every letter in the string into type char, find its location in the arraylist and prints out its encoding
    public void encodeString(String toBeEncoded){
        char x; //holds converted string
        char z; //holds converted string after its been converted to uppercase
        int y; //holds the index of char z in arraylist

        // this loop converts every letter in input string to char and prints out the encoding
        for (int i = 0; i < toBeEncoded.length(); i++) {
            x = toBeEncoded.charAt(i);
            z = Character.toUpperCase(x);
            if(z == ' '){//if a space is encountered, meaning end of the word, its encoded into a "/"
                System.out.printf("/");
                continue;
            }
            if(z < 32 || z>90){// if an invalid character is encountered, print "?"
                System.out.printf("?");
                continue;
            }
           y=getIndex(z);

        System.out.printf(listMorseCodes.get(y).getEncoding());
        System.out.printf(" ");// puts a space after every Morse code character for easier reading
        }
        System.out.println();
        // letters are seperated by space and words are seperated by "/"t
    }

    //encodes entire file
    public void encodeFile(String fileName2)throws Exception{
        Scanner sc = null;
        try {

            sc = new Scanner(new File(fileName2));
            String line2;
            while (sc.hasNext()) {
                line2 = sc.nextLine();
                encodeString(line2);
            }
        }
        catch(FileNotFoundException e){
            System.out.printf("Failed to open the file:",fileName2);
        }
        finally{
            if (sc != null){
                sc.close();
            }
        }
    }

}
