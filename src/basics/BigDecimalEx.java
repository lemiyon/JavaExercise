package basics;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalEx {
/*
 * BigDecimal : 온갖 종류의 포맷과 엄청나게 거대한 크기의 숫자들을 동시에 다루는 10진수들!
 * BigInteger와 다른 점은, 이녀석은 소수점도 지원한다는 것이다. 
 * 참고 : http://stackoverflow.com/questions/13900204/bigdecimal-to-string
 * 내부적으로는 BigDecimal은 들어오는 숫자 표현에  대해서 가장 가까운 double로 변환한다.
 * 그래서, 내가 스트링으로 "0.123"을 넣어준다 한들, double형은 정확하지 않으므로 항상 다른 값이 나온다. 
 * 따라서, 변환한 값을 원래대로 받고 싶다면, valueof
 * 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. 생성 및 초기
		 * BigDecimal는 BigInteger를 포함해서, 어떠한 형태의 숫자로도 초기화 할 수 있다.
		 * BigInteger가 String만 되는 것과는 다르다!
		 */
		
		//long으로 초기화 
		BigDecimal a = new BigDecimal(23423423423423l);
		BigDecimal b= new BigDecimal(324E-91);
		BigDecimal c = new BigDecimal(new BigInteger("123123123123123123"));
		BigDecimal d = new BigDecimal(".0123123"); //값이 깔끔하게 떨어진다.
		BigDecimal e = new BigDecimal(0.0123123); //값이 부정확하다. 위와 값이 같지 않음 주의!! 
		//따라서, 소수점 아래로 내려가는 경우 부동소수점 대신 빅데시멀 사용
		BigDecimal f = new BigDecimal("3");
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		System.out.println("d : " + d);
		System.out.println("e : " + e);
		
		/*
		 * 2. 연산들 
		 * BigInteger와 비슷하게, 온갖 이상한 애들을 다루기 때문에 얘도 기본 연산자로 계산하지 않는다.
		 */
		
		//덧셈
		//add(BigDecimal)
		//주의! float때문에 너무 길어서 입벌어질 수 있ㄷ
		System.out.println(a + " + " + b + " = " + a.add(b));
		
		//뺄셈
		//sub(BigDecimal)
		System.out.println(c + " - " + a + " = " + c.subtract(a));
		
		//곱셈
		//multiply(BigDecimal)
		System.out.println(d + " * " + e + " = " + d.multiply(e));
		
		//나눗셈
		//divide(BigDecimal) 
		//Non-terminating Decimal Expansion - 무한 소수 오류로 ONE으로 바꾸어 계산했다. 원래는 e엿다
		//이래서 부동소수점이 위험한 모양이다.
		System.out.println(d + " / " + BigDecimal.ONE + " = " + d.divide(BigDecimal.ONE));
		
		//이외 모듈로, 반올림 등이 있다. 나중에 차차 채우도록 해
		
		//비교!
		//CompareTo(BigDecimal), Equals(BigDecimal)
		//-1 : 내가 작음 , 0 : 같음 , 1 : 내가 큼
		if(e.compareTo(d) == 1) {
			System.out.println(e + "is bigger than " + d);
		}else if(e.compareTo(d) == 0) {
			System.out.println(e + "is same with " + d);
		}else {
			System.out.println(e + "is smaller than " + d);
		}
	
		
		/*
		 * 3. 출력 문제 
		 */
		
		//세 가지 출력 방법이 있고, 세 가지 다 다르다.
		System.out.println("d.toEngineeringString() : " + d.toEngineeringString());
		System.out.println("d.toPlainString() : " + d.toPlainString());
		System.out.println("d.toString(Standard) : " + d.toString());
		//안타깝게도, 원래 표현으로 돌아가는 건 불가능한 모양이다. 그러니까, 입력값이었던 .123123이라는 스트링으로는.
		
	}

}
