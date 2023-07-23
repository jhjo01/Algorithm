import java.util.Scanner;

public class D3_14413 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int col = sc.nextInt();
			int row = sc.nextInt();
			
			sc.nextLine();
			
			String[] map = new String[col];	// 입력을 받을 배열
			
			int colBlack = 0;	// 검은색 열이 홀수면 1 짝수면 2
			int colWhite = 0;	// 흰색 열이 홀수면 1 짝수면2
			
			int ans = 1;
			
					
			// 입력
			for(int i = 0; i < col; i++)
			{
				map[i] = sc.nextLine();
			}
			
			// 입력 확인
//			for(int i = 0; i < col; i++)
//			{
//					System.out.println(map[i]);
//			}
			
			// 지정 색깔 위치 파악
			// 검정 1 흰색 2
			outer : for(int i = 0; i < col; i++)
			{
				colBlack = 0;
				colWhite = 0;
				if(ans == 0) break;
				// 검은색 확인
				if(colBlack == 0) // 아직 발견 못했고
				{
					if(map[i].indexOf("#") > -1) // 발견을 했을 때
					{
						if(map[i].indexOf("#") % 2 == 1) colBlack = 1; // 홀수면 1
						else colBlack = 2; // 짝수면 2
						//System.out.println("# 발견 " + i + "" + map[i].indexOf("#") + " " + colBlack);
					}
				}
				
				// 흰색 확인
				if(colWhite == 0) // 아직 발견 못했고
				{
					if(map[i].indexOf(".") > -1) // 발견을 했을 때
					{
						if(map[i].indexOf(".") % 2 == 1) colWhite = 1; // 홀수면 1
						else colWhite = 2; // 짝수면 2
						//System.out.println(". 발견 " + i + "" + map[i].indexOf(".") + " " + colWhite);
					}
				}
					
					
				
				switch(colBlack)
				{
				case 1: // 홀수
					for(int j = 0; j < col; j++) // 전체 배열 탐색
					{
						for(int k = 0; k < row; k++)
						{
							char rowCheck = map[j].charAt(k);
							
							if(rowCheck == '#') // 발견
							{
								//System.out.println("발견 행 " + j);
								if(i % 2 == j % 2) // 최초 발견 행이랑 비교 행이랑 홀수 짝수 같은지 확인
								{
									//System.out.println("같은 행 ");
									if(k % 2 == 0) // 열의 홀수짝수 값은 case 와 같은 값이어야함
									{
										ans = 0;
										continue outer;
									}
								}
								else
								{
									//System.out.println("다른 행 ");
									if(k % 2 == 1)
									{
										ans = 0; // 열의 홀수짝수 값은 case 와 다른 값이어야험
										continue outer;
									}
									
								}
							}
							else if(rowCheck == '.')
							{
								if(i % 2 == j % 2) // 최초 발견 행이랑 비교 행이랑 홀수 짝수 같은지 확인
								{
									//System.out.println("같은 행 ");
									if(k % 2 == 1) // 열의 홀수짝수 값은 case 와 같은 값이어야함
									{
										ans = 0;
										continue outer;
									}
								}
								else
								{
									//System.out.println("다른 행 ");
									if(k % 2 == 0)
									{
										ans = 0; // 열의 홀수짝수 값은 case 와 다른 값이어야험
										continue outer;
									}
									
								}
							}
							
							
							
						}
					}
					break;
					
					
				case 2: // 짝수
					for(int j = 0; j < col; j++) // 전체 배열 탐색
					{
						for(int k = 0; k < row; k++)
						{
							char temp = map[j].charAt(k);
							if(temp == '#') // 발견
							{
								//System.out.println("발견 행 " + j);
								if(i % 2 == j % 2) // 최초 발견 행이랑 비교 행이랑 홀수 짝수 같은지 확인
								{
									//System.out.println("같은 행 ");
									if(k % 2 == 1) 
									{
										ans = 0;
										continue outer;
									}
								}
								else
								{
									//System.out.println("다른 행 ");
									if(k % 2 == 0)
									{
										ans = 0; 
										continue outer;
									}
									
								}
							}
							else if(temp == '.') // 발견
							{
									//System.out.println("발견 행 " + j);
									if(i % 2 == j % 2) // 최초 발견 행이랑 비교 행이랑 홀수 짝수 같은지 확인
									{
										//System.out.println("같은 행 ");
										if(k % 2 == 0) 
										{
											ans = 0;
											continue outer;
										}
									}
									else
									{
										//System.out.println("다른 행 ");
										if(k % 2 == 1)
										{
											ans = 0; 
											continue outer;
										}
										
									}
							}
						}
					}
					break;
				}
			
				switch(colWhite)
				{
				case 1: // 홀수
					for(int j = 0; j < col; j++) // 전체 배열 탐색
					{
						for(int k = 0; k < row; k++)
						{
							char temp = map[j].charAt(k);
							if(temp == '.') // 발견
							{
								//System.out.println("발견 행 " + j);
								if(i % 2 == j % 2) // 최초 발견 행이랑 비교 행이랑 홀수 짝수 같은지 확인
								{
									//System.out.println("같은 행 ");
									if(k % 2 == 0) 
									{
										ans = 0;
										continue outer;
									}
								}
								else
								{
									//System.out.println("다른 행 ");
									if(k % 2 == 1) 
									{
										ans = 0; 
										continue outer;
									}
									
								}
							}
							else if(temp == '#') // 발견
								{
									//System.out.println("발견 행 " + j);
									if(i % 2 == j % 2) // 최초 발견 행이랑 비교 행이랑 홀수 짝수 같은지 확인
									{
										//System.out.println("같은 행 ");
										if(k % 2 == 1) 
										{
											ans = 0;
											continue outer;
										}
									}
									else
									{
										//System.out.println("다른 행 ");
										if(k % 2 == 0) 
										{
											ans = 0; 
											continue outer;
										}
										
									}
								}
							}
						}
					break;
					
					
					
				case 2: // 짝수
					for(int j = 0; j < col; j++) // 전체 배열 탐색
					{
						for(int k = 0; k < row; k++)
						{
							char temp = map[j].charAt(k);
							if(temp == '.') // 발견
							{
								//System.out.println("발견 행 " + j);
								if(i % 2 == j % 2) // 최초 발견 행이랑 비교 행이랑 홀수 짝수 같은지 확인
								{
									//System.out.println("같은 행 ");
									if(k % 2 == 1) 
									{
										ans = 0;
										continue outer;
									}
								}
								else
								{
									//System.out.println("다른 행 ");
									if(k % 2 == 0)
									{
										ans = 0; 
										continue outer;
									}
									
								}
							}
							else if(temp == '#') // 발견
							{
								//System.out.println("발견 행 " + j);
								if(i % 2 == j % 2) // 최초 발견 행이랑 비교 행이랑 홀수 짝수 같은지 확인
								{
									//System.out.println("같은 행 ");
									if(k % 2 == 0) 
									{
										ans = 0;
										continue outer;
									}
								}
								else
								{
									//System.out.println("다른 행 ");
									if(k % 2 == 1)
									{
										ans = 0; 
										continue outer;
									}
									
								}
							}
						}
					}
					break;
				}
			}
			
			
			
			
			
			if(ans == 0) System.out.println("#" + test_case + " impossible");
			else System.out.println("#" + test_case + " possible");
			
		}
		
		
	}

}
