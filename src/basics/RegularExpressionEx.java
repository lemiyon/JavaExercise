package basics;

import java.util.regex.*; //이것을 임포트해야 사용할 수 있따.

public class RegularExpressionEx {

/*
 * 문자열 연산 이라면 피해갈 수 없는, 마성의 정규표현식이다.
 * Regular Expression 
 * 특졍한 규칙을 지닌 문자열의 집합을 표현하는 형식 언어 (사전적정의)
 * 정규표현식에 대해서는 나중에 원노트에 따로 정리하도록 하겠습니당ㅇㅁ
 * 여기서는 JAVA에서 어떻게 사용할 지를 먼저!
 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 자바에서 정규표현식 사용하기 
		 * Patterm, Matcher를 사용해 보자.
		 */
		
		//패턴을 찾을 문자열
		String string = "Chocolate Pie,Pumpkin Pie,Apple Pie,Chocolate Peanut Butter Pie,Cream Cheese Walnut Pie, Peacan Maple Pie";
		//1. Pattern 정규표현식을 생성, 나중에 Matcher가 이 Pattern을 이용해 이에 일치하는 문자열을 찾는다.
		Pattern p = Pattern.compile("(Apple )(Pie)"); //Apple로 시작해 Pie로 끝나는 모든 단어.
		/*
		 * Pattern 설정해 주는 법
		 * Pattern에는 그룹이 존재한다. (물론 리얼 정규표현식에는 없음. 사용을 편하게하기 위해서 자바에서 추가해준 기능)
		 * ()으로 그룹을 설정할 수 있으며, Match시에 그룹을 바꾸어 가면서 매칭할 수 있어, 여러 개의 패턴을 찾아야 할 경우
		 * 편리하게 사용할 수 있다.
		 * 여기서, 그룹 1번은 ^C.*e, 2번은 Pie이다.
		 */
		
		
		//2. Pattern에게 존재하는 Matcher를 불러와, 패턴을 찾을 문자열 손에 쥐어주고 찾으라고 한다.
		Matcher m = p.matcher(string);
		
		//3. while(m.find())로 찾기 시작한다. find는 찾으면 true, 못찾으면 false를 반환한다.
		while(m.find()) {
		//4. m.group(그룹 번호)를 통해서 찾아낸 문자열에 접근할 수 있다.
			//0번은 저 위 2개를 합쳐서 매칭이 되는 것. 이 것이 존재해야 다음 그룹들도 받아올 수 있따.
			//1번 부터는 매칭 되는 것들 중(그룹 0번 중) 1번째 그룹에 매칭되었던 구성 요소를 가져온다. 
			System.out.println(m.group(0) + " group 1 : " + m.group(1) + " group 2 : " + m.group(2));
			
			//매칭된 문자열의 시작위치, 끝 위치를 가져올 수 있다. group 별로도 가져올 수 있따.
			System.out.println("start : "+ m.start() + " end : " + m.end());
		}
		
	}

}
