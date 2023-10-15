package eight_problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cyberpunk6 {
    //данный метод заточен под квадратные подматрицы плюс исключаем размер = 1 и = n
    //в случае произвольных матриц реализация другая
    public static String army_communication_matrix(int n, int [][] matrix) {
        int[][] prefixSumMatrix = fillPrefixSumMatrix(matrix);
        int[] prefixSumArray;
        List<int[]> maxSubmatricesList = new ArrayList<>();
        for (int startCol = 0; startCol < n - 1; startCol++) {
            for (int endCol = startCol + 1; endCol < n && endCol - startCol != n - 1; endCol++) {
                prefixSumArray = fillPrefixSumArray(prefixSumMatrix, startCol, endCol);
                int[] currentMaxSubArray = findMaxSubArrayLengthK(prefixSumArray, endCol - startCol + 1);
                currentMaxSubArray[1] = startCol;
                maxSubmatricesList.add(currentMaxSubArray);
            }
        }
        int [] maxSubMatrix = maxSubmatricesList.stream().max(Comparator.comparingInt(o -> o[0])).get();
        return String.format("%d %d %d", maxSubMatrix[1], maxSubMatrix[2],maxSubMatrix[3]);
    }

    //формирует матрицу с префиксными суммами строк
    private static int[][] fillPrefixSumMatrix(int [][] matrix) {
        int[][] resultMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                resultMatrix[i][j] = j == 0 ? matrix[i][j] : resultMatrix[i][j - 1] + matrix[i][j];
            }
        }
        return resultMatrix;
    }

    private static int[] fillPrefixSumArray(int [][] prefixSumMatrix, int startCol, int endCol) {
        int[] resultArray = new int[prefixSumMatrix.length];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = startCol == 0 ? prefixSumMatrix[i][endCol] : prefixSumMatrix[i][endCol] - prefixSumMatrix[i][startCol - 1];
        }
        return resultArray;
    }

    //Ищем максимальную сумму в окне фикс. размера, так как по условию ищем квадратные подматрицы.
    //В случае произвольных подматриц см. алгоритм Кадана или более очевидную вариацию на минимизацию подсумм
    private static int[] findMaxSubArrayLengthK(int[] prefixSumArray, int k) {
        int[] resultMaxSumAnsIndexes = new int[4];
        int maxSum = 0;
        int startIndex = 0;
        int endIndex = k - 1;
        for (int i = 0; i < k; i++)
            maxSum += prefixSumArray[i];
        int currentSum = maxSum;
        for (int i = k; i < prefixSumArray.length; i++)
        {
            currentSum += prefixSumArray[i] - prefixSumArray[i - k];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                startIndex += i - k + 1;
                endIndex += i - k + 1;
            }
        }
        resultMaxSumAnsIndexes[0] = maxSum;
        resultMaxSumAnsIndexes[2] = startIndex;
        resultMaxSumAnsIndexes[3] = k;
        return resultMaxSumAnsIndexes;
    }
}
