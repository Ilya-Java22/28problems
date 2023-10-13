package eight_problems;

import java.util.ArrayList;
import java.util.List;

public class Cyberpunk5 {
    public static int[] matrix(int n, int m, int [][] matrix) {
        List<Integer> resultList = new ArrayList<>(n * m);
        grabMatrixExterior(matrix, 0, m - 1, 0, n - 1, resultList);
        return resultList.stream().mapToInt(x -> x).toArray();
    }

    private static void grabMatrixExterior(int [][] matrix, int topRow, int bottomRow, int leftCol, int rightCol, List<Integer> resultList) {
        if (topRow > bottomRow || leftCol > rightCol) {
            return;
        }
        for (int i = leftCol; i <= rightCol; i++) {
            resultList.add(matrix[topRow][i]);
        }
        for (int i = topRow + 1; i <= bottomRow; i++) {
            resultList.add(matrix[i][rightCol]);
        }
        for (int i = rightCol - 1; i >= leftCol; i--) {
            if (bottomRow == topRow) {
                break;
            }
            resultList.add(matrix[bottomRow][i]);
        }
        for (int i = bottomRow - 1; i >= topRow + 1; i--) {
            if (rightCol == leftCol) {
                break;
            }
            resultList.add(matrix[i][leftCol]);
        }
        grabMatrixExterior(matrix, topRow + 1, bottomRow - 1, leftCol + 1, rightCol - 1, resultList);
    }
}
