package dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/* 두 번쨰 친구는 링크드 리스트! 이 아이도 Collection의 자식이므로, 관련 함수드릉ㄹ 쓸 수 있
 * 배열과 항상 단짝 친구로 따라다니는, 링크드 리스트에 대해서 정리해 보았다!
 * 링크드 리스트는 각 노드가 포인터로 일자로 주욱 연결되어 있는 자료구조이다.
 * 배열과 달리 논리적으로 연결되어 있기 때문에, 삽입, 삭제, 위치 변경이 쉬운 자료구조이다.
 * 다만, 탐색은 모든 노드를 다 뒤져봐야 하기 때문에 좋은 성능은 아니다.
 * 노드가 앞뒤를 모두 가리키고 있는 더블 링크드 리스트도 잇다.
 * 
 * 
 * 참고로, 큐, 스택, 덱은 자바에서 이제 사라질 것이다. 그를 대체하기 위해서 LinkedList를 사용하라는 권고가 있다.
 * 그래서, 그렇게 사용하기 위한 함수들이 존재한다.
 */


public class LinkedListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		/*
		 * 1. 생성 및 초기화 
		 * 요 녀석도 제네릭을 사용하고 있어서 따로 형을 명시해 줘야 한다잉!
		 * 중요! 제네릭은 오직 객체만 받을 수 있다! 프리미티브는 안된다!
		 */
		LinkedList<Integer> ll; 
		ll = new LinkedList<Integer>();
		System.out.println("Linked List Examples!");
		
		/*
		 * 2. 원소 삽입 
		 */
		
		//add로 1개씩 집어 넣을 수 있다. 가장 최근에 추가된 원소는 기본적으로, 리스트의 끝에 들어간다.
		ll.add(3);
		System.out.println("add(3) : " + ll);
		
		//addLast로 리스트의 끝에 추가할 수 있다. 
		ll.addLast(99);
		System.out.println("addLast(99) : " + ll);
		
		//addFirst로, 리스트의 앞에 추가할 수도 있다. 
		ll.addFirst(11);
		System.out.println("addFirst(11) : " + ll);
	
		//index를 지정해 추가해 줄 수 도 있따.
		ll.add(2, 34);
		System.out.println("add(2, 34) : "+ ll);
		
		//addAll로, Collection을 상속한 목록이라면 한 번에 추가해 줄 수 도 있다. 여기서는 어레이리스트로 해보았다.
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(7);
		a.add(5);
		ll.addAll(a); 
		System.out.println("addAll(ArrayList[7,5]) : " + ll);
		
		//addAll또한 인덱스를 지정해 추가해 줄 수 도 있다.
		ll.addAll(2, a); //주의! a는 리퍼런스 타입이므로, a추가된 원소는 사실 같은 원소들이다. a가 조작되면 같이 바뀌어 버리므로, 그렇게 하지 말것!
		System.out.println("addAll(2 ,ArrayList[7,5]) : " + ll);
		
		/*
		 * 2. 링크드 리스트의 크기, 비었는지 여부 , 비교 
		 */
		
		//크기 확인은 size()
		System.out.println("ll's size() : " + ll.size());
		
		LinkedList<Integer> ll2 = new LinkedList<Integer>();
		//isEmpty()로 비었는지 여부 확인 가능 
		if(ll2.isEmpty()) {
			System.out.println("ll2 is empty!");
		}
		
		//내용 비교하기 & 복사
		//복사본 만들기 
		LinkedList<Integer> ll3 = (LinkedList<Integer>) ll.clone();
		
		//내용 비교!
		//같은 객체인지 비교
		if(ll3 == ll) {
			System.out.println("ll and ll3 is same object");
		}else {
			System.out.println("ll and ll3 is not the same object");
		}
		
		//내용이 같은지 비교 
		//순서도 검사
		if(ll3.equals(ll)) {
			System.out.println("ll3 has same values with ll");
		}
		
		
		/*
		 * 3. 원소 가져오기 & 재설정 하기.
		 */
		
		//index 번호로 해당 인덱스의 원소를 가져올 수 있따.
		//안타갑게도 서브스크립션 연산자는 제공하지 않는다.... (ll[3]이 안됨!)
		System.out.println("get(2) : " + ll.get(2));
		
		//첫번째 원소 가져오기 
		System.out.println("getFirst() : " + ll.getFirst());
		
		//마지막 원소 가져오기 
		System.out.println("getLast() : " + ll.getLast());
		
		//인덱스 가져오기. 첫 번째로 발견되는 인덱스를 가져온다. 없으면 -1을 반환한
		System.out.println("3's index : " + ll.indexOf(3));
		
		//마지막으로 발견되는 인덱스 가져오기 
		System.out.println("5's Last index : " + ll.lastIndexOf(5));
		
		//원소의 존재 여부 확인
		//아래를 주석처리 하면서 확인해 보세요 :)
		ll.add(23);
		
		if(ll.contains(23)) {
		System.out.println("23 is exists");
		}
		else {
			System.out.println("ll doesn't have 23!");
		}
		
		//어떤 Collection의 모든 원소들을 포함하는지 검사.
		//순서까지는 검사할까? 아니요! 순서는 관계 없슴
		//equals는 순서 검사한다!
		Collections.reverse(a);
		//a.add(77); //얘도 주석 풀고 해보세여 :)
		
		if(ll.containsAll(a)) {
			System.out.println("ll has all component of a");
		}else {
			System.out.println("ll doesn't have all of component of a");
		}
		
		/*
		 * Iterator 사용하기 
		 * Iterator는 콜렉션 내 원소를 하나 하나 방문하게 해 줄 수 있는 인터페이스이다!
		 * LinkedList또한 Iterator를 가지고 있다. 사용해 보자!
		 * 다만, 타입은 LinkedList가 사용하는 것과 통일해 줘야 한다!
		 */
	
		Iterator<Integer> it= ll.iterator();
		//hasNext로 모두 다 열거했는지 확인할 수 있다.
		while(it.hasNext()) {
			//Iterator를 통해서 
			Integer i = it.next(); //만약, next에서 더이상 값이 없을 경우, NoSuchElementException 발생!
			//따라서, 위의 hasNext()를 사용해서 사전에 방지해 주는 것이 좋다.
			System.out.println("iterator : " + i);
			
			
			//remove로 Iterator가 현재 가져온 객체를 지울 수 있다.
			if(i == 23) {
				it.remove();
			}
			
		}
		
		System.out.println("23 has removed from ll : " + ll);
		
		//Iterator 상속시, for문에서 : 를 사용해 순회하는 것이 가능하다! 
		//내부적으로, Iterator가 자동으로 얻어지고, 그를 이용해서 순회하느 것입니다.
		for(Integer i : ll) {
			System.out.println("for(:) loop" + i);
		}
		
		

		
		
		/*
		 * 같은 타입 객체 배열로 변경하기 
		 */
		
		//같은 형의 배열로 변경할 수 있다.
		//참고로, Object 배열을 다른 걸로 바꾸는 캐스팅은 되지 않는다! 따라서, 다음과 같은 방법을 사용해야 한다.
		Integer[] array;
		array = ll.toArray(new Integer[ll.size()]);
		System.out.println("toArray : ");
		for(Integer i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		//이의 확장형인 ListIterator도 있다
		
		
		
		/*
		 * LinkedList는 스택, 큐, 덱으로 쓰이기도 한다. 
		 */
		
		//스택처럼 쓰기
		ll.push(19);//맨 앞에 추가 
		System.out.println("push(19) : " + ll);
		Integer pop1 = ll.pop(); //맨뒤 원소 가져오기. 가져온 원소는 리스트에서 빠진다.
		System.out.println(pop1 + " has poped from " + ll);
		
		//큐처럼 쓰기
		ll.add(32); //앞에 추가 
		System.out.println("add(32)" + ll);
		Integer polled = ll.poll(); //맨 앞 원소 가져오기. 리스트에서 빠진다.
		System.out.println(polled + " has polled from" + ll);
		Integer polled2 = ll.pollFirst(); //맨 앞 원소를 가져온다. 위와 같은 효과
		System.out.println(polled2 + " has polled from First" + ll);
		Integer polled3 = ll.pollLast(); //맨 뒤 원소를 가져오고, 리스트에서 뺀다. pop과 같은 효과
		System.out.println(polled3 + " has polled from Last" + ll);
		
		
		//peek : 가져오되, 리스트에서 빼지는 않는다. 만약 없으면 null값을 저장한다.
		Integer peeked1 = ll.peek(); //기본은 머리를 가져온다.
		Integer peeked2 = ll.peekFirst(); //머리
		Integer peeked3 = ll.peekLast(); //꼬리. 맨 마지막 원
		
		System.out.println(peeked1 + " has peeked from" + ll);
		System.out.println(peeked2 + " has peeked from First" + ll);
		System.out.println(peeked3 + " has peeked from Last" + ll);
		
		
		/*
		 * 원소 변경하기
		 */
		//set(인덱스, 새 값) 새 값으로 만들어주고, 이전 값을 반환해 준다.
		Integer bf = ll.set(0, 5);
		System.out.println("set(0, 5) : " + bf);
		System.out.println("before : " + bf );
	
		
		
		/*
		 * 4. 원소 지우기!
		 */
		
		//첫 번쨰 원소를 지운다. 지운 원소는 반환해 준다!
		Integer removed1 = ll.remove(); 
		System.out.println("remove() : " + removed1 + " has removed!");
		System.out.println(ll);
		
		//인덱스를 지정해서 지워 줄 수 도 있다.
		Integer removed2 = ll.remove(3);
		System.out.println("remove(3) : " + removed2 + " has removed!");
		
		//특정 원소를 지정해서 지워 줄 수 도 있다. 
		//성공여부는 Bool반환 
		ll.remove(new Integer(34));//만약, Integer를 쓰고 있다면, 객체인 것을 명확히 해 줄 것!
		//위의 인덱스를 원소로 받는 remove로 혼동 될 수 있따. 그러면 열심히 IndexOutOfBoundsException가 
		System.out.println("remove(34) : " + ll);
		
		//콜렉션에 포함된 원소 들을 모두 지워 줄 수 있다. 여부는 부울로 반환 
		ll.removeAll(a);
		System.out.println("removeall("+ a + ")" + ll);
		
		//clear()으로 텅 비워버릴 수 도 있다.
		ll.clear();
		System.out.println("clear() : "+ ll);
		
		
		
	}
	

}
