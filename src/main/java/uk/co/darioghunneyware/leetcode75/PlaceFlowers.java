package uk.co.darioghunneyware.leetcode75;

public class PlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0 || n >= flowerbed.length || flowerbed.length == 1) return false;

        int flowers = n;

        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (i == 0) {
                if ((flowerbed[i] == 0 && flowerbed[i+1] == 0)) {
                    flowers--;
                }
            }

            if (flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                flowers--;
            }

            if (i == flowerbed.length - 1) {
                if ((flowerbed[i-1] == 0 && flowerbed[i] == 0)) {
                    flowers--;
                }
            }
        }

        return flowers == 0;
    }

}
