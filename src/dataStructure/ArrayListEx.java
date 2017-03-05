package dataStructure;

//ArrayList, Vector를 
import java.util.ArrayList;
import java.util.Vector;

public class ArrayListEx {

	/*
	 * 이번에 써 볼 것은 자료구조! 그 중에서도 첫번째는 동! 적! 배! 열! Collection의 자식 
	 * 자바의 동적 배열이라 할 수 있는 자료구조인 ArrayList와 Vector임다!
	 * 위 두 자료구조의 유일한 차이는 동기화! 
	 * Vector는 동기화를 위한 구현이 되어 있기 때문에, 성능 자체는 조금 느리지만 다중 스레드 환경에서 좋고,
	 * ArrayList는 성능은 빠르지만 동기화 구현은 안되어 있습니다!
	 * 
	 * 그리고, 이들은 Generic 클래스이므로, 꼭 <자료형>을 써주길 바랍니다 :)
	 * 마지막으로, 이들은 오로지 객체 타입만 자료형으로 받을 수 있습니다!
	 * 따라서, Integer등의 래핑 클래스를 사용해야합니당 :)
	 */
	
	
	public static void main(String[] args) {
		
		
		/*
		 * 1. ArrayList, Vector의 생성, 초기화, 및 사용
		 */
		
		//1. 선언, 생성, 초기
		ArrayList a; //레퍼런스 선언. 이대로는 쓸 수 없음!
		Vector b;
		
		ArrayList<Integer> c = new ArrayList<Integer>(); //기본형은 사용할 수 없음! 래퍼 클래스를 사용할 것
		ArrayList<Integer> sized = new ArrayList<Integer>(5); //기본 크기 지정 가능합니다.  
		Vector<String> d = new Vector<String>();
		
		//안타깝게도, 배열에서 직접 만드는 방법은 없다.
		
		//2. 비었는지 알아보기 isEmpty()
		if(c.isEmpty()) {
			System.out.println("c is empty!");
		}
		
		c.add(1);
		
		if(c.isEmpty()) {
			System.out.println("c is empty!");
		}else {
			System.out.println("c is not empty!");
		}
		
		
		//3. clone() : 복사본 만들어 주기
		ArrayList<Integer> cc = (ArrayList<Integer>) c.clone();
		
		
		//4. clear() : 비워 버리기
		c.clear();
		
		if(c.isEmpty()) {
			System.out.println("c is empty!");
		}
		
		//이를 통해서, c와 cc와 별개의 객체임을 알 수 있다.
		if(cc.isEmpty() )  System.out.println("cc is empty!");
		else {System.out.println("cc is not empty!");}
		
		//5. toArray() 일반적인 배열로 받아올 수도 있다.
		Integer[] sa = (Integer[]) c.toArray(); 
		
		//6. sort - 콜렉션에서 내려온 것으로,키 순으로 정렬된 리스트를 돌려준다. 단, 컴페레이터가 필요해 귀찮으므로, Collection을 사용할 것을 추천한
		
		
	/*
	 * 2. 삽입, 접근, 삭제, 수정 
	 */
		

		//1. 삽입. 기본적으로 맨 에 들어간다. 
		c.add(10); 
		c.add(77);
		/*주의! 아까 Object형만 들어갈 수 있다고 했지만, 여기서 10이 그냥 기본 자료형인 채 들어간 이유는 
		자바가 무료로 래핑(박)해 주기 때문이다. 물론 이것은 일부 기본 자료형에만 해당되니 주의할 것!
		*/
		d.add("Naegi Makoto");
	
		//인덱스를 지정해서 넣어 줄 수 도 있다. (단, 0 <= index < size())
		c.add(0, 5); //인덱스를 지정해서 넣어 줄 수 도 있다 
		d.add(0, "Hinata Shoyo");
		
		//콜렉션 타입이라면, 통채로 삽입해 줄 수도 있다. (기본 배열은 콜렉션 타입이 아니므로 안된다!) 
		//이 또한 마찬가지로 인덱스를 지정해서 넣어줄 수 도 있다.
		ArrayList e = new ArrayList<Integer>();
		
		//
		e.add(0); 
		e.add(11);
		e.add(78);
		
		c.addAll(e);
		
		
		
		//2. 원소 접근
		
		
		//contains
		//이를 통해서 해당 원소를 가지고 있는지 알 수 있따.
		if (c.contains(78)) {
			System.out.println("c has 78");
		}
		
		//sublist(int start, int end) : 이를 통해서 부분 리스트를 받을 수 있다.
		ArrayList<Integer> ccc = (ArrayList<Integer>) c.subList(2,4);
		
		//get(int index) : 인덱스로 접근할 수 있다. 배열처럼 []을 사용할 수는 없지만... (이런면은 c++의 벡터가 그리워진다)
		Integer c0 = c.get(0);
		System.out.println("first element of c is " + c0);
		
		//indexOf(Object o) : 해당 객체의 인덱스를 받아올 수 있다.
		int indexOfNaegi = d.indexOf("Naegi Makoto");
		System.out.println("Naegi Makoto's index is " + indexOfNaegi);

		//lastIndexOf로 마지막 위치를 알아 낼 수 도 있다.
		
		
		
		//3. 삭제
		//해당 인덱스의 객체를 지울 수 있다.
		//지워진 객체는 돌려받을 수 있다.
		c.remove(0);
		String dd = d.remove(0);
		System.out.println(dd + " has deleted from d");
		
		//또는 해당 오브젝트를 찾아서 지워줄 수 있다. 제거된 오브젝트는 리턴된다. 성공 여부는 boolean으로 반환한다.
		if (!c.remove(new Integer(10))) System.out.println("There is no 10!");
		
		//위와 마찬가지로, 콜렉션 타입인 경우 그 내용을 모두 지워내 줄 수 있다. removeall로 사용 할 수 있따.
		c.removeAll(e);
		
		//어느 범위를 지우고 싶다면,java 8에서 새로 추가된 함수형 개념인 Predicate를 사용한다.
		//다만, 이는 아직 이라고 생각하고, 다음에 하기로 하겟다.
		
		//4. 수정
		System.out.println("Before Modififation : " + c.get(0));
		c.set(0, 19);
		System.out.println("After Modification : " + c.get(0));
		
		//get으로 갖고 온 것은 바꿀 수 없음!
		Integer c00 = c.get(0);
		c00 = 20;
		System.out.println("After Modification With get(int index) : " + c.get(0));
		
		//replaceAll()은 좀 복잡하니 넘어가겠다. Collections에 잇는 것들을 사용하느 ㄴ것이 좋을 듯!
		
		
	}
}
