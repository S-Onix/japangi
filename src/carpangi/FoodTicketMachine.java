package carpangi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;

import database.MenuDAO;
import item.MenuDTO;

public class FoodTicketMachine implements TicketMachine {

	/*
	 * 장바구니, 결제, 수량 추가
	 * 
	 */

	// 시스템의 음식메뉴 초기화
	ArrayList<MenuDTO> menuList;
	// 사용자가 선택한 메뉴들의 집합
	ArrayList<MenuDTO> selectList;
	ArrayList<MenuDTO> ranSelList;
	
	//주문 내역 출력위한
	ArrayList<ArrayList<String>> orderList;
	
	MenuDAO menuQuery;

	public FoodTicketMachine() {
		menuList = new ArrayList<>();
		selectList = new ArrayList<>();
		ranSelList = new ArrayList<>();
		menuQuery = new MenuDAO();
		initFoodList();
	}

	public void initFoodList() {
		ArrayList<String> foodList = menuQuery.selectAllMenu();
		Iterator<String> i = foodList.iterator();
		
		while(i.hasNext()) {
			StringTokenizer st = new StringTokenizer(i.next(), "|");
			while(st.hasMoreTokens()) {
				MenuDTO food = new MenuDTO(
						Integer.parseInt(st.nextToken()),
						st.nextToken(),
						st.nextToken(),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						st.nextToken()
						);
				menuList.add(food);
			}
		}
	}
	
	public ArrayList<MenuDTO> getMenuList(){
		return menuList;
	}

	/*
	 * 랜덤 메뉴 선택시
	 */
	
	/*
	 * 1. 초기화된 객체에 가져오기
	 * 2. 조리법를 선택하여 ranSelList에 저장
	 * 3. 해당 객체들에 대한 갯수 도출 및 random을 통한 메뉴 선택
	 * 4. 취소시 ranSelList 비우기
	 * 5. 완료시 selectList에 해당 메뉴 저장 후 ranSelList 비우기
	 * 
	 * */
	
	/*
	 * UI에서 호출되어야함(랜덤매뉴 선택시)
	 * */
	public void ranSelectMenu(String foodRecipe) {
		Random ran = new Random();
		int food = ran.nextInt(findRanMenu(foodRecipe).size());
		selectList.add(ranSelList.get(food));
	}
	
	public void clearMenu() {
		selectList.clear();
	}
	

	/*
	 * 공통 사항
	 */
	@Override
	public void selectMenu() {
		
	}
	
	/*
	 * 선택 음식의 고유 번호에 의해 선택됨
	 * */
	public void selectMenu(int foodNum) {
		selectList.add(findMenu(foodNum));
	}
	
	/*
	 * 음식 객체를 찾아 상태값을 변경해주기 위한 코드
	 * ex > 음식 선택시 현재 잔존 수량 변경
	 * */
	public MenuDTO findMenu(int foodNum) {
		Iterator<MenuDTO> i = menuList.iterator();
		while(i.hasNext()) {
			MenuDTO food = i.next();
			if(food.getFoodNum() == foodNum)
				return food;
		}
		return null;
	}
	
	/*
	 * 조리방법에 의해 선택된 음식에 대한 정보 저장 위한 메소드
	 * */
	public ArrayList<MenuDTO> findRanMenu(String foodRecipe){
		Iterator<MenuDTO> i = menuList.iterator();
		while(i.hasNext()) {
			MenuDTO menu = i.next();
			if(menu.getRecipe().equals(foodRecipe))
				ranSelList.add(menu);
		}
		return ranSelList;
	}
	
	/*
	 * 다중 선택시 
	 * */
	public void selectMenu(int foodNum, int count) {
		// TODO Auto-generated method stub
		MenuDTO selectFood = new MenuDTO();
		for(int i = 0 ; i < menuList.size(); i++) {
			if(foodNum == menuList.get(i).getFoodNum()) {
				selectList.add(selectFood);
			}
		}
	}
	
	/*
	 * 선택된 음식들의 총액 반환
	 * */
	public int getTotalPrice() {
		int price = 0;
		for (int i = 0; i < selectList.size(); i++) {
			price += selectList.get(i).getPrice();
		}
		return price;
	}
	
	//지불금액에 대한 결과(분기 조건)
	public boolean checkMoney(int money) {
		if(money >= getTotalPrice()) {
			return true;
		}else return false;
	}
	
	//결제하면 db update
	@Override
	public void calculateMenu() {
		// TODO Auto-generated method stub
	}
	
	public void calculateMenu(int money) {
		if(checkMoney(money)) {
			//db업데이트
		}
	}
	
	
	
	
	public boolean isEmpty(MenuDTO menu) {
		if(menu.getFoodCount() != 0)
			return false;
		else return true;
	}

}
