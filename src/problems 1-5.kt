package mhoover.euler;

fun problem1(arg: Long) {
	var total = 0L;

	for (index in 1 until arg) {
		if (index.isFactor(3) || index.isFactor(5)) {
			total += index;
		}
	}

	println(total);
}

fun problem2(limit: Long) {

	var fibb = Fibonacci();
	var total = 0L;

	while (fibb.curr < limit) {
		if (fibb.curr % 2L == 0L) {
			total += fibb.curr;
		}
		fibb.next();
	}

	println(total);
}

fun problem3(num: Long) {

	var divisor = 1L;
	for (index in Primes.list(200)) {
		if (num.isFactor(index)) {
			divisor = index;
			break;
		}
	}
	println("${num/divisor}");
}

fun problem4(num: Long) {

	val max = 10L.pow(num);
	var maxPalindrome = 0L;

	for (num1 in 0..max) {
	for (num2 in 0..max) {
		var temp = num1*num2;
		if (temp.isPalindrome() && temp > maxPalindrome)
			maxPalindrome = temp;
	}
	}
	println(maxPalindrome);
}

fun problem5(arg: Long) {

	val argFactors: PrimeFactorMap = mutableMapOf();

	for (index in 1..arg) {
		var factors = PrimeFactors(index).primeFactors;
		argFactors.expand(factors);
	}

	var total = 1L;
	for ((factor, numCopies) in argFactors) {
		total *= factor.pow(numCopies);
	}

	println(total);
}




