package basics;

import java.math.BigInteger;

public class BigIntegerEx {
/*
 * Say Hello To BigIntegers :)
 * 
 * BigInteger는 엄청나게 큰 숫자(long int로도 표현 못하는 )들을 오차 없이(부동 소수점의 단점) 다루기 위한 클래스이다.
 * 엄청나게 큰 만큼, 그들은 연산도 보통 +,-이렇게 하지 않는다. 전용 숫자들이 있다! 
 *  
 * 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. 생성 및 초기화 
		 * 숫자 자료형들로는 초기화 할 수 없!!!!!!!
		 */
		
		//문자열로 초기화 할수 있따.
		
		BigInteger a = new BigInteger("11111111111111111"); //1이 겁나 많다. 몇 개인지 세다 까묵
		
		//제공해 주는 상수들 
		//1을 더하고 싶은가? 그냥 1은 안된다! BigInteger 1이 있다!
		BigInteger b = BigInteger.ONE; //
		BigInteger ten = BigInteger.TEN; //10도 있다.
		BigInteger zero = BigInteger.ZERO; //0도 존재한다.  
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("ten : " + ten);
		System.out.println("zero : "+ zero);
		
		//음수 만들기
		//negate(BigInteger)
		BigInteger ng = a.negate();
		System.out.println("-a : " + ng);
		
		
		/*
		 * 2. 연산
		 */
		
		//덧셈 
		//이 세계는 넘나 거대해서, 덧셈도 +가 아니라 특별한 add(BigInteger)라는 함수를 쓴다.
		BigInteger c = a.add(b); 
		System.out.println(a + " + " + b + " = " + c);
		
		//뺄셈
		//subtract(BigInteger)
		BigInteger sub = b.subtract(a);
		System.out.println(b + " - " + a + " = " + sub);
		
		//곱셈
		//multiply(BigInteger)
		BigInteger mul = ten.multiply(a);
		System.out.println(ten + " * " + a + " = " + mul);
		
		//나눗셈
		//당연히, ZERO로 나누는 건 안된다.
		//divide(BigInteger)
		BigInteger div = a.divide(ten);
		System.out.println(a + " / " + ten + " = " + div);
		
		//모듈로 연산 
		BigInteger mod = a.mod(ten);
		System.out.println(a + " % "  + ten + " = " + mod);
		
		//비교!!
		//compareTo(BigInteger e)
		//1 : 내가 더 큼, 0 : 같음, -1 : e가 더 큼
		if(b.compareTo(a) == 1) {
			System.out.println(b + " is bigger than " + a);
		}else if(b.compareTo(a) == 0) {
			System.out.println(b + " is same with " + a);
		}else {
			System.out.println(b + " is smaller than " + a);
		}
		
		//소수점인지 아닌지 알아내는 연산 
		//boolean isProbalbePrime(int certainty)
		//certainty란, 이를 호출하는 BigInteger가 정말로 소수일 확률이다.
		//얘가 내부적으로 밀러-라빈이라는 소수판별 알고리즘을 돌리는 데, certainty는 그 횟수다.
		//높으면 높을 수록, 그가 소수일 확률은 높아진다. 
		//즉, 함수의 반환값이 정확할 확률이 올라가는 것이다. (정확도 1-(1/2)^(certainty))
		//다만, 역시 성능하고 트레이드오프이므로 주의할 것!
		if(b.isProbablePrime(1)) {
			System.out.println(b + "is probably prime");
		}else {
			System.out.println(b + " is definetly not prime");
		}
		
		
		//이외에도 다양한 연산이 있지만, 나중에 정리하도록 하겠다.
	
	}

}
