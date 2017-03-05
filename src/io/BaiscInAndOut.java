package io;

import java.util.Scanner;

public class BaiscInAndOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//입력 받기 
		
		/*
		 * Java.util.Scanner
		 * Scanner로 입력을 받는다.
		 * 가장 느리다. 만약 속도가 중요하다면 주의할 것  
		 * */
		
		//System.in은 키보드에 들어오는 입력을 받는 것이다. 
		Scanner scanner = new Scanner(System.in);
		
		//다양한 자료형을 읽어올 수 있따. 만약, 명시된 자료형과 다르다면 InputMismatch예외 날린다(nextline, next 제외)
		int i1 = scanner.nextInt();
		double d1 = scanner.nextDouble();
		
		String s2 = scanner.next(); //개행문자를 제외하고! 스페이 등, 지정된 디리미터 문자가 나타날때 까지 읽는다. 아래 같이쓸 때 주의! 개행문자를 제외하고 가져온다.
		String s1 = scanner.nextLine(); //다음 줄 문자가 나올 때 까지 읽어 온다. 즉, 엔터문자까지 읽어온다.
		
		/*
		 * 주의! 절대, NextXXX를 사용한 이후, NextLine()은 쓰지 않도록 한다.
		 * NextXXX는 개행문자를 그냥 버려두는 데, 그 다음에 상기의 함수를 쓰면,
		 * 남겨놓았던 개행문자를 하나로 인식하고 빈 문자열을 그냥 받아 들인다.
		 * 따라서, 다음과 같이 쓰는 편이 안전하다 
		 * */
		
		int i2 = Integer.parseInt(scanner.nextLine());
		double d2 = Double.parseDouble(scanner.nextLine());
		String s3 = scanner.nextLine();
		
		/*
		 * 패턴 매칭도 가능하다!
		 */
		
		
		//다음에 입력이 더 있는지 확인할 수 도 있다. 자매품 hasNextLine도 있다.
		//차이점은 그 다음이 단어인지 줄인지다. 한 단어가 있어도 hasNext는 있다고 생각하지만, hasNextLine는 아니다.
		boolean isItEnd1 = scanner.hasNext();
		boolean isItEnd2 = scanner.hasNextLine(); //
		
		
		//다음 단어가 있나?
		if(isItEnd1) {
			System.out.println("Here's more Words!!");
		}
		else {
			System.out.println("There's no more word");
		}
		
		//다음 줄이 있나?
		if(isItEnd2) {
			System.out.println("Here's more Lines!!");
		}
		else {
			System.out.println("There's no more Line");
		}
		
	}

}
