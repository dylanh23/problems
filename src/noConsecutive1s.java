import java.util.*;

/**
 * Created by dhare on 6/2/2017.
 */
public class noConsecutive1s {


    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        int smaller = 0;
        for (; i < intervals.size(); i++) {
            if (newInterval.start >= intervals.get(i).start && newInterval.start <= intervals.get(i).end) {
                break;
            } else if (newInterval.end >= intervals.get(i).start && newInterval.end <= intervals.get(i).end) {
                smaller = 1;
                break;
            } else if (newInterval.start <= intervals.get(i).start && newInterval.end >= intervals.get(i).end) {
                smaller = -1;
                break;
            }
        }
        if (i == intervals.size()) {
            intervals.add(newInterval);
            Collections.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval o1, Interval o2) {
                    return Integer.compare(o1.start, o2.start);
                }
            });
            return intervals;
        }
        if (smaller == 1)
            intervals.get(i).start = newInterval.start;
        else if (smaller == -1) {
            intervals.get(i).start = newInterval.start;
            intervals.get(i).end = newInterval.end;
        } else
            intervals.get(i).end = Math.max(intervals.get(i).end, newInterval.end);
        int j = i + 1;
        while (j < intervals.size()) {
            if (newInterval.end >= intervals.get(j).start) {
                intervals.get(i).end = Math.max(intervals.get(j).end, newInterval.end);
                intervals.remove(j);
            } else {
                break;
            }
        }
        return intervals;
    }

    public List<String> generateParenthesis(int n) {
        return dp(n / 2, n);
    }

    List<String> dp(int numPositive, int total) {
        List<String> ans = new ArrayList<>();
        if (total == 0) {
            ans.add("");
            return ans;
        }
        for (String s : dp(numPositive - 1, total - 1)) {
            ans.add(s + "(");
        }
        if ((total - 1) - numPositive > 0)
            for (String s : dp(numPositive, total - 1)) {
                ans.add(s + ")");
            }
        return ans;
    }

    public static int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int[] nums = new int[ratings.length];
        Arrays.fill(nums, 1);
        for (int i = 1; i < ratings.length - 1; i++) {
            if (ratings[i] > ratings[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                nums[i - 1] = Math.max(nums[i] + 1, nums[i - 1]);
            }
        }
        int ans = 0;
        for (int num : nums) {
            ans += num;
        }
        return ans;
    }

    public static void main(String[] args) {
//        List<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(1, 5));
//        insert(intervals, new Interval(0, 6));
//        dp(3)
    }
}

