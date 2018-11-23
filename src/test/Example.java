package test;

public class Example {
	public boolean isTrue(String str1, String str2) {
		if (str1.equals(str2)) {
			System.out.println("두개가 같아요 TRUE를 반환합니다");
			return true;
		} else {
			System.out.println("두개가 달라요 FALSE를 반환합니다");
			return false;
		}
	}

	public static void main(String[] args) {
		String name = "Name";
		String name2 = "Name";

		Example ex = new Example();
		ex.isTrue(name, name2);
	}
}
