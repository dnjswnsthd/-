package Programmers_level1_2;

import java.util.Arrays;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� ��� �׵θ� ȸ���ϱ�

public class Pro_arrRota {
    static int[][] arr;
    public static int[] solution(int rows, int columns, int[][] queries) {
        arr = new int[rows][columns];  // ��� ����
        int[] answer = new int[queries.length]; // ���� �迭
        
        for(int i = 0; i < rows; i++){  // ��� �ʱ�ȭ
            for(int j = 0; j < columns; j++){
                arr[i][j] = i*columns + j + 1;
            }
        }
        for(int i = 0; i < queries.length; i++){ // ȸ���ϰ� �ּڰ� answer�� ����
            answer[i] = rotate(queries[i]);
        }   
        return answer;
    }

    public static int rotate(int[] query) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;
        int tmp = arr[x1][y1];
        int min = tmp;
        for (int i = x1; i < x2; i++) {
            arr[i][y1] = arr[i + 1][y1];
            if (min > arr[i][y1])
                min = arr[i][y1];
        }
        for (int i = y1; i < y2; i++) {
            arr[x2][i] = arr[x2][i + 1];
            if (min > arr[x2][i])
                min = arr[x2][i];
        }
        for (int i = x2; i > x1; i--) {
            arr[i][y2] = arr[i - 1][y2];
            if (min > arr[i][y2])
                min = arr[i][y2];
        }
        for (int i = y2; i > y1; i--) {
            arr[x1][i] = arr[x1][i - 1];
            if (min > arr[x1][i])
                min = arr[x1][i];
        }
        arr[x1][y1 + 1] = tmp;
        return min;
    }
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6, }, { 5, 1, 6, 3 } };
        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }
}
