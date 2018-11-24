package japangi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

import database.MenuDAO;
import item.MenuDTO;

public class FoodTest {
	
	//�ֹ� ����Ʈ(����, ����, ���� ����)
	ArrayList<ArrayList<String>> orderList;
	//DB������ ���� ��������
	MenuDAO menuQuery;
	
	//�޴��� �����ϱ� ���� ���� ����
	HashMap<Integer, MenuDTO> food;
	//����ڰ� �ֹ� ��ҽ� ���� ���� �˰� �ϱ����� ���� ����
	HashMap<Integer, MenuDTO> foodBackup;
	//����ڰ� �����ؾ��� �Ѿ�
	int payMoney = 0;
	
	Scanner scan;

	public FoodTest() {
		menuQuery = new MenuDAO();
		food = new HashMap<>();
		foodBackup = new HashMap<>();
		initFoodList();
		scan = new Scanner(System.in);
		orderList = new ArrayList<ArrayList<String>>();
	}

	public void initFoodList() {
		ArrayList<String> foodList = menuQuery.selectAllMenu();
		Iterator<String> i = foodList.iterator();

		while (i.hasNext()) {
			StringTokenizer st = new StringTokenizer(i.next(), "|");
			while (st.hasMoreTokens()) {
				int foo_no = Integer.parseInt(st.nextToken());
				String foo_name = st.nextToken();
				String foo_type = st.nextToken();
				int foo_price = Integer.parseInt(st.nextToken());
				int foo_cnt = Integer.parseInt(st.nextToken());
				String foo_recipe = st.nextToken();

				food.put(foo_no, new MenuDTO(foo_no, foo_name, foo_type, foo_price, foo_cnt, foo_recipe));
				foodBackup.put(foo_no, new MenuDTO(foo_no, foo_name, foo_type, foo_price, foo_cnt, foo_recipe));
			}
		}
	}



	/*
	 * �ֹ��� ����Ǿ��� ���׵�
	 * ������ ������ ����
	 * �ֹ� ��
	 * */
	public void foodOrder(int foodNum, int count) {
		if ((food.get(foodNum).getFoodCount() - count) >= 0) {
			food.get(foodNum).setFoodCount(food.get(foodNum).getFoodCount() - count);
			setPayMoney(getPayMoney() + (food.get(foodNum).getPrice()*count));
			addOrderList(foodNum, count);
		} else {
			// ���� ���� ���� ���
			System.out.println(food.get(foodNum).getFoodCount() + "��ŭ �����ֽ��ϴ�");
			System.out.println("�ֹ��� �� �����ϴ�");
		}
	}
	
	public void addOrderList(int foo_no, int count) {
		ArrayList<String> s = new ArrayList<String>();
		String name = food.get(foo_no).getMenuName();
		String countStr = count + "";
		String priceStr = (food.get(foo_no).getPrice() * count) + "";
		s.add(name);
		s.add(countStr);
		s.add(priceStr);
		orderList.add(s);
	}


	public void foodOrderInput() {
		System.out.print("���� ���� �Է� >> ");
		int foodNum = scan.nextInt();
		System.out.print("���� ���� �Է� >>");
		int count = scan.nextInt();
		foodOrder(foodNum, count);
	}

	// ���� ���
	public void clearAllOrderMenu() {
		Iterator<Integer> mapIter = food.keySet().iterator();
		while (mapIter.hasNext()) {
			Integer i = mapIter.next();
			food.get(i).setFoodCount(foodBackup.get(i).getFoodCount());
			orderList.clear();
		}
		setPayMoney(0);
	}

	public void testCancelMenu() {
		System.out.print("� �޴��� ����Ͻðڽ��ϱ�? ");
		String menu = scan.next();
		cancelOrderMenu(menu);
	}
	
	// �κ� ���
	public void cancelOrderMenu(String foodName) {
		Iterator<Integer> mapIter = food.keySet().iterator();
		while (mapIter.hasNext()) {
			Integer i = mapIter.next();
			if (food.get(i).getMenuName().equals(foodName)) {
				// �ֹ����� ���� �� ���� ������
				food.get(i).setFoodCount(foodBackup.get(i).getFoodCount());
				cancelOrderList(foodName);
				break;
			}
		}
	}

	// �ֹ� ���� �κ� ã��
	public void cancelOrderList(String foodName) {
		for(int i = 0; i < orderList.size(); i++) {
			for(int j = 0; j < orderList.get(i).size(); i++) {
				if(orderList.get(i).contains(foodName)) {
					orderList.remove(i);
					return;
				}
			}
		}
	}

	public void printOrderList() {
		Iterator<ArrayList<String>> list = orderList.iterator();
		while (list.hasNext()) {
			ArrayList<String> order = list.next();
			for (int i = 0; i < order.size(); i++) {
				System.out.print(order.get(i) + " ");
			}
			System.out.println();

		}
	}

	// ��������� ������Ʈ �� ��� ����
	//
	public void pay() {
		Iterator<Integer> mapIter = food.keySet().iterator();
		while (mapIter.hasNext()) {
			Integer i = mapIter.next();
			foodBackup.get(i).setFoodCount(food.get(i).getFoodCount());
			System.out.println(food.get(i).getFoodCount() + " " + i);
			menuQuery.updateMenu(food.get(i).getFoodCount(), i);
		}
	}
	
	public int getPayMoney() {
		return this.payMoney;
	}
	
	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}

	public void excute() {
		while (true) {
			System.out.println("1. ���� ����Ʈ ��� \t 2. ���� �ֹ�\t 3.���� �ֹ� �κ� ���\t 4. ���� �ֹ� ��ü ���\t 5. �ֹ����� \t 6. ����");
			System.out.print("��ȣ �Է� >>> ");
			int num = scan.nextInt();

			switch (num) {
			case 1:
				break;
			case 2:
				foodOrderInput();
				break;
			case 3:
				testCancelMenu();
				break;
			case 4:
				clearAllOrderMenu();
				break;
			case 5:
				printOrderList();
				break;
			case 6:
				pay();
				System.out.println("�� ����� : " + getPayMoney());
				break;
			case 7:
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		FoodTest ft = new FoodTest();
		ft.excute();

	}
}
