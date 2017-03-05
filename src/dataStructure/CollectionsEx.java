package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class CollectionsEx {
/*
 * 자바의 거의 모든 자료 구조의 어머니, Collections 인터페이스에 대해서 공부해본다.
 * 이는 자신을 상속하는 거의 모든 자료구조에 사용할 수 있는 편리한 메소드들을 제공한다. 
 * 예를 들어, 순서있는 list계통에 사용할 수 있는 sort라던가. 
 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] a = {3,5,10, 11, 1, 7, 2, 4, 3, 2};
		
		//Arrays라는, 배열의 형태의 자료구조에 많이 쓰이는 메소드들을 정리 해 놓은 라이브러리도 있다.
		//프리미티브 배열을 리스트 형으로 바꿔주는 좋은 구조도 있다.
		//List(상위 인터페이스일 뿐)형을 그대로 변경해 주는 건 안되니, 생성자를 사용해서 제대로 해주도록 하자!
		ArrayList<Integer> al =  new ArrayList<Integer>(Arrays.asList(a));
		
		//sort
		//리스트형태의 자료구조를 정렬해 준다. 기본으로 오름차순이다. 
		Collections.sort(al);
		System.out.println("Collections.sort() : " + al);
		
		//Collections.reverseOrder를 사용해 역순으로 정렬할 수 도 있다.
		Collections.sort(al, Collections.reverseOrder());
		System.out.println("Collections.sort(al, Collections.reverseOrder()) : " + al);
		
		//reverse
		//리스트 형태의 자료구조를 뒤집어 준다. 
		Collections.reverse(al);
		System.out.println("Collections.reverse(al) : " + al);
		
		//frequecy(c, o) : c(Collections)안에 o와 같은 원소가 몇 개 인지 세준다. 
		int numOfthree = Collections.frequency(al, 3);
		System.out.println("the number of 3 in al is " + numOfthree);
		
		//rotate : distance만큼 list내의 원소를 회전해준다. 아, 이 메소드가 있다면 여러 문제는 가볍게 풀 수 있을 듯
		//distance가 -라면 왼쪽, +면 오른쪽으로 회전한다.
		Collections.rotate(al, 1);
		System.out.println("Collections.rotate(al, 1) : " + al);
		
		//shuffle : 랜덤한 순서로 섞어버린다. 
		Collections.shuffle(al);
		System.out.println("Collections.shuffle(al) : " + al);
	}

}
