class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.toLowerCase().split(" ");
        
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals("")) {
                answer = answer + " ";
                continue;
            }
            if(arr[i].charAt(0) >= 97 && arr[i].charAt(0) <= 122) {
                answer = answer + arr[i].replaceFirst(String.valueOf(arr[i].charAt(0)), String.valueOf(arr[i].charAt(0)).toUpperCase()) + " ";
                System.out.print(arr[i].charAt(0));
            } else {
                answer = answer + arr[i] + " ";
            }
        }
        
        
        if(s.charAt(s.length()-1) == ' ' && s.charAt(s.length()-2) != ' ') return answer;
        else return answer.substring(0, answer.length()-1);
    }
}