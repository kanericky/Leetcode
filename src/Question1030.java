import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Question1030 {
    public static void main(String arg[]){

        int[][] array = allCellsDistOrder(2,2, 0, 1);

    }

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        ArrayList<int[]> matrixArrayList = new ArrayList<int[]>();
        int[][] matrix = new int[R*C][];

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                matrixArrayList.add(new int[]{i, j});
            }
        }

        matrixArrayList.sort((o1, o2) -> {
            if(distance(r0, c0, o1[0], o1[1]) > distance(r0, c0, o2[0], o2[1])){
                return 1;
            }else if (distance(r0, c0, o1[0], o1[1]) < distance(r0, c0, o2[0], o2[1])){
                return -1;
            }else{
                return 0;
            }
        });

        for(int i = 0; i < matrixArrayList.size(); i++){
            matrix[i] = matrixArrayList.get(i);
            System.out.println(Arrays.toString(matrix[i]));
        }

        return matrix;
    }

    public static int distance(int r0, int c0, int targetX, int targetY){
        return Math.abs(targetX - r0) + Math.abs(targetY - c0);
    }
}
