package bigdecimal;

import static org.junit.Assert.assertArrayEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;

public class BigDecimalSortTest {
	/*
	 * Hackerank 문제.
	 * Java BigDecimal에 관련된 문제이다. 빅데시멀은 온갖 형태의 자료를 온전히 다룰 수 있도록 도와준다. 
	 * 스트링 배열을 빅데시멀을 이용해 내림차순으로 정렬하여라. 
	 * 단, 다른 표현이지만 같은 수를 나타내는 경우, 그 순서가 변하지 않도록 한다.
	 * 즉, 안정적인 제자리 정렬을 사용해야 한다는 거! 
	 * 
	 * 입력은 모두 300자리 근처 쯤 되는 수이며 
	 * 1~ 200개의 입력이 들어온다. 
	 */

	int[] merge(int[] a, int[] b) {
		//두 배열을 합친다. 

		int[] c = new int[a.length + b.length];

		//index들 
		int ai = 0;
		int bi = 0;
		int ci = 0;

		while(ci < c.length) {

			if(ai >= a.length) {
				while(bi < b.length) {
					c[ci] = b[bi];
					ci++;
					bi++;
				}

				return c;
			}
			else if(bi >= b.length) {
				
					while(ai < a.length) {
						c[ci] = a[ai];
						ci++;
						ai++;
					}

					return c;
				
			}
			else {


				if(a[ai] < (b[bi])) {
					c[ci] = a[ai];
					ai++;
				}else if(a[ai] > (b[bi]) ) {
					c[ci] = b[bi];
					bi++;
				}else {
					c[ci] = a[ai];
					ai++;
					ci++;
					c[ci] = b[bi];
					bi++;
				}
				
				ci++;
			}
		}

		return c;
	}

	
	//재귀 방식으로, 위에서부터 쪼개가며 합치
	int[] mergeSortTopDown(int start, int end ,int[] a) {
		
		while(true) {
			//중앙을 중심으로 자른다. 
			//연산자 우선순위 조심!
			int mid = (end - start) / 2;
			if(mid <= 0) {
				return a;
			}
			//왼쪽 덩어리 
			mergeSortTopDown(start, mid, a);
			//오른쪽 덩어
			mergeSortTopDown(mid + 1, end, a);
			
		
		}
		
	}
	
	int[] mergeSortBottomUp(int[] a) {
		
		//a를 나눠야 한다. 도저히 쪼개지지 않을 때 까지!
		//아니면, 바닥부터 올라가면 된다.
		for(int width = 1; width <= a.length; width *= 2) {
			
		}
		
		return a;
	}
	

	int[] bubbleSort(int a[]) {
		
		for(int i = a.length - 1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				
				if(a[j] > a[j+1]) {
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
				
			}
		}
		
		return a;
	}
	
	/*
	 * 문제의 조건 중 입력 값은 200개를 넘어가지 않으니 그렇게 오래 걸리지 않을 것이다. 그래서 버블 소트를 써도 된다고 생각했다.
	 * 그리고, 조건 중 값이 같은 경우는 그 순서를 유지해야 한다고 했다. 즉, 안정적인 정렬을 쓰라고 했으니 그렇게 했다.
	 * 마지막으로, 굳이 전부를 빅데시멀로 바꾸지 않은 이유는, 출력은 원본 스트링 그대로 해야 하기 때문이었다.
	 * 안타깝게도, 빅데시멀에는 자신을 초기화 했던 값으로 다시 돌아가는 것은 불가능한 것 같았다.
	 * 그리고, 내림차순으로 정렬해야 한다.
	 * 
	 * 사실, 안정적인 정렬 아무거나 써도 됨 :0
	 */
	
	String[] bubbleSortBigDecimal(String a[]) {
		
		for(int i = a.length - 1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				
				//출력시의 스트링의 형태를 그대로 유지하기 위해서, 그냥 새 값을 만들어 비교하고, 그 비교를 토대로
				//스트링 배열의 원소 자리를 바꿔댔다. 
				BigDecimal bd1 = new BigDecimal(a[j]);
				BigDecimal bd2 = new BigDecimal(a[j+1]);
				
				if(bd1.compareTo(bd2) == -1) {
				//bd1이 더 큰 경우만 처리해 주면된다. 같아도 움직이면 안된다. 
					String temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
				
			}
		}
		
		return a;
	}
	
	@Test
	public void testbubbleSortBigDecimal() {
		String[] a = {
				"-100",
				"50",
				"0",
				"56.6",
				"90",
				"0.12",
				".12",
				"02.34",
				"000.000"};
		String[] ans1 = { "90",
				"56.6",
				"50",
				"02.34",
				"0.12",
				".12",
				"0",
				"000.000",
				"-100"};
		
		assertArrayEquals(ans1, bubbleSortBigDecimal(a));
	}
	
	
	
	@Test
	public void testBubbleSort() {
		
		//Random, No Duplication 
		int[] a = {3,6,1,2,9,4,5,8,7};
		int[] ans1 = {1,2,3,4,5,6,7,8,9};
		
		assertArrayEquals(ans1, bubbleSort(a));
		
		//All the same elements
		int[] b = {1,1,1,1,1,1,1};
		int[] ans2 = {1,1,1,1,1,1,1};
		
		assertArrayEquals(ans2, bubbleSort(b));
		
		//Try to sort empty array
		int[] c = {};
		int[] ans3 = {};
		assertArrayEquals(ans3, bubbleSort(c));
	}
	
	
	
	
	
	@Test
	public void testMergeSort() {
		
	}
	
	@Test
	public void testMergeEmpty() {
		int[] a = {};
		int[] b = {2,4,6};
		int[] c = {2,4,6};
		
		
		//배열이 같은지 비교할 때!
		assertArrayEquals(merge(a,b), c);
	}

	
	
	@Test
	public void testMergeDiffLength() {
		int[] a = {1,3,5,7};
		int[] b = {2,4,6};
		int[] c = {1,2,3,4,5,6,7};
		
		
		assertArrayEquals(merge(a,b), c);
		
		int[] a2 = {1,1,1,1,1};
		int[] b2 = {1,1,1,2,3};
		int[] c2 = {1,1,1,1,1, 1,1,1,2,3};
		
		assertArrayEquals(merge(a2,b2),c2);
		
	}


	@Test
	public void testMergeSameLength() {
		int[] a = {1,3,5};
		int[] b = {2,4,6};
		int[] c = {1,2,3,4,5,6};
		
		assertArrayEquals(merge(a,b), c);
	}

}
