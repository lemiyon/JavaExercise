package string;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author gim-yuncheol
 * Origin : https://www.hackerrank.com/challenges/java-anagrams
 * 이 문제를 풀기 위한 클래스 입니다. 
 */
public class AnagramExamer {

	 static boolean isAnagram(String a, String b) {
	      //이 둘을 정렬 시킨 다음, containsEqual을 사용하면 같은 개수의 같은 문자들로만 이루어져 있다는 것을 알 수 잇을 것이다.
		LinkedList<Character> as = new LinkedList<Character>();
		LinkedList<Character> bs = new LinkedList<Character>();
		
		//두 문자열이 길이가 다르면 무조건 아나그램이 될 수 없다. 같은 개수가 아니기 때문이다.
		if(a.length() != b.length()) {
			return false;
		}
		
		//두 문자열을 문자 리스트로 변경한다. 그 뒤에 정렬 하고, 그 두 리스트의 컨텐츠가 같은지 확인한다.
		//이미 위에서 길이가 다른 경우는 걸러지니, a와b의 길이는 같다.
		
		//caseSensitive 하면 안된다고 했다!
		char[] acs = a.toLowerCase().toCharArray();
		char[] bcs = b.toLowerCase().toCharArray();
		
		for(int i = 0 ; i < a.length(); i++ ){
			as.add(acs[i]);
			bs.add(bcs[i]);
		}
		
		//정렬한다.
		Collections.sort(as);
		Collections.sort(bs);
		
		//두 문자 리스트의 컨텐츠가 같은지 확인한다.
		return as.equals(bs);
	 }
}
