package dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * 자료구조 네 번쨰 아이는 집합 의 대명사, 해쉬 셋입니당! 이녀석은 해쉬로 구현된 셋이라고 생각하면 되요 :)
 * Set은 인터페이스에요!
 * 딕셔너리를 찾는다면, 해쉬맵으로 가세요!
 * 스위프트라면, 셋라고 생각하면 되지 
 * 셋이라는 것은, 수학에서의 집합을 생각하면 될 것입니다. 
 * 중복이 없는 원소들의 무순서 집합!
 * 수학에서의 집합이므로, 집합 연산들을 제공합니다. 드모르간도 잇을까? - 구현해 주면 되지! 
 *
 * 가장 빠른 접근 속도를 제공, 그러나 순서는 정말로 알수 가 없다ㅠㅠ
 */


public class HashSetEx {
	
	public static void main(String[] args) {
		
		/*
		 *1. 생성 및 초기화  
		 */
		HashSet<Integer> hs = new HashSet<Integer>(); 
		
		/*
		 * 2. 원소 추가
		 * 역시나, add와 addAll(콜렉션)으로 나뉘어 있다. 
		 */
		
		
		//add
		hs.add(3);
		System.out.println("add(3) : "+ hs);
		
		//addAll()
		LinkedList<Integer> c = new LinkedList<Integer>();
		c.add(7);
		c.add(12);
		
		hs.addAll(c);
		System.out.println("addAll(" + c + ") : " + hs);
		
		/*
		 * 3. 원소 접근 및 변경 , 삭제
		 */
		
		//HashSet에서는, 원소를 직접 가져오는 방법은 없다!
		//따라서, 다른 List 구현체들을 이용해서 가져와야 한다!
		
		//리스트로 오름차 순으로 정렬해 원소 가져오기
		//List는 선형 자료 구조의 인터페이스다. ArrayList, LinkedList가 이를 상속하고 있다.
		List list = new ArrayList(hs);
		Collections.sort(list);
		System.out.println("hs's contents(by using arrayList) " + list);
		

		//Iterator를 사용해 값을 볼 수 도 있다.
		Iterator<Integer> it = hs.iterator();
		System.out.println("hs's current contents using iterator : ");
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		
		//contains로 해당 원소가 존재하는지 살펴 볼 수 있다.
		int num = 12;
		
		if(hs.contains(num)) {
			System.out.println("hs has " + num + " hs : " + hs );
		}else {
			System.out.println("hs doesn't have " + num);
		}
		
		
		//remove로 삭제 성공 여부를 알 수 있따.
		int delNum = 3;
		if(hs.remove(delNum)) {
			System.out.println("we removed " + delNum + " hs : " + hs);
		}else {
			System.out.println("we coudln't remove " + delNum);
		}
		
	
	}
}
