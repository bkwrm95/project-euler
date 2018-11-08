package mhoover.euler

fun main(args: Array<String>) {

    execProblem("8");

}

fun execProblem(choice: String, arg: Long = 0) {
    println("Problem $choice: ");
	when(choice) {
		"1" -> problem1(1000L);
		"2" -> problem2(4_000_000L);
		"3" -> problem3(600_851_475_143L);
		"4" -> problem4(3);
        "5" -> problem5(20);
        "6" -> problem6(100);
        "7" -> problem7(10_001);
        "8" -> problem8(13);
        "9" -> problem9();

		"primes" -> for (item in Primes.list(arg)) println("$item ");
		"primeFactors" -> for ((k, v) in PrimeFactors(arg).primeFactors) println("$k: $v");
	}
}