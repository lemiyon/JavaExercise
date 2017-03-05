package string;

import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

class SuperReducedStringSolution {
	static String solution1(String a) {
		
		StringBuilder s = new StringBuilder(a);
		int index = 0; // 1 <= n <= 100 이므로 커버 가능 
		
		
		//primitive 타입은 equals 안됨!
		
		//잠깐... 괄호문제가 좀 비슷한 거 같기도하고...
		//Solution 2를 참고하세요!
		
		//포인터가 문자열의 마지막 바로 직전의 문자로 가기 전까지 루프를 돈다. 
		while(index < s.length() - 1) {
			//현재 포인터와 그 다음 문자가 같으면 지우고,
			if((index > -1) && (s.charAt(index) ==  s.charAt(index + 1))) {
				s.delete(index, index + 2); // ..<의 범위이다!
				
				//그리고 뒤로 되돌아가, 이번 삭제로 인해서 새로운 Pair가 생겼는지 확인한다.
				// * 아쉬운 점. 여기서 index = 0이 아니라 index--만 하면 되는 거였는ㄷ...스택으로 문제 해결하고 알아
				//아... 여기서 =0이 아니라 --만 하면 되는 거였는데...
				//아쉽다.
				index--;
			}
			else {
				//만약 같지 않으면 다음 문자로 포인터를 옮긴다. 
				index++;
			}
			System.out.println(s);
		}
		
	
		
		if(s.length() == 0) {
			return "Empty String";
		}
		else {
			return s.toString();
		}
		
	}
	
	//스택을 사용한 괄호  문제와 흡사하다는 것을 깨닫고 만들어 보았다.
	static String solution2(String a) {
		String em =  "Empty String";
		
		Scanner sc = new Scanner(System.in);
		String as = sc.nextLine();
		
		LinkedList<Character> l = new LinkedList<Character>();
		//일반적인 스택-괄호 문제처럼 푼다.
		
		
		for(Character c : a.toCharArray()) {
			
			Character peeked;
			if(!l.isEmpty()) {
				//꺼내서 새로 들어오는 아이랑 비교한다.
				peeked = l.peek();
				//같으면, 같이 제거해 버리므로 넣지 말고 pop해 버리면 된다. 
				
				if(!peeked.equals(c)) {
					l.push(c);
				}else {
					//같지 않으면 스택에 넣어준다. 
					l.pop();
				}
				
				
			}
			else {
			//스택이 비어있을 경우는 그냥 넣어 준다.
			l.push(c);
			}
			
		}
		
		if(l.isEmpty()) {
			return em;
		}
		else {
			StringBuilder s = new StringBuilder();
			
			//스택이라 역순 출력이므로, 뒤집어 줘야 한다!
			Collections.reverse(l);
			
			for(Character c : l) {
				s.append(c);
			}
		
			
			System.out.println(s);
			return s.toString();
			}
		
	}
}

public class SuperReducedStringSolutionTest {

	static String em = "Empty String";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testZero() {
		assertTrue(SuperReducedStringSolution.solution1("aaaa").equals("Empty String"));
		assertTrue(SuperReducedStringSolution.solution1("bb").equals("Empty String"));
		
		//조심! 
		assertTrue(SuperReducedStringSolution.solution1("abba").equals("Empty String"));
	}
	
	@Test
	public void testNotZero() {
		assertTrue(SuperReducedStringSolution.solution1("aaabccddd").equals("abd"));
		assertTrue(SuperReducedStringSolution.solution1("a").equals("a"));
	}

}
