package dataStructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/*
 * O Dictionario! (Portugues)
 * 세번쨰는 해쉬테이블에 속하는 HashMap입니다! 똑같은 Collections의 하위 클래스에 속하고, 딕셔너리를 생각하면 되요!
 * 키 : 값 쌍의 무순서 무중복 집합. 중복 키는 허용되지 않습니다.
 * 물론 키값으로 정렬해서 배열로 받아오는 방법은 있습니다! 
 * 
 */
public class HashMapEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. 생성, 초기화 
		 * 똑같이 제네릭 클래스다. 다만, <키, 값>의 타입을 명시 해줘야 한다!
		 */
		HashMap<String, String> hm = new HashMap<String, String>();
		
		/*
		 * 2. 원소 추가
		 */
		
		//put(키, 값) 키 - 값의 형태로 들어간다. 만약, 같은 키에 값만 다른 것이 들어간다면, 이전 값은 새 값으로 대체된다!
		hm.put("Amy", "Rose");
		System.out.println("put(Amy, Rose)" + hm);
		
		hm.put("Amy", "Winehouse");
		System.out.println("put(Amy, Winehouse)" + hm);
		
		//putAll(맵 종류) : 맵 종류라면 전체를 넣을 수 있다. 같은 키가 들어가 있는 경우, 역시 새값으로 대체되니 주의!
		
		//TreeMap : Map의 일부이며, Hashtable이 아니라 트리 형태로 저장되어 있다. 
		//덕분에 검색은 정말 빠르며, 안타깝게도 Collections가 아니기 때문에 관련 메소드는 사용할 수 없다 
		TreeMap<String, String> tm = new TreeMap<String, String>();
		tm.put("Amy", "GraceFul");
		tm.put("Amelia", "Vine");
		tm.put("Kujikawa", "Naoki");
		
		hm.putAll(tm);
		System.out.println("putAll(" + tm + ") : " + hm);
		
		//putIfAbsent : 맵에 저장되어 있지 않은 키의 (키- 값) 쌍 만 넣는다. 리턴은 해당 키에 저장될 값을 반환한다.
		//만약, 이미 그 키가 존재하면 리턴은 null이고, 아무것도 반환하지 않는다. 또한, 맵의 값도 변하지 않는다.
		String nullMaybe = hm.putIfAbsent("Grillme", "HoldOn");
		if(nullMaybe == null){ System.out.println("putIfAbsent(Grillme, HoldOn) :   " + hm);}
		else { System.out.println("putIfAbsent(Amy, HoldOn) Key \"Grillme\" is already exsits : " + hm );}
		
		
		/*
		 * 3. isEmpty(), size()
		 */
		
		HashMap<String, String> emptyhm = new HashMap<String, String>();
		
		//isEmpty()로 비었는지 알아낸다.
		if(emptyhm.isEmpty()) {
			System.out.println("emptyhm is empty!");
		}else {
			System.out.println("emptyhm is not empty?!?!");
		}
		//size()로 크기를 알아낸다. 
		System.out.println("hm's size is " + hm.size());	
		
		
		/*
		 * 원소 참조, 변경  및 제거
		 */
		

		//containsKey()로 해당 키를 갖고 있는지 확인한다.
		if (hm.containsKey("Amy")) {System.out.println("There is key : Amy! " + hm);};
		
		//containsValue()로 해당 값을 갖고 있는지 확인한다.
		if (hm.containsValue("naoki")) {
			System.out.println("There is a value : naoki!" + hm);
		}
		
		//get(키)로 해당하는 키의 값을 갖고 온다. 만약 해당 키가 존재하지 않으면 null이 반환한다.
		String naoki = hm.get("Kujikawa");
		//값을 변경해도, 복사해서 넘어가는 String은 변하지 않는다.  
		naoki = "nojomi";
		System.out.println(hm);
		
		//getOrDefault : 키값을 찾아봐서 없으면 default값을 반환한다.
		String r = hm.getOrDefault("name", "defualt");
		System.out.println("getOrDefault(name, defualt) : " + r);
		
		
		//키의 집합을 가져온다. 
		Set<String> ks = hm.keySet();
		for(String k : ks) {
			System.out.println("Key : " + k);
		}
		
		//값의 집합을 가져온다. 이건 또 Collection이다. 값에는 배열이나 리스트가 들어갈 수 있기 때문일 것이다. 
		Collection<String> vs = hm.values();
		for(String v : vs) {
			System.out.println("Value : " + v);
		}
		
		//키-값 쌍의 집합(엔트리라고 부른ㄷ)을 가져온다. Map에 선언되어 있느 자료형이다.
		Set<Entry<String, String>> ens = hm.entrySet();
		for(Entry<String,String> en : ens) {
			System.out.println("entries  :" + en);
		}
		
		//제거.
		//remove(키) : 해당 키-값 쌍을 지운다. 만약 값이 있었다면 직전 값을, 없었다면 null을 반환한다.
		String graceful = hm.remove("Amy");
		if(graceful != null) {
			System.out.println("remove(Amy) : " + hm);
		}else {
			System.out.println("key Amy is not exist!");
		}
		
		//변경 - 해당 키를 가진 값을 변경시킨다. 이전 값은 되돌려 준다. Object 형도 있으니 주의! 
		//만약 키가 원래 없었으면 null만 반환하고 종료 
		String naoki2 = hm.replace("Kujikawa", "rise");
		System.out.println("oldValue : " + naoki2 +" replace(kujikawa, rise) : " + hm);
		
		//replace(키, 이전 값, 새 값)으로, 키와 이전값을 정확하게 알고 있으면 바꿀 수 있따.
		//반환 값은 성공여부의 boolean
		if(hm.replace("Grillme", "HoldOn", "Grillby")) {
			System.out.println("Grillme - HoldOn -> Grillme- Grillby : " + hm);
		}else {
			System.out.println("No changes!");
		}
		
		//비우기
		hm.clear();
		System.out.println("it's clear! Bye! hm : " + hm);
	}

	
	
	
}
