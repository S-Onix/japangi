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
	// 주문 리스트(음식, 수량, 가격 저장)
	Vector<Vector<String>> orderList;
	// DB연동을 위한 참조변수
	MenuDAO menuQuery;
	// 메뉴를 저장하기 위한 참조 변수
	HashMap<Integer, MenuDTO> food;
	// 사용자가 주문 취소시 이전 값을 알게 하기위한 참조 변수
	HashMap<Integer, MenuDTO> foodBackup;
	// 사용자가 지불해야할 총액
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
	 * DB의 데이터를 StringTokenizer로 구분
	 * 구분된 데이터는 MenuDTO 객체를 생성하는데 사용됨
	 * 원본 데이터와 백업 데이터에 생성된 객체를 저장(각각의 객체는 다름)
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
	 * 주문 관련 메소드
	 */
	@Override
	public void selectMenu() {

	}

	/*
	 * 메소드 Overloading 
	 * 음식의 고유 번호(버튼의 번호), 주문할 음식의 갯수를 이용 
	 * 주문시 음식 HashMap의 고유 번호를 찾아 수량을 변경 주문 리스트에 추가
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
	 * 음식의 고유 번호를 통해 주문 리스트에 추가 
	 * (이름, 수량, 가격) 정보를 가지고 있음
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
	 * 주문 취소 관련 메소드 
	 * 1. 전체 취소 
	 * 2. 부분 취소
	 */

	/*
	 * 주문한 음식을 전체 취소하는 메소드 
	 * foodBackup에 저장되어 있는 수량을 food 데이터에 적용함 
	 * 주문 리스트를 초기화함 
	 * 사용자가 지불해야할 금액 초기화
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
	 * 부분 취소
	 * 음식의 이름을 찾아 해당 주문내역을 취소함
	 * 지불할 금액의 총액 재계산
	 * 이름으로 한 까닭 : 테이블의 컬럼에 음식의 이름으로 나오기 때문에(String)
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
	 * 음식의 이름을 통해 찾은 주문 내역을 삭제하는 메소드
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
	 * 입력된 금액과 음식의 총액 비교 결과 반환 
	 */
	public boolean checkMoney(int money) {
		return (money >= getPayMoney());
	}
	
	public boolean isChange(int foodNum) {
		return !(food.get(foodNum).getFoodCount() == foodBackup.get(foodNum).getFoodCount());
	}

	/*
	 * 결제관련 메소드
	 * 1. foodBackup 현재의 food 로 갱신해줌 
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
