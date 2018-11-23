package carpangi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;

import database.MenuDAO;
import item.MenuDTO;

public class FoodTicketMachine implements TicketMachine {

	/*
	 * ��ٱ���, ����, ���� �߰�
	 * 
	 */

	// �ý����� ���ĸ޴� �ʱ�ȭ
	ArrayList<MenuDTO> menuList;
	// ����ڰ� ������ �޴����� ����
	ArrayList<MenuDTO> selectList;
	ArrayList<MenuDTO> ranSelList;
	
	//�ֹ� ���� �������
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
	 * ���� �޴� ���ý�
	 */
	
	/*
	 * 1. �ʱ�ȭ�� ��ü�� ��������
	 * 2. �������� �����Ͽ� ranSelList�� ����
	 * 3. �ش� ��ü�鿡 ���� ���� ���� �� random�� ���� �޴� ����
	 * 4. ��ҽ� ranSelList ����
	 * 5. �Ϸ�� selectList�� �ش� �޴� ���� �� ranSelList ����
	 * 
	 * */
	
	/*
	 * UI���� ȣ��Ǿ����(�����Ŵ� ���ý�)
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
	 * ���� ����
	 */
	@Override
	public void selectMenu() {
		
	}
	
	/*
	 * ���� ������ ���� ��ȣ�� ���� ���õ�
	 * */
	public void selectMenu(int foodNum) {
		selectList.add(findMenu(foodNum));
	}
	
	/*
	 * ���� ��ü�� ã�� ���°��� �������ֱ� ���� �ڵ�
	 * ex > ���� ���ý� ���� ���� ���� ����
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
	 * ��������� ���� ���õ� ���Ŀ� ���� ���� ���� ���� �޼ҵ�
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
	 * ���� ���ý� 
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
	 * ���õ� ���ĵ��� �Ѿ� ��ȯ
	 * */
	public int getTotalPrice() {
		int price = 0;
		for (int i = 0; i < selectList.size(); i++) {
			price += selectList.get(i).getPrice();
		}
		return price;
	}
	
	//���ұݾ׿� ���� ���(�б� ����)
	public boolean checkMoney(int money) {
		if(money >= getTotalPrice()) {
			return true;
		}else return false;
	}
	
	//�����ϸ� db update
	@Override
	public void calculateMenu() {
		// TODO Auto-generated method stub
	}
	
	public void calculateMenu(int money) {
		if(checkMoney(money)) {
			//db������Ʈ
		}
	}
	
	
	
	
	public boolean isEmpty(MenuDTO menu) {
		if(menu.getFoodCount() != 0)
			return false;
		else return true;
	}

}
