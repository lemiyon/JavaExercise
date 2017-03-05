package string;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
/*
 * HackerRank의 문자열 관련 문제 중 CamelCase라는 문제를 해결하기 위한 테스트케이스입니다.
 * CamelCase는, 영문자로만 구성된 문자열에서, 맨 처음 단어를 제외한 연결되는 나머지 단어들은 첫 글자는 대문자, 그가 아니면 소문자로
 * 쓰여지는 케이스입니다. 주어진 문자열에서, 다음 문자열이 CamelCase를 따른다고 했을 떄, 그 문자열은 몇 개의 문자로 되어 있을까요?
 * 단, 첫 단어는 모두 소문자로 구성됩니다.
 * 입력 문자열의 길이는 1에서 10^5까지 입니다.
 * ex) bolaWillBeAProgrammer.
 * 5
 */


public class CamelCaseTest {

	int solution(String input) {
		//한 단어는 무조건 존재하므로, 한 글자라도 대문자가 없다면 바로 1을 반환한다.
		int result = 1; 
		
		//정규표현식을 써서, 대문자의 갯수 + 1(첫 단어는 무조건 소문자다)를 반환하면 될 거 같다.
		Pattern p = Pattern.compile("[A-Z]");
		Matcher m = p.matcher(input);
		
		//매번 찾을 때 마다 결과 값에 1을 더한다. 
		while(m.find()) {
			result++;
		}
		
		return result;
	}
	
	
	//한 단어만 있는 경우 
	@Test
	public void testOneWord() {
		assertTrue(solution("a") == 1);
		assertTrue(solution("bunny") == 1);
	}

	//한개의 글자인 단어가 여러개인 경우, Ex)aAHa
	@Test
	public void testMultipleWordThatHasOnlyOneCharacter() {
		assertTrue(solution("aAHa") == 3);
	}
	
	
	//여러개의 단어로 문장이 구성된 경
	@Test
	public void testMultipleWord() {
		assertTrue(solution("aBunnyIsHoppingOnTheGrass") == 7);
		assertTrue(solution("saveChangesInTheEditor") == 5);
	}
}
