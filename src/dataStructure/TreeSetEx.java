package dataStructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * TreeSet 사용 예제
 * 트리셋은 셋의 일종으로, 트리 형태로 구현된 셋이라 출력 시 오름차 순서를 가지고 나온다.
 * 정렬 방법은 지정해 줄 수 있다! Iterator를 사용해 주면 된다.
 * 셋이랑 같이 사용될 예정
 * 
 * 우선 셋이란, 중복이 되지 않는 원소들의 무순서 집합이다.
 * 그러나, 트리셋은 트리로 그 구현이 되어 있어, 원한다면 순서대로 출력하는 것도 가능은 하다.
 */

public class TreeSetEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. 생성 및 초기
		 */
		TreeSet<Integer> treeset1; //레퍼런스 선언은 언제나 똑같다. 
		treeset1 = new TreeSet<Integer>(); //빈 트리셋 생성 및 초기화 
		treeset1.add(6);
		treeset1.add(11);
		treeset1.add(7);
		
		
		//다른 리스트들을 통해 TreeSet을 만드는 것도 가능하다.
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(10);
		list.add(11);
		list.add(9);
		list.add(3);
		list.add(7);
		list.add(1);
		list.add(6);
		list.add(5);
		System.out.println("before treeset : " + list);
		
		//중복이 없음을 알 수 있다.
		TreeSet<Integer> ts = new TreeSet<Integer>(list);
		System.out.println("Treeset : " + ts);
		
		/*
		 * 2. 원소 접근 및 변경
		*/
		//참고!! 트리셋은 저장되면서 바로 오름차순으로 정렬되게 되어 있다!
		Iterator<Integer> it = ts.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		
		
		//거꾸로 가져오기
		System.out.println("Decending order");
		Iterator<Integer> dit = ts.descendingIterator();
		while(dit.hasNext()) {
			System.out.print(dit.next() + " ");
		}
		System.out.println();
		
		
		/*
		 * NavigableSet인터페이스에 속하는 메소드들
		 * java6에서 NavigableSet이라는 인터페이스가 추가되면서 생겨났다.  
		 * 이를 통해서, 이를 상속한 셋들에게 신기한 기능이 여럿 생겼다.
		 * 이들은 보통 원소의 접근에 관련된 내용이다!
		 */
		
		//셋을 내림차순으로 재정렬하기 
		//ns의 원소를 건드리면 ts의 원소들도 영향을 받는다!
		//거꾸로 하려면, Collections.reverse와 똑같은 
		NavigableSet<Integer> ns = ts.descendingSet();
		System.out.println("DescendingSet : "+ ns);
		
		//first, pollFirst : 첫번째 원소, 즉, 가장 작은 원소를 가져온다(기본적으로 트리셋은 오름차순으로 정렬되어 있다!)
		//참고로, pollFirst는 그를 제거해 버린다!
		System.out.println("first(): " + ts.first() + " ts : " + ts);
		int pf = ts.pollFirst();
		System.out.println("pollFirst() : " + pf + " ts :" + ts);
		
		//last, pollLast : 위와 반대, 가장 큰 원소이자 가장 끝 원소를 가져온다. 
		System.out.println("last(): " + ts.last() + " ts : " + ts);
		int pl = ts.pollLast();
		System.out.println("pollLast() : " + pl + " ts :" + ts);
		
		//floor(원소) 입력으로 넣어준 수보다 작은 수 중 가장 큰 수를 가져온다.
		System.out.println("floor(6) : " + ts.floor(6));
	
		//lower(e) : e보다 작은 수(같은 수는 안된다!) 중 가장 큰 수를 반환한다.
		System.out.println("lower(6) : " + ts.lower(6));
		
		//celling(e) : e보다 같거나 큰 수 중 가장 작은 수를 반환한다. 
		System.out.println("ceiling(9) : " + ts.ceiling(9));
		
		//higher(e) : e보다 큰 수(같은 수는 안된다!) 중 가장 작은 수를 반환한다.
		System.out.println("higher(9) : " + ts.higher(9));
		
		//headSet(toElement,  boolean isInclusive) : toElement보다 큰 값들의 셋을 반환한다. 
		//isInclusive가 true인 경우만 같은 수도 포함 
		//isInclusive가 없는 동명의 경우, 같은 수를 포함하지 않는다.
		Set sb = ts.headSet(6);
		System.out.println("headSet(6) : " + sb);
		
		//subset(fromElement, fromInclusive, toElement, toInclusive)
		//fromElement < e < toElement인 모든 원소 e의 셋을 반환한다.
		//아.. 집합 연산자가 필요해. 이래서 수학이 언어 중 하나라는 거군.
		//fromInclusive가 true여야 fromElement와 같은 수도 포함, 
		//그와 같이 toInclusive가 true 여야 toElemetn와 같은 수도 포함된다. 
		//[ e > fromElement && e < toElement | e in Set]
		Set sb1 = ts.subSet(6, true, 10, true);
		System.out.println("subSet(6, true, 10, true) : " + sb1);
		
		//tailSet(fromElement, boolean isInclusive) : toElement보다 같거나 작은 값들의 셋을 반환한다.
		//마찬가지로, isInclusive가 false여야만 그 값을 포함하지 않느다!
		//즉, 기본값은 포함!
		Set sb2 = ts.tailSet(3);
		System.out.println("tailSet(3) : " + sb2);
		
		/*
		 * 원소 지우기 
		 */
		
		//remove(Object o) 성공 여부만 반환한다.
		ts.remove(6);
		System.out.println("remove(6) : " + ts);
		
		//removeAll(Collections c) c내에 있는 모든 요소 중, ts내의 원소들을 지운다.
		//만약, 건너온 c가 Set이라면, 차집합으로 바뀐다.
		//즉, S - C(집합 연산)이 된다.
		
		System.out.println("treeset1 : " + treeset1);
		ts.removeAll(treeset1);
		System.out.println("removeAll(treeset1) : " + ts);
	
	}

}
