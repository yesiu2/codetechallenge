package pl.wojciechmazurek;

public class Challenge {
    

    public static String mainMethod(String input) {
        char[][] inputArray = makeAnArrayFromInput(input);

        return decodeArray(inputArray);
    }

    private static String decodeArray(char[][] inputArray) {

        int bot = inputArray.length-1;
        int left = 0;
        int up = 0;
        int right = inputArray.length-1;

        StringBuilder sb = new StringBuilder();

        do {

            for (int i = right; i >=left; i--) {
                sb.append(inputArray[bot][i]);

            }
            bot--;

            for (int i = bot; i >=up; i--) {
                sb.append(inputArray[i][left]);
            }
            left++;

            for (int i = left; i <=right; i++) {
                sb.append(inputArray[up][i]);
            }

            up++;

            for (int i = up; i <= bot; i++) {
                sb.append(inputArray[i][right]);
            }

            right--;
        } while (bot != 0 && left != inputArray.length-1 && up != inputArray.length-1 && right != 0);





        return sb.toString();
    }

    private static char[][] makeAnArrayFromInput(String input) {
        int num = (int) Math.sqrt(input.length());

        char[][] array = new char[num][num];

        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = input.charAt(counter);
                counter++;
            }
        }

        return array;
    }
}
