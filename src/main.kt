package mhoover.euler

fun main(args: Array<String>) {
	val arg = if (args.size > 1) args[1].toLong() else 0;
	
	when(args[0]) {
		"1" -> Problem1(1000L);
		"2" -> Problem2(4_000_000L);
		"3" -> Problem3(600851475143L);
		"4" -> Problem4(3);
		"5" -> Problem5(20);
		
		"primes" -> for (item in Primes.list(arg)) println("$item ");
		"primeFactors" -> for ((k, v) in PrimeFactors(arg).primeFactors) println("$k: $v");
	}
}