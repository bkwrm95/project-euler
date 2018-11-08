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
		val temp = curr;
		curr += prev;
		prev = temp;
		return curr;
	}
}


/**
 *  Primes
 *  A Singleton that generates and contains a list of the first 'n' prime numbers
 */
object Primes {
	private var primes = longArrayOf(1L,2L);
	private var maxFound:Long = 2;
	
	fun list(max: Long): LongArray {
		
		for (index in maxFound..max) {
			if (isPrime(index)) {
				primes += index;
				maxFound = index;
			}
		}
		
		return primes.dropLastWhile({ it > max }).toLongArray();
	}

    fun get(nth: Long): Long {

        var index: Long = maxFound;

        while (primes.size <= nth) {
            index++;
            if (isPrime(index)) {
                primes += index;
                maxFound = index;
            }
        }

        return primes[nth.toInt()];
    }
	
	private fun isPrime(num: Long): Boolean {
		for (index in primes) {
            if (index == 1L) continue;
			if (num % index == 0L) return false;
		}
		return true;
	}
}


/**
 * PrimeFactorMap
 * A map of a number's prime factors and the number of times they occur <factor, ocurrences>
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
fun Long.isFactor(divisor: Long): Boolean {
	return this % divisor == 0L;
}

fun Long.pow(exp: Long): Long {
	return (this.toDouble().pow(exp.toDouble())).toLong();
}

fun Long.isPalindrome(): Boolean {
	val str = this.toString();
	val rev = str.reversed();
	return str.equals(rev);
}


/**
 * SumOfSquares
 */
class SumOfSquares(num: Long){
    var sum:Long = 0;

    init {
        for (index in 1..num) {
            sum += index*index;
        }
    }

    fun get(): Long {
        return sum;
    }
}

/**
 * SquareOfSums
 */
class SquareOfSums(num: Long){
    var sum:Long = 0;

    init {
        for (index in 1..num) {
            sum += index;
        }
        sum *= sum;
    }

    fun get(): Long {
        return sum;
    }
}

/**
 * traverseNumber
 */
fun traverseNumber(arr:Array<Int>, num: Int):Long {

    var maxProduct: Long = 0;
    for (i in 0..arr.size-num) {
        var temp: Long = 1;
        for (j in i until i+num) {
            temp *= arr[j];
        }

        if (temp > maxProduct)
            maxProduct = temp;
    }

    return maxProduct;
}

/**
 * Peruse2dArray
 */
fun peruse2dArray(arr:Array<Array<Int>>, adjDigits: Int, x: Int=0, y: Int=0):Long {

    if (arr.size - adjDigits == x || arr[0].size - adjDigits == y) {
        return 1;
    }

    return (
        peruse2dArray(arr, adjDigits, x+1, y)*
        peruse2dArray(arr, adjDigits, x, y+1)*
        max(
            productDown(arr,adjDigits, x, y),
            productRight(arr,adjDigits, x, y),
            productDiagonal(arr,adjDigits, x, y)
        )
    );
}

fun productDown(arr:Array<Array<Int>>, adjDigits: Int, x: Int, y: Int):Long {
    var product:Long = 1;
    for (adj in 0..adjDigits) {
        product *= arr[x][y+adj];
    }
    return product;
}

fun productRight(arr:Array<Array<Int>>, adjDigits: Int, x: Int, y: Int):Long {
    var product:Long = 1;
    for (adj in 0..adjDigits) {
        product *= arr[x+adj][y];
    }
    return product;
}

fun productDiagonal(arr:Array<Array<Int>>, adjDigits: Int, x: Int, y: Int):Long {
    var product:Long = 1;
    for (adj in 0..adjDigits) {
        product *= arr[x+adj][y+adj];
    }
    return product;
}

fun max(num1:Long, num2:Long, num3:Long): Long {
    if (num1 > num2 && num1 > num3) return num1;
    if (num2 > num1 && num2 > num3) return num2;
    return num3;
}


fun isPythagoreanTriplet(a: Int, b: Int, c: Int): Boolean {
    return (a*a + b*b) == (c*c);
}