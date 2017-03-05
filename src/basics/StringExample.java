package basics;


public class StringExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String = Char array with /0. 
		//So, Keep it in mind, then let's start Study String class!
		
		/*
		 * 1. String Class
		 * 정적(immutable). 문자열에 다양한 연산을 할 시에는 부하가크다. 검색 시에는 좋음
		 * 리퍼런스 타입이다. 생성시 주의할 것.
		 * 만약 문자열에 다양한 연산을 하고 싶다면 StringBuilder, StringBuffer를 활용하자.
		 */
	
		//1. String의 생성 및 초기화
		
		//참고로, StringBuffer와 StringBuilder에서 바로 생성도 가능하다.
		String no; //그냥 리퍼런스만 생성함. 이것은 아직 스트링이 아님! 자바의 기초이니만큼 잊지 말
		String a = "hi"; //상수로 생  
		String b = new String(a); //Generate from other strings
		String c = a + b; //더하기 연산으로 생성 가능. 단, 이는 새로운 객체가 만들어지는 것이지 변하지는 않
		//+는 concat()함수를 사용할 수 있
		/*
		 * String 객체는 한 번 생성되면 할당된 메모리 공간이 변하지 않습니다. 
		 * + 연산자 또는 concat 메서드를 통해 기존에 생성된 String 클래스 객체 문자열에
		 *  다른 문자열을 붙여도 기존 문자열에 새로운 문자열이 붙는 것이 아니라, 새로운 String 객체를 만든 후
		 *  , 새 String 객체에 연결된 문자열을 저장하고, 그 객체를 참조하도록 합니다. 
		 *  (즉, String 클래스 객체는 Heap 메모리 영역(가비지 컬렉션이 동작하는 영역)에 생성되며, 
		 *  한 번 생성된 객체의 내부 내용을 변화시킬 수 없습니다. 
		 *  기존 객체가 제거 되면 Java의 가비지 컬렉션이 회수합니다.)
		 */
		
		//String format이라는 스태틱 메소드를 사용해서도 생성할 수 있다.
		String d = String.format("a : %s b : %s c : %s", a, b,c);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		
		//2. 길이
		String stringa = "Chocolate";
		System.out.println("the length Of Chocolate is " + stringa.length());
		
	
		
		
		/*
		 * 
		 * 2. 문자열 비교 
		 * */
		
		//1. compareTo 
		// 사전 기준으로 문자열을 비교해, 인자보다 내가 먼저 나오면 1, 같으면 0, 나중에 나오면 -1을 반환한다.
		// 자매품으로 compareToIgnore가 있다. 이는 대소문자 차를 무시한다(평소에는 대문자가 먼저)
		
		
		String i = "IA";
		String i2 = "ia";
		String j = "ja";
		
		if(i.compareTo(j) == 1) {
			System.out.println( i + " is greater than " + j);
		}else {
			System.out.println(i + " is smaller than " + j);
		}
		
		
		if(i.compareTo(i2) == 1) {
			System.out.println( i + " is greater than " + i2);
		}else {
			System.out.println(i + " is smaller than " + i2);
		}
		
		//대소문자 구분 X
		if(i.compareToIgnoreCase(i2) == 1) {
			System.out.println( i + " is greater than " + i2);
		}else if(i.compareToIgnoreCase(i2) == 0){
			System.out.println(i + " is same with " + i2);
		}
		else {
			System.out.println(i + " is smaller than " + i2);
		}
		
		
		//  2. equals , ==의 차
		
		String e = "Hopes and Dreams";
		String g = e; //String은 리퍼런스 타입, 즉, g는 e가 변경되면 같이 변경되고,메모리 상의 같은 객체를 가리키고 있다.
		String h = new String(e); //e와 같은 내용을 가지지만, 다른 객체이다.
		
		//equals는 내용을 비교한다. 비교연산자 ==은 같은 객체인지를 비교한다! 
		if (e == g) 
			 System.out.println("e and g is the same object") ;
		else  {
			System.out.println("e and g is diffrent object");
		}
		
		//따라서, 내용은 같지만, 다른 객체인 h는 다르다고 나와버린다.
		if (e == h) 
			 System.out.println("e and h is the same object") ;
		else  {
			System.out.println("e and h is diffrent object");
		}
		
		if (e.equals(h)) 
			 System.out.println("e and h has the same contents") ;
		else  {
			System.out.println("e and h has diffrent contents");
		}
		
		//자매품 contentsequls이 있다. 이는 CharSequence나 Stringbuffer가 인자인 경우  사용
		//자매품 equalsIgnoreCase로 대소문자 구분 없이 비교할 수 도 있다.
		
		
		
		/*
		 * 3. 문자, 문자열의 인덱스 가져오기 
		 */
		
		//1. charAt(i) : i번째 문자를 가져온다. char형 반환 
		String string = "Naegi Makoto is the main character from Danganronpa 1";
		System.out.println(string.charAt(0));
		
		//2. indexOf(c) : c의 문자, 혹은 문자열의 첫 발생 위치 를 가져온다. 없다면 -1을 반환
		//두번 째 인자인 StartIndex를 이용해서, 해당 인덱스 이후에서부터 찾을 ㅅ도 있다.
		int indexOfi = string.indexOf("i");
		int indexOfLateri = string.indexOf("i", 10);
		int indexOfDanganronpa = string.indexOf("Danganronpa");
		int nowhere = string.indexOf("z");
		
		System.out.println(indexOfi);
		System.out.println(indexOfLateri);
		System.out.println(indexOfDanganronpa);
		System.out.println(nowhere);
		
		//자매품 lastIndexOf로 뒤에서 부터 찾을 수도 있다
		
		/*
		 * 4. 문자열 분해
		 * Split, Substring
		 */
		
		//1. split(String regx) : regx내의 모든 문자를 디리미터로 삼아 문자열을 분리한다.
		String string2 = "Nyam Nyam yam\nHello";
		String[] splited = string2.split(" "); //빈칸 구분해 분해한다.
		for(String s : splited) {
			System.out.println("first"+s);
		}
		
		//\n(개행문자)와 빈칸 모두로 디리미터로 삼는 스플
		 splited = string2.split("[ \n]"); //빈칸과 엔터를 구분해 분해한다.
		for(String s : splited) {
			System.out.println("second"+ s);
		}
		
		//2. subString(int begin) begin번쨰 인덱스 부터 끝까지 잘라낸다. 자매품으로 last도 지정해 줄 수 있다.
		String sub1 = string2.substring(10);
		String sub2 = string2.substring(0, 4);
		System.out.println(sub1);
		System.out.println(sub2);
		
	
	/*
	 * 5. 문자열 대체 
	 * replace, replaceAll, replaceFirst
	 */
	String string3 = "I love Chocolate";
	String string4 = string3.replace("Chocolate", "Steak");
	//정규표현식을 사용하고 있는 대체 
	String string5 = string3.replaceAll("l", "r");  //모든 발생을 바꿔버
	String string6 = string3.replaceFirst("e", "ey");  //첫 번째 사례만 바꿈
	System.out.println(string3);
	System.out.println(string4);
	System.out.println(string5);
	System.out.println(string6);
	
	/*
	 * 6. 문자열의 존재 여부
	 * contains(Charsequence), matches(정규표현식)
	 */
	
	
	String string7 = "Peanut Butter Chocolate Pumpkin Cream Cheese Tart";
	
	//1. Contains
	if(string7.contains("Pumpkin")) {
		System.out.println(string7 + " has Pumpkin!");
	}
	else {
		System.out.println(string7 + " doesn't have Pumpkin!");
	}
	
	if(string7.contains("Chia seed")) {
		System.out.println(string7 + " has Chia seed!");
	}
	else {
		System.out.println(string7 + " doesn't have Chia seed!");
	}
	
	//2. matches
	//문자열 전체가 matches(정규표현)에 일치하는지 여부만 반환. 문자열까지 다 받고 싶다면, Pattern 등의 정규표현식을 완전히 사용 바람.
	if(string7.matches("P.*t")) {
		System.out.println("It matches with the regular expression P.*t");
	}else {
		System.out.println("Cannot Find the match!");
	}
	
	/*
	 * 7. 문자열의 접두사, 접미사
	 * startWith, endWith
	 */
	
	String string8 = "Chocolate PBJ Protein Shake With Chia seed";
	
	//1. startWith
	if(string8.startsWith("Chocolate")) {
		System.out.println(string8 + " is start with Chocolate");
	}
	else {
		System.out.println(string8 + " isn't start with Chocolate");
	}
	
	//2. endsWith
	if(string8.endsWith("Chocolate")) {
		System.out.println(string8 + " is ends with Chocolate");
	}
	else {
		System.out.println(string8 + " isn't end with Chocolate");
	}
	
	
	/*
	 * String class 메소드 
	 */
	
	//char 형 배열에서 String만들기 
	char[] cs = {'c', 'h', 'a', 'r'} ;
	String charchar = String.copyValueOf(cs);
	System.out.println("String.copyValueOf(cs) : " + charchar);
	
	//format으로 String만들기 
	//c의 printf와 비슷하다. 
	//******format이 좀 다르다. 잘 봐둘것 
	
	//1$, 2$...가 각각 첫번째, 두번째 아규먼트를 뜻한다. 그 앞에는 그에 맞는 자료형을 붙여줘야 한다.
	String weather = String.format("%1$d %2$f %3$s %4$c", 10, 3.3, "what", 'c');
	System.out.println("String.format: " + weather);
	
	//join(delimeter, elements) 주어진 문자열들을 맨 앞의 문자열로 연결해서 큰 문자열을 만들어 반환해준다.
	String names = String.join("-", "Naegi", "Makoto", "Komaeda", "Nagito");
	System.out.println("String.join(-, names)" + names);
	
	//String이 가지고 있는 comperator로 caseInsensative한 비교를 수행할 수도 있다.
	}
	
	
	

}
