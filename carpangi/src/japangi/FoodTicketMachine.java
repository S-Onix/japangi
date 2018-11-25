package japangi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import database.MenuDAO;
import item.MenuDTO;


public class FoodTicketMachine implements TicketMachine {

	static FoodTicketMachine ftm;
	// �ֹ� ����Ʈ(����, ����, ���� ����)
	Vector<Vector<String>> orderList;
	// DB������ ���� ��������
	MenuDAO menuQuery;
	// �޴��� �����ϱ� ���� ���� ����
	HashMap<Integer, MenuDTO> food;
	// ����ڰ� �ֹ� ��ҽ� ���� ���� �˰� �ϱ����� ���� ����
	HashMap<Integer, MenuDTO> foodBackup;
	// ����ڰ� �����ؾ��� �Ѿ�
	int payMoney = 0;

	public static FoodTicketMachine getInstance() {
		if(ftm == null) ftm = new FoodTicketMachine();
		return ftm;
	}

	public FoodTicketMachine() {
		menuQuery = new MenuDAO();
		food = new HashMap<>();
		foodBackup = new HashMap<>();
		orderList = new Vector<Vector<String>>();
		initFoodList();
	}

	/*
	 * DB�� �����͸� StringTokenizer�� ����
	 * ���е� �����ʹ� MenuDTO ��ü�� �����ϴµ� ����
	 * ���� �����Ϳ� ��� �����Ϳ� ������ ��ü�� ����(������ ��ü�� �ٸ�)
	 */
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
	 * �ֹ� ���� �޼ҵ�
	 */
	@Override
	public void selectMenu() {

	}

	/*
	 * �޼ҵ� Overloading 
	 * ������ ���� ��ȣ(��ư�� ��ȣ), �ֹ��� ������ ������ �̿� 
	 * �ֹ��� ���� HashMap�� ���� ��ȣ�� ã�� ������ ���� �ֹ� ����Ʈ�� �߰�
	 */
	public void selectMenu(int foodNum, int count) {
		food.get(foodNum).setFoodCount(food.get(foodNum).getFoodCount() - count);
		setPayMoney(getPayMoney() + (food.get(foodNum).getPrice() * count));
		addOrderList(foodNum, count);
	}
	
	public boolean isOrder(int foodNum, int count) {
		return (food.get(foodNum).getFoodCount() - count >= 0);	
	}
	
	public int getFoodCount(int foodNum) {
		return food.get(foodNum).getFoodCount();
	}
	
	public String getFoodName(int foodNum) {
		return food.get(foodNum).getMenuName();
	}

	/*
	 * ������ ���� ��ȣ�� ���� �ֹ� ����Ʈ�� �߰� 
	 * (�̸�, ����, ����) ������ ������ ����
	 */
	public void addOrderList(int foodNum, int count) {
		Vector<String> s = new Vector<String>();
		String name = food.get(foodNum).getMenuName();
		String countStr = count + "";
		String priceStr = (food.get(foodNum).getPrice() * count) + "";
		s.add(name);
		s.add(countStr);
		s.add(priceStr);
		orderList.add(s);
	}

	/*
	 * �ֹ� ��� ���� �޼ҵ� 
	 * 1. ��ü ��� 
	 * 2. �κ� ���
	 */

	/*
	 * �ֹ��� ������ ��ü ����ϴ� �޼ҵ� 
	 * foodBackup�� ����Ǿ� �ִ� ������ food �����Ϳ� ������ 
	 * �ֹ� ����Ʈ�� �ʱ�ȭ�� 
	 * ����ڰ� �����ؾ��� �ݾ� �ʱ�ȭ
	 */
	public void clearAllOrderMenu() {
		Iterator<Integer> mapIter = food.keySet().iterator();
		while (mapIter.hasNext()) {
			Integer i = mapIter.next();
			if(isChange(i))
				food.get(i).setFoodCount(foodBackup.get(i).getFoodCount());
		}
		orderList.clear();
		setPayMoney(0);
	}

	/*
	 * �κ� ���
	 * ������ �̸��� ã�� �ش� �ֹ������� �����
	 * ������ �ݾ��� �Ѿ� ����
	 * �̸����� �� ��� : ���̺��� �÷��� ������ �̸����� ������ ������(String)
	 * 
	 */
	public void cancelOrderMenu(String foodName) {
		Iterator<Integer> mapIter = food.keySet().iterator();
		while (mapIter.hasNext()) {
			Integer i = mapIter.next();
			if (food.get(i).getMenuName().equals(foodName)) {
				int count = foodBackup.get(i).getFoodCount()-food.get(i).getFoodCount();
				setPayMoney(getPayMoney() - food.get(i).getPrice()*count);
				cancelOrderList(foodName);
				food.get(i).setFoodCount(foodBackup.get(i).getFoodCount());
				break;
			}
		}
	}

	/*
	 * ������ �̸��� ���� ã�� �ֹ� ������ �����ϴ� �޼ҵ�
	 * */
	public void cancelOrderList(String foodName) {
		for (int i = 0; i < orderList.size(); i++) {
			for (int j = 0; j < orderList.get(i).size(); i++) {
				if (orderList.get(i).contains(foodName)) {
					orderList.remove(i);
					return;
				}
			}
		}
	}


	/*
	 * �Էµ� �ݾװ� ������ �Ѿ� �� ��� ��ȯ 
	 */
	public boolean checkMoney(int money) {
		return (money >= getPayMoney());
	}
	
	public boolean isChange(int foodNum) {
		return !(food.get(foodNum).getFoodCount() == foodBackup.get(foodNum).getFoodCount());
	}

	/*
	 * �������� �޼ҵ�
	 * 1. foodBackup ������ food �� �������� 
	 * 2. DB update
	 */
	@Override
	public void calculateMenu() {
		Iterator<Integer> mapIter = food.keySet().iterator();
		while (mapIter.hasNext()) {
			Integer i = mapIter.next();
//			if(food.get(i).getFoodCount() != foodBackup.get(i).getFoodCount()) {
			if(isChange(i)) {
				foodBackup.get(i).setFoodCount(food.get(i).getFoodCount());
				menuQuery.updateMenu(food.get(i).getFoodCount(), i);
			}
		}
	}
	
	public int getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}

	public Vector<Vector<String>> getOrderList() {
		return orderList;
	}	

}
