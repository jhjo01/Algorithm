import java.util.*;

class Solution {
    class Date implements Comparable<Date> {
        int year;
        int month;
        int day;
        boolean idx;
        
        public Date(int year, int month, int day, boolean idx) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.idx = idx;
        }      
        
        @Override
        public int compareTo(Date d) {
            // 연도 차이남
            if(this.year > d.year) return 1;
            else if(this.year < d.year) return -1;
            else {
                // 연도같고 월 차이남
                if(this.month > d.month) return 1;
                else if(this.month < d.month) return -1;
                else {
                    // 연도, 월같고 일 차이남
                    if(this.day > d.day || this.day == d.day) return 1;
                    else return -1;
                }
            }
        }
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int nowYear = Integer.parseInt(today.split("\\.")[0]);
        int nowMonth = Integer.parseInt(today.split("\\.")[1]);
        int nowDay = Integer.parseInt(today.split("\\.")[2]);
        
        Map<Character, Date> termDate = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < terms.length; i++) {
            int m = Integer.parseInt(terms[i].split(" ")[1]);
            int year = nowYear;
            int month = nowMonth;
            int day = nowDay;
            
            if(m > 11) {
                year = year - (m / 12);
                m = m % 12;
            }
            
            if(month - m < 1) {
                year = year - 1;
                if(month - m == 0) month = 12;
                else month = 12 - (-1 * (month - m));
            } else month = month - m;
            
            termDate.put(terms[i].charAt(0), new Date(year, month, day, false));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            char type = privacies[i].split(" ")[1].charAt(0);
            int year = Integer.parseInt(privacies[i].split(" ")[0].split("\\.")[0]);
            int month = Integer.parseInt(privacies[i].split(" ")[0].split("\\.")[1]);
            int day = Integer.parseInt(privacies[i].split(" ")[0].split("\\.")[2]);
            if(termDate.get(type).compareTo(new Date(year, month, day, false)) == 1) list.add(i+1);
        }
        
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(0);
            list.remove(0);
        }
        return answer;
    }
}

