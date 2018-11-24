package japangi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

import database.MenuDAO;
import item.MenuDTO;

public class FoodTest {
	
	//주문 리스트(음식, 수량, 가격 저장)
	ArrayList<ArrayList<String>> orderList;
	//DB연동을 위한 참조변수
	MenuDAO menuQuery;
	
	//메뉴를 저장하기 위한 참조 변수
	HashMap<Integer, MenuDTO> food;
	//사용자가 주문 취소시 이전 값을 알게 하기위한 참조 변수
	HashMap<Integer, MenuDTO> foodBackup;
	//사용자가 지불해야할 총액
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
	 * 주문시 변경되야할 사항들
	 * 선택한 음식의 수량
	 * 주문 ㄹ
	 * */
	public void foodOrder(int foodNum, int count) {
		if ((food.get(foodNum).getFoodCount() - count) >= 0) {
			food.get(foodNum).setFoodCount(food.get(foodNum).getFoodCount() - count);
			setPayMoney(getPayMoney() + (food.get(foodNum).getPrice()*count));
			addOrderList(foodNum, count);
		} else {
			// 현재 남은 수량 출력
			System.out.println(food.get(foodNum).getFoodCount() + "만큼 남아있습니다");
			System.out.println("주문할 수 없습니다");
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
		System.out.print("음식 숫자 입력 >> ");
		int foodNum = scan.nextInt();
		System.out.print("음식 수량 입력 >>");
		int count = scan.nextInt();
		foodOrder(foodNum, count);
	}

	// 완전 취소
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
		System.out.print("어떤 메뉴를 취소하시겠습니까? ");
		String menu = scan.next();
		cancelOrderMenu(menu);
	}
	
	// 부분 취소
	public void cancelOrderMenu(String foodName) {
		Iterator<Integer> mapIter = food.keySet().iterator();
		while (mapIter.hasNext()) {
			Integer i = mapIter.next();
			if (food.get(i).getMenuName().equals(foodName)) {
				// 주문내역 삭제 및 수량 돌리기
				food.get(i).setFoodCount(foodBackup.get(i).getFoodCount());
				cancelOrderList(foodName);
				break;
			}
		}
	}

	// 주문 내역 부분 찾기
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

	// 백업데이터 업데이트 및 디비 동작
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
			System.out.println("1. 음식 리스트 출력 \t 2. 음식 주문\t 3.음식 주문 부분 취소\t 4. 음식 주문 전체 취소\t 5. 주문내역 \t 6. 결제");
			System.out.print("번호 입력 >>> ");
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
				System.out.println("총 결재액 : " + getPayMoney());
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
