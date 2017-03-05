package string;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
/*
 * 해커랭크 문자열 문제
 * [A-Za-z !,?._'@]+를 만족하는 영어 문자열이 들어온다. 
 * 저위에서 알파벳을 제외하고, 나머지 스페이스,!,?._'@로 문자열을 나눈 리스트를 출력하시오. 
 */

public class StringTokensTest {

	
	
	String[] solution1(String a) {
		//아래 집합에 속하는 문자가 1개 이상 연속으로 나타날 때도 있으므로, +를 붙여준다.
		String tokens = "[ !,?._'@]+";
		
		//앞 뒤 공백을 없애버린다.
		String trimed = a.trim();
		//성공하긴 하는데... 왜 공백 문자가 한 개로 취급되어서 들어갔을까...
		//아 헐.... 맨 앞의 글자는 무조건 있다고 생각해 버리는거 같다. 그렇다면, 저 위의 다른 문자들도 해당되는지 검사 해 볼 ㅣㄹ요가 있다. 
		/*
		 * Regex	Result
		 * "boo:and:foo"
	:	{ "boo", "and", "foo" }}
	o	{ "b", "", ":and:f" }}

	즉, 2개 이상 구분자 이어진 경우, 그 사이의 빈 칸이 나올 걱정이 있다는 거얌. 빈 문자열은 넣지 않도록 하는 게 좋을 거 같다. 
		 */
		
		
		String[] result = trimed.split(tokens);
		for(String b : result) {
			System.out.println(b);
		}
		return result;
	}
	
	//정규표현식을 사용해 알파벳으로만 이루어진 것들만 찾아서 출력 
	String[] solution2(String a) {
		Pattern p = Pattern.compile("[A-Za-z]+");
		Matcher m = p.matcher(a);
		
		ArrayList<String> results = new ArrayList<String>();
		
		while(m.find()) {
			results.add(m.group());
		}
		String[] result = new String[results.size()];
		results.toArray(result);
		for(String b : result) {
			System.out.println(b);
		}
		return result;
	}
	
	
	@Test
	//빈 칸 하나가 배열의 맨 앞에  추가되는 문제가 있다. 
	public void testSomeFailed1() {
		String a ="           YES      leading spaces        are valid,    problemsetters are         evillllll";
		String[] ans = {
				"YES",
				"leading",
				"spaces",
				"are",
				"valid",
				"problemsetters",
				"are",
				"evillllll"
		};
		String[] result;
		result = solution2(a);
		
		assertEquals(ans.length, result.length);
		assertArrayEquals(ans, result);
	
	}
	
	@Test
	//여기도 위와 비슷한 문제라고 생각된다.
	public void testSomeFailed2() {
		String a = "                a                    ";
		String[] ans = {"a"};
		String[] result;
		result = solution2(a);
		
		assertEquals(ans.length, result.length);
		assertArrayEquals(ans, result);
	
	}
	
	@Test
	public void testStartWithDelimiters() {
		String a = ".a";
		String[] ans = {"a"};
		String[] result;
		result = solution2(a);
		
		assertEquals(ans.length, result.length);
		assertArrayEquals(ans, result);
	} 
	@Test
	public void testOnlyDelimiters() {
		String a = ". @@@@@@@???!!!!.....''''   ____";
		String[] ans = {};
		String[] result;
		result = solution2(a);
		
		assertEquals(0, result.length);
		assertArrayEquals(ans, result);
	}
	
	@Test
	public void test(){
		String a = "He is a very very good boy, isn't he?";
		String[] ans = {
		"He",
		"is",
		"a",
		"very",
		"very",
		"good",
		"boy",
		"isn",
		"t",
		"he"};
		String[] result;
		result = solution2(a);
		
		assertEquals(10, result.length);
		assertArrayEquals(ans, result);
	}

}
