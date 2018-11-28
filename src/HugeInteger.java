/**
 * A class to represent huge integers
 *
 * This class is the best class ever
 *
 */
public class HugeInteger {

    //TODO remove the cap
    public static final int HUGE_INT_SIZE = 40;
    private char[] digits;

    /**
     * Initialize a huge interger to 0
     */
    public HugeInteger(){
        this.setToZero();
    }

    /**
     * Initialize a huge integer to String value
     */
    public HugeInteger(String hugeInteger){

        //Start with a zeroed out number
        this.setToZero();

        //Check to make sure the String is valid and set it if so.
        if(hugeInteger.length() < HUGE_INT_SIZE && this.isValidHugeInteger(hugeInteger)){
            //System.out.println("\nIn here and string is: " + hugeInteger);
            char[] stringRep = hugeInteger.toCharArray();
            int i=stringRep.length-1;
            for (char c: stringRep) {
                this.insertDigit(i, c);
                i--;
            }
        }
    }

    /**
     * Zero out the character array
     */
    private void setToZero(){
        this.digits = new char[HUGE_INT_SIZE];
        for(int i = 0; i< HUGE_INT_SIZE; i++){
            this.insertDigit(i, '0');
        }
    }

    /**
     * Get the Character Array from the class
     * @return
     */
    public char[] toCharArray(){
        return this.digits;
    }

    /**
     * Dump your huge integer to a digit only string
     * @return digit only string
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = HUGE_INT_SIZE -1; i>=0; i--){
            sb.append(digits[i]);
        }
        return sb.toString();
    }

    /**
     * Dump your huge integer to a formatted String
     * @return formatted string
     */
    public String toStringCommaFormat(){
        StringBuilder sb = new StringBuilder();
        for(int i=this.largestDigitPosition(); i>=0; i--){
            sb.append(digits[i]);
            if(i%3==0 && i!=0){sb.append(',');}
        }
        return sb.toString();
    }

    /**
     * Check to see if a String is a valid set of digits
     * @param hugeInteger
     * @return
     */
    private boolean isValidHugeInteger(String hugeInteger){
        //TODO check for +/- and ,
        char[] charArray = hugeInteger.toCharArray();
        for (char c: charArray) {
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    /**
     * Insert a digit character into the array.
     * This is the only method to be used to access the digits array.
     * @param digitArrayPos
     * @param digit
     */
    private void insertDigit(int digitArrayPos, char digit){
        //TODO May want to consider '+', '-' and maybe ','
        if(Character.isDigit(digit)){
            this.digits[digitArrayPos] = digit;
        }
    }

    /**
     * Get the largest digit position
     * @return
     */
    private int largestDigitPosition(){
        for(int i = HUGE_INT_SIZE -1; i>=0; i--){
            if(this.digits[i]!='0'){
                return i;
            }
        }
        return 0;
    }

    public void add(HugeInteger hugeInteger){
        char[] addDigits = hugeInteger.toCharArray();

        int carry = 0;  //remainder in here
        //Loop through all the array, beyond largest value is '0' anyway
        for(int i = 0; i< HUGE_INT_SIZE; i++){

        }            //convert the digits to ints and add them with the remainder
        int sum = Character.getNumericValue(addDigits[i]) +
                Character.getNumericValue(this.digits[i]) + carry;
        //First strip out the base 10 value and insert it
        this.insertDigit(i,Character.forDigit(sum%10,10));
        //Any value above 10 is stripped off now and carried forward
        carry = (sum - sum%10)/10;
    }


}
