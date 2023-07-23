package day0812;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_11286_절댓값힙 {
	static class PQ2 {
		int[] elements;
		int pos;
		Comparator<Integer>comparator;
		public PQ2() 
		{
			this(null);
		}
		public PQ2(Comparator<Integer> comparator) 
		{
			elements = new int[10+1];
			this.comparator = comparator;
		}
		
		private boolean isFull() {
			return pos == elements.length-1;
		}
		
		@Override
		public String toString()
		{
			if(pos == 0) return "[]";
			StringBuilder sb = new StringBuilder("[");
			sb.append(elements[1]);
			if(pos == 1) return sb.append("]").toString();
			
			for(int i = 2; i <= pos; i++)
			{
				sb.append(", " + elements[i]);
			}
			
			sb.append("]");
			return sb.toString();
		
		}
		public void offer(int data)
		{
			if(isFull()) // 배열이 꽉찼다
			{
				increase();
			}
			elements[++pos] = data;
			
			int idx = pos;
			while(idx > 1 && isSwap(idx / 2, idx))
			{
				// swap
				swap(idx / 2, idx);
				idx = idx/2;
				
			}
		}
		
		private void swap(int i, int j) {
			int temp = elements[i];
			elements[i] = elements[j];
			elements[j] = temp;
		}

		private boolean isSwap(int i, int j) {
			if(comparator != null)
			{
				return comparator.compare(Math.abs(elements[i]), Math.abs(elements[j])) >= 1;
			}
			// 최소힙으로 구현 true면 바꾸고 flase면 안바꾼다
			if(Math.abs(elements[i]) == Math.abs(elements[j]) &&
					elements[i] > elements[j]) return Math.abs(elements[i]) >= Math.abs(elements[j]);
			return Math.abs(elements[i]) > Math.abs(elements[j]);
		}

		// 배열 길이 * 2로 늘려준다
		private void increase()
		{
			elements = Arrays.copyOf(elements, elements.length*2);
		}

		public int poll()
		{
			// 삭제할 데이터가 없으면
			if(pos == 0)
			{
				return 0;
			}
			int result = elements[1];
			
			 elements[1] = elements[pos];
			 elements[pos--] = 0;
			 heapify();
			return result;
		}

		private void heapify() {
			int idx = 1;
			while(idx * 2 <= pos)
			{
				// 자식이 둘다 있는지 확인
				if(pos >= idx * 2 + 1)
				{
					if(!isSwap(idx, idx * 2) && !isSwap(idx, idx * 2 + 1)) break;
				}
				else
				{
					if(!isSwap(idx, idx * 2)) break;
				}
				
				int changeIdx = idx * 2;
				if(pos >= idx * 2 + 1)
				{
					changeIdx = isSwap(idx * 2, idx * 2 + 1) ? idx * 2 + 1 : idx * 2;
				}
				
				swap(idx, changeIdx);
				idx = changeIdx;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PQ2 pq1 = new PQ2();
		
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++)
		{
			int in = sc.nextInt();
			if(in == 0)
			{
				System.out.println(pq1.poll());
			}
			else pq1.offer(in);
		}
		

	}
}
