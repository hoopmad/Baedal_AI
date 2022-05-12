import java.util.Scanner;

public class Baedal {

	// 배달 거리가 매우가깝다에 대한 소속함수 VeryShortDistance 내용은 사다리꼴공식과 같음
	public static double VeryShortDistance(double n) {
		if (n < 0)// a=0
			return 0;
		else if (n >= 0 && n < 0.0001)// a=0, b=0.0001
			return n / 0.0001;
		else if (n >= 0.0001 && n < 500)// b=0.001, c=500
			return 1;
		else if (n >= 500 && n < 750)// c=500, d=750
			return (750 - n) / 250;
		else
			return 0;
	}

	// 배달 거리가 가깝다에 대한 소속함수 ShortDistance 내용은 사다리꼴공식과 같음
	public static double ShortDistance(double n) {
		if (n < 500) // a=500
			return 0;
		else if (n >= 500 && n < 1000) // a=500, b= 1000
			return (n - 500) / 500;
		else if (n >= 1000 && n < 1000.0001) // b=1000, c=1000.0001
			return 1;
		else if (n > 1000.0001 && n < 1500) // c=1000.0001, d=1500
			return (1500 - n) / 499.9999;
		else
			return 0;
	}

	// 배달 거리가 멀다에 대한 소속함수 LongDistance 내용은 사다리꼴공식과 같음
	public static double LongDistance(double n) {
		if (n < 1250) // a=1250
			return 0;
		else if (n >= 1250 && n < 1750) // a=1250, b=1750
			return (n - 1250) / 500;
		else if (n >= 1750 && n < 1750.0001) // b=1750, c=1750.0001
			return 1;
		else if (n > 1750.0001 && n < 2500) // c=1750.0001, d=2500
			return (2500 - n) / 749.9999;
		else
			return 0;
	}

	// 배달 거리가 매우 멀다에 대한 소속함수 VeryLongDistance 내용은 사다리꼴공식과 같음
	public static double VeryLongDistance(double n) {
		if (n < 2000) // a=2000
			return 0;
		else if (n >= 2000 && n < 2500) // a=2000, b=2500
			return (n - 2000) / 500;
		else if (n >= 2500 && n < 10000) // b=2500, c=10000
			return 1;
		else if (n > 10000 && n < 10000.0001) // c=10000, d=10000.0001
			return (10000 - n) / 0.0001;
		else
			return 0;
	}

	// 주문가격이 낮다에 대한 소속함수 LowOrderPrice 내용은 사다리꼴공식과 같음
	public static double LowOrderPrice(double n) {
		if (n < 0) // a=0
			return 0;
		else if (n >= 0 && n < 0.0001) // a=0, b=0.0001
			return n / 0.0001;
		else if (n >= 0.0001 && n < 10000) // b=0.0001, c=10000
			return 1;
		else if (n >= 10000 && n < 15000) // c=10000, d=15000
			return (15000 - n) / 5000;
		else
			return 0;
	}

	// 주문가격이 보통이다에 대한 소속함수 MediumOrderPrice 내용은 사다리꼴공식과 같음
	public static double MediumOrderPrice(double n) {
		if (n < 10000) // a=10000
			return 0;
		else if (n >= 10000 && n < 17500) // a=10000, b=17500
			return (n - 10000) / 7500;
		else if (n >= 17500 && n < 27500) // b=17500, c=27500
			return 1;
		else if (n >= 27500 && n < 35000) // c=27500, d=35000
			return (35000 - n) / 7500;
		else
			return 0;
	}

	// 주문가격이 높다에 대한 소속함수 HighOrderPrice 내용은 사다리꼴공식과 같음
	public static double HighOrderPrice(double n) {
		if (n < 30000) // a=30000
			return 0;
		else if (n >= 30000 && n < 35000) // a=30000, b=35000
			return (n - 30000) / 5000;
		else if (n >= 35000 && n < 100001) // b=35000, c=100001
			return 1;
		else if (n >= 100001 && n < 100001.0001) // c=100001, d=100001.0001
			return (100001 - n) / 0.0001;
		else
			return 0;
	}

	public static void main(String[] args) {

		// 사용자에게 데이터 입력받기.
		Scanner scan = new Scanner(System.in);
		System.out.println("배달비를 알려드립니다.");
		double distance;
		double price;
		double result = 0;

		// 배달 거리 입력. 음수가 입력되면 재입력.
		do {
			System.out.print("배달 거리를 입력해주세요(최대 3000m): ");
			distance = scan.nextDouble();
			if (distance < 0 || distance > 3000) {
				System.out.println("3000m 이하의 거리를 입력해주세요.");
			}
		} while (distance < 0 || distance > 3000);
		// 주문 가격 입력. 음수가 입력되면 재입력.
		do {
			System.out.print("주문 가격을 입력해주세요(최대 10만원): ");
			price = scan.nextDouble();
			if (price < 0 || price > 100000) {
				System.out.println("10만원 이하의 거리를 입력해주세요.");
			}
		} while (price < 0 || price > 100000);

		// 8개의 규칙에 적용해서 전건부 수치화
		// 배달비: 매우 싸다=1000원, 싸다=2000원, 보통이다=3000원, 비싸다=4000원, 매우 비싸다=5000원)
		// 1. 배달 거리가 매우 가까우면 배달비가 매우 싸다.(1000)
		double r1 = VeryShortDistance(distance) * 100) / 100.0;
		// 2. 배달 거리가 매우 멀면 배달비가 매우 비싸다.(5000)
		double r2 = VeryLongDistance(distance) * 100) / 100.0;
		// 3. 배달 거리가 매우 멀고 주문 가격이 높지 않으면 배달비가 비싸다.(4000)
		double r3 = Math.min(VeryLongDistance(distance), 1 - HighOrderPrice(price)) * 100) / 100.0;
		// 4. 배달 거리가 가깝고 주문 가격이 보통이면, 배달비가 보통이다.(3000)
		double r4 = Math.min(ShortDistance(distance), MediumOrderPrice(price)) * 100) / 100.0;
		// 5. 배달 거리가 가깝거나 주문 가격이 높으면, 배달비가 싸다.(2000)
		double r5 = Math.max(ShortDistance(distance), HighOrderPrice(price)) * 100) / 100.0;
		// 6. 배달 거리가 멀거나 주문 가격이 낮으면, 배달비가 비싸다.(4000)
		double r6 = Math.max(LongDistance(distance), LowOrderPrice(price)) * 100) / 100.0;
		// 7. 배달 거리가 멀고 주문 가격이 보통이면, 배달비가 보통이다.(3000)
		double r7 = Math.min(LongDistance(distance), MediumOrderPrice(price)) * 100) / 100.0;
		// 8. 배달 거리가 멀고 주문 가격이 높으면, 배달비가 보통이다.(3000)
		double r8 = Math.min(LongDistance(distance), HighOrderPrice(price)) * 100) / 100.0;

		// 스게노st로 결과값 계산
		result = (r1 * 1000 + r2 * 5000 + r3 * 4000 + r4 * 3000 + r5 * 2000 + r6 * 4000 + r7 * 3000 + r8 * 3000)
				/ (r1 + r2 + r3 + r4 + r5 + r6 + r7 + r8);

		// 배달비 출력
		System.out.println("배달비는 " + Math.round(result) + "원 입니다.");

		scan.close();

	}

}
