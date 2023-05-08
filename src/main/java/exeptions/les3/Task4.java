package exeptions.les3;

public class Task4 {
    public static void main(String[] args) {
        String [][] arr = {{"1", "2", "3", "4"},{"5", "6", "7", "8"},{"9", "10", "11", "12"},{"13", "14", "15", "16"}};
        int sum = 0;
        try{
            sum = matrixSum(arr);
        } catch (MyArrayDataException  | MyArraySizeException exception ){
            System.out.println(exception.getMessage());
        }finally {
            System.out.println(sum);
        }

    }
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    private static int matrixSum(String[][] matrix) throws MyArraySizeException, MyArrayDataException{
        if (matrix.length != 4 || matrix[1].length != 4){
            throw new MyArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(isNumeric(matrix[i][j])){

                    sum += Integer.parseInt(matrix[i][j]);
                }else {
                    throw new MyArrayDataException(i, j);
                }
            }

        }


        return sum;
    }
}
