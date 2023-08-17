class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }
    
    public int dfs(int[] numbers, int cnt, int sum, int target) {
        if(cnt == numbers.length) return sum == target ? 1 : 0;
        return dfs(numbers, cnt + 1, sum + numbers[cnt], target) + dfs(numbers, cnt + 1, sum - numbers[cnt], target);
    }
}