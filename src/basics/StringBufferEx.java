package basics;

/*
 * 기본적인 스트링 클래스 사용해보기!
 * String과달리, mutable하고 연산을 다양하게 사용할 수 있는 StringBuffer!
 * StringBuilder도 같은 역할을 하나, StringBuilder의 경우는 동기화를 제공하지 않ㅇ는다. 좀 더 빠른 셈
 * 따라서, StringBuilder는 따로 하지 않았다!!
 * 이 녀석은 동기화를ㄹ 제공한다!
 */

public class StringBufferEx {

	public static void main(String[] args) {
		
		/*
		 * Salute! StringBuffer 클래스의 사용법!
		 * String이 불변(immutable)임에 반해, StringBuffer는 다양한 연산과 변형을 지원함!
		 * 다만, 그런 만큼 무거우니, 연산과 변형이 별로 없을 때 String을 사용하자! 
		 * 대부분의 함수 (length() 등)은 동일하니, 다른 부분만 하도록 한다!
		 */
		
		/*
		 * 1. StringBuffer class
		 */
		
		//1. 생성 및 초기화
		StringBuffer a = new StringBuffer("Hello!"); //상수 초기화는 안 된다.
	
		String basic = "I'm";
		StringBuffer sb = new StringBuffer(basic); //String으로 생성 가		
		//toString으로, String으로 변환이 가능하다. 
		String st = sb.toString();
		
		//당황하지 말자! isEmpty가 없으면 length()를 스면 된다.
		System.out.println("sb's length : " + sb.length() );
		StringBuilder sbb = new StringBuilder();
		System.out.println("sbb;s length : " + sbb.length());
		
		
		System.out.println(a);
		System.out.println(st);
		
		/*
		 * 2. append
		 * 문자열 끝에 문자열을 더해준다. 모든 기본형, String, 심지어 객체(description으로 변환해)까지 가능하
		 */
		
		String b = "World!";
		a.append(b);
		
		System.out.println(a);
		
		/*
		 * 3. insert(int offset, 인자 xxxx)
		 * 원하는 자리에 문자열을 추가시켜준다. 물론, 다양한 타입과 객체 모두 가능하다.
		 * 객체는 그 description이 들어간다!
		 */
		
		a.insert(0, "Hello! ");
		System.out.println(a);
		
		/*
		 * 4. delete
		 * delete(int start, int end), deleteAtChar(int offset)
		 * 말 그대로 지워 준다.
		 */
		
		//1. delete(int start, int end) : start부터 end 바로 전 까지 지워준다.( ..< )
		a.delete(0, 6);
		System.out.println(a);
		//2. deleteChatAt(int offset) : offset자리의 문자를 지워준다.
		a.deleteCharAt(0);
		System.out.println(a);
		
		/*
		 * 5. replace(int start, int end, String str)
		 * String의 replace와 사용법은 같다. start부터 end자리까지 str로 바꾸어 준다.
		 * str이 더 길면, end이후의 문자열은 보존하고 이어붙인다.
		 */ 
		
		a.replace(0, 5, "LaLaLaLaLa");
		System.out.println(a);
		
		/*
		 * 6. reverse
		 * 문자열을 뒤집어 준다. 팰린드롬을 만들때 효과적이다.
		 */
		
		a.reverse();
		System.out.println(a);
	}
}
