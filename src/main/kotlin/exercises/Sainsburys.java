package exercises;

public class Sainsburys {
    public String gen(int input) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */
        if (input == 1) {
            return "1,2,3,4,5,6,7,8,9";
        }


        String result = "";

        generateNumbers("", input, '1', result);

        return result.substring(0, result.length()-1);
    }

    private void generateNumbers(String current, int n, char startChar, String result) {
        if (current.length() == n) {
            result += current + ",";
            return;
        }

        for (char currentChar = startChar; currentChar <= '9'; currentChar++) {
            generateNumbers(current + currentChar, n, currentChar, result);
        }
    }
}
