package test;

import java.util.ArrayList;

import carpangi.FoodTicketMachine;
import item.MenuDTO;

public class DBActionTest {

	public static void main(String[] args) {
		FoodTicketMachine ftm = new FoodTicketMachine();
		ArrayList<MenuDTO> menu = ftm.getMenuList();
		
		for(int i = 0 ; i < menu.size(); i++) {
			System.out.println(menu.get(i).getMenuName());
		}
		
	}
}
