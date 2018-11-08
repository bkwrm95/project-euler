package mhoover.euler

import kotlin.math.*;

/**
 * Fibonacci
 * A class that generates the Fibonacci sequence
 */

class Fibonacci {
	var curr:Long = 1;
	var prev:Long = 0;
	
	fun next(): Long {
		var temp = curr;
		curr = curr + prev;
		prev = temp;
		return curr;
	}
}


/**
 *  Primes
 *  A Singleton that generates and contains a list of the first n prime numbers
 */

object Primes {
	var primes = longArrayOf(2);
	var maxFound:Long = 2;
	
	fun list(max: Long): LongArray {
		
		for (index in maxFound..max) {
			if (isPrime(index)) {
				primes += index;
				maxFound = index;
			}
		}
		
		return primes.dropLastWhile({ it > max }).toLongArray();
	}
	
	fun isPrime(num: Long): Boolean {
		for (index in primes) {
			if (num % index == 0L) return false;
		}
		return true;
	}
}


/**
 * PrimeFactorMap
 * A map of a number's prime factors and the number of times they occur
 */
typealias PrimeFactorMap = MutableMap<Long, Long>;
fun PrimeFactorMap.increment(key: Long, value: Long) {
	set(key, (get(key) ?: 0) + value);
}
fun PrimeFactorMap.expand(map: PrimeFactorMap) {
	for (key in map.keys)
		this.set(key, max( this.get(key)?:0 , map.get(key)?:0 ));
}


/**
 *  PrimeFactors
 *  A class for finding a number's prime factorization
 */

class PrimeFactors {
	
	var number: Long;
	val primeFactors: PrimeFactorMap = mutableMapOf();
	
	constructor(arg: Long) {
		number = arg;
		for (prime in Primes.list(number)) {
			while (number.isFactor(prime)) {
				primeFactors.increment(prime, 1);
				number /= prime;
			}
		}
	}
}


/**
 * Expansion functions to add mathemtical functionality to Longs
 */
fun Long.isFactor(num: Long): Boolean {
	return this % num == 0L;
}
fun Long.pow(exp: Long): Long {
	return (this.toDouble().pow(num.toDouble())).toLong();
}

fun Long.isPalindrome(): Boolean {
	val str = this.toString();
	val rev = str.reversed();
	return str.equals(rev);
}