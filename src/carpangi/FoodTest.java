package carpangi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

import database.MenuDAO;
import item.MenuDTO;

public class FoodTest {
	ArrayList<MenuDTO> menuList;
	ArrayList<MenuDTO> backupMenuList;
	ArrayList<ArrayList<String>> orderList;
	MenuDAO menuQuery;
	HashMap<Integer, MenuDTO> data;
	HashMap<Integer, MenuDTO> backupData;
	Scanner scan;
	int money = 0;

	public FoodTest() {
		menuList = new ArrayList<>();
		backupMenuList = new ArrayList<>();
		menuQuery = new MenuDAO();
		initFoodList();
		data = new HashMap<>();
		backupData = new HashMap<>();
		setHashMap();
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
				int foo_price =  Integer.parseInt(st.nextToken());
				int foo_cnt =  Integer.parseInt(st.nextToken());
				String foo_recipe = st.nextToken();
				
				
				MenuDTO food = new MenuDTO(foo_no, foo_name, foo_type, foo_price, foo_cnt, foo_recipe);
				MenuDTO food2 = new MenuDTO(foo_no, foo_name, foo_type, foo_price, foo_cnt, foo_recipe);
				
				menuList.add(food);
				backupMenuList.add(food2);
				
			}
		}
	}

	public void testList() {
		ArrayList<String> s = new ArrayList<String>();
		s.add("햄버거");
		s.add("3");
		s.add("300000");
		orderList.add(s);
	}
	
	public void printArrayList() {
		Iterator<ArrayList<String>> i = orderList.listIterator();
		while(i.hasNext()) {
			ArrayList<String> temp = i.next();
			for(int list = 0 ; list < temp.size(); list++) {
				System.out.print(temp.get(list) + " ");
			}
			System.out.println();
		}
	}
	
	public void setHashMap() {
		for (int i = 1; i <= menuList.size(); i++) {
			data.put(menuList.get(i - 1).getFoodNum(), menuList.get(i - 1));
			backupData.put(backupMenuList.get(i - 1).getFoodNum(), backupMenuList.get(i - 1));
		}
	}
	
	public void printAll() {
		Iterator<Integer> mapIter = data.keySet().iterator();
		while(mapIter.hasNext()) {
			Integer i = mapIter.next();
			MenuDTO menu = data.get(i);
			MenuDTO back = backupData.get(i);
			System.out.println("원본 : " + menu.getMenuName() + " " + menu.getFoodCount());
			System.out.println("백업 : " + back.getMenuName() + " " + back.getFoodCount());
			
		}
	}
	
	public void foodOrder(int foodNum) {
		data.get(foodNum).setFoodCount(data.get(foodNum).getFoodCount()-1);
		
		money += data.get(foodNum).getPrice();
	}
	
	public void foodOrderInput() {
		System.out.print("음식 숫자 입력 >> ");
		int foodNum = scan.nextInt();
		foodOrder(foodNum);
	}
	
	//취소
	public void reverse() {
		Iterator<Integer> mapIter = data.keySet().iterator();
		while(mapIter.hasNext()) {
			Integer i = mapIter.next();
			data.get(i).setFoodCount(backupData.get(i).getFoodCount());
		}
		money = 0;
		printAll();
	}
	
	//백업데이터 업데이트 및 디비 동작
	public void pay() {
		Iterator<Integer> mapIter = data.keySet().iterator();
		while(mapIter.hasNext()) {
			Integer i = mapIter.next();
			backupData.get(i).setFoodCount(data.get(i).getFoodCount());
			System.out.println(data.get(i).getFoodCount() + " " + i);
			menuQuery.updateMenu(data.get(i).getFoodCount(), i);
		}
		printAll();
	}
	
	

	public void excute() {
		while (true) {
			System.out.println("1. 음식 리스트 출력 \t 2. 음식 주문\t 3. 음식 주문 취소\t 4. 결제");
			System.out.print("번호 입력 >>> ");
			int num = scan.nextInt();

			switch (num) {
			case 1:
				printAll();
				break;
			case 2:
				foodOrderInput();
				break;
			case 3:
				reverse();
				break;
			case 4:
				pay();
				System.out.println("총 결재액 : " + money);
				break;
			case 5:
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		FoodTest ft = new FoodTest();
//		ft.excute();
		ft.testList();
		ft.printArrayList();
	}
}
