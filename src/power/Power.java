package power;

public class Power {
	public long power(int base, int exponent) {
		final int EVEN = 0;
		final int EXPONENT_ONE = 1;
		final int BASE_ZERO = 0;

		if (exponent == EXPONENT_ONE) {
			return base;
		} else if (base == BASE_ZERO) {
			return 1;
		}

		if (exponent % 2 == EVEN) {
			long newBase = power(base, exponent / 2);
			return newBase * newBase;
		} else {
			long newBase = power(base, (exponent - 1) / 2);
			return (newBase * newBase) * base;
		}
	}

	public static void main(String args[]) {
		Power p = new Power();

		System.out.println(p.power(2, 30));
	}
}
