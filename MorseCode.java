public class MorseCode {
    private char character;
    private String encoding;
// non default constructor
    //TODO: throw an exception if criteria not met
    MorseCode(){
        this.character = 'a';
        this.encoding = null;

    }
    MorseCode(char character, String encoding)throws Exception{
        //only accepts character values of ASCII codes between 32 and 90
        if(character < 32 || character >  96 ){
            throw new Exception("The character is not a supported Morse Character");
        }
        else {this.character = character;}
        //only accepts encoding values that are not NULL and of length at least one
        if (encoding.equals(null) && encoding.length() < 1){
            throw new Exception("The character is not a supported Morse Character");
        }
        else {this.encoding = encoding;}

    }

    // getters and setters
    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    //gets the string representation of the MorseCode objects
    public String toString() {
        return  this.getCharacter() + "\t"+
                this.getEncoding();
    }
}
