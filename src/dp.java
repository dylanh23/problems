public class dp {
    public static void main(String[] args) {
        int[] v = {1,3,5,77,98};
        int sum = 82039482;
        int[] min = new int[sum + 1];
        for (int i = 0; i < min.length; i++)
            min[i] = Integer.MAX_VALUE;
        min[0] = 0;
        for (int i = 1; i <= sum; i++)
            for (int j = 0; j < v.length; j++)
                if (v[j] <= i && min[i-v[j]] + 1 < min[i])
                    min[i] = min[i - v[j]] + 1;
        System.out.print(min[sum]);
        int counter = 0;
        for (int j = v.length - 1; j >= 0; j--)
            while (sum - v[j] >= 0) {
                sum -= v[j];
                counter ++;
            }
        System.out.print(counter);
    }
}
