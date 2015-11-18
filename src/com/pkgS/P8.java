package com.pkgS;

public class P8 {

    public static void main(String[] args) {
        char arr[][] = {
                {'E', 'C', 'C', 'C', 'C'},
                {'C', '#', 'C', '#', 'E'},
                {'#', 'C', 'C', '#', 'C'},
                {'C', 'E', 'E', 'C', 'E'},
                {'C', 'E', '#', 'C', 'E'},};

        P8 test = new P8();
        int maxCakes = test.collectCakes(arr, 0, 0, true);
        System.out.println("Maximum cakes Raghav can collect is :" + maxCakes);

    }

    private int collectCakes(char[][] arr, int i, int j, boolean dir) {
        if (!isValid(arr, i, j)) {
            return 0;
        }

        int count = 0;

        //Right
        if (dir) {
            count = Math.max(collectCakes(arr, i, j + 1, dir), collectCakes(arr, i + 1, j, !dir));
        }
        //Left
        else {
            count = Math.max(collectCakes(arr, i, j - 1, dir), collectCakes(arr, i + 1, j, !dir));
        }

        if (arr[i][j] == 'E') {
            return count;
        }
        return 1 + count;
    }

    private boolean isValid(char[][] arr, int i, int j) {

        int m = arr.length;          //ROW
        int n = arr[0].length;       //COL

        return i >= 0 && i < m && j >= 0 && j < n && arr[i][j] != '#';
    }
}
