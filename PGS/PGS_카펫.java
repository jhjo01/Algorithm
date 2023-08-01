// 참고 https://yeoeun-ji.tistory.com/136
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 1. brown + yello의 약수 구하기
        // 예제1. 10+12 = 4*3
        // 예제2. 8+1 = 3*3
        // 예제3. 24+24 = 8*6
        for(int i=3;i<brown+yellow;i++){
            // 2. 가로는 brown+yello / i
            int width = (brown+yellow)/i; 
            
            // 3. yellow의 개수 = (가로 - 2) * (세로 - 2)로 구할 수 있다.
            // 4. 가로가 세로보다 길고 조건문 yellow=(가로 - 2) * (세로 - 2)를 만족하면 정답
            if(width>=i){
                 if ((i - 2) * (width - 2) == yellow) {
                answer[0] = width;
                answer[1] = i;
                break;
                }
            }
        }
        return answer;
    }
}