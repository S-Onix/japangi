package test;

public class Example {
	public boolean isTrue(String str1, String str2) {
		if (str1.equals(str2)) {
			System.out.println("�ΰ��� ���ƿ� TRUE�� ��ȯ�մϴ�");
			return true;
		} else {
			System.out.println("�ΰ��� �޶�� FALSE�� ��ȯ�մϴ�");
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
