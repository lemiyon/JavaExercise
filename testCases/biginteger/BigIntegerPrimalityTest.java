package biginteger;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class BigIntegerPrimalityTest {
/*
 * 해커랭크 문제. BigInteger를 이용해야 한다.
 * 100 글자 정도의 숫자가 있다. 이가 소수인지 판별하시오.
 * isProbablyPrime(int certainty) 를 이용한다.
 */
	static String isPrimeS = "prime";
	static String isNotPrimeS = "not prime";
	
	String isPrime(BigInteger bi) {
		//1/16확률로 틀릴 수 있다. 
		if(bi.isProbablePrime(4)) {
			return "prime";
		}
		else {
			return "not prime";
		}
	}
	
	
	@Test
	public void testIsPrime() {
		assertEquals(isPrime(new BigInteger("2")), isPrimeS);
		assertEquals(isPrime(new BigInteger("3")), isPrimeS);
		assertEquals(isPrime(new BigInteger("7")), isPrimeS);
		assertEquals(isPrime(new BigInteger("11")), isPrimeS);
		assertEquals(isPrime(new BigInteger("2305843009213693951")), isPrimeS);
	}
	
	@Test
	public void testIsNotPrime() {
		assertEquals(isPrime(new BigInteger("1")), isNotPrimeS);
		assertEquals(isPrime(new BigInteger("6")), isNotPrimeS);
		assertEquals(isPrime(new BigInteger("2305843009213693952")), isNotPrimeS);
	}

}
