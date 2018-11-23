package item;

public class MenuDTO {
	// 음식 번호, 메뉴 이름, 가격, 음식 색감, 조리법
	private int foodNum;
	private String menuName;
	private String menuType;
	private int price;
	private int foodCount;
	private String recipe;

	public MenuDTO() {

	}

	public MenuDTO(int foodNum, String menuName, String menuType, int price, int foodCount, String recipe) {
		this.foodNum = foodNum;
		this.menuName = menuName;
		this.menuType = menuType;
		this.price = price;
		this.foodCount = foodCount;
		this.recipe = recipe;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public void setFoodNum(int foodNum) {
		this.foodNum = foodNum;
	}

	public int getFoodNum() {
		return foodNum;
	}

	public void setFoodNum() {
		this.foodNum = foodNum;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getFoodCount() {
		return foodCount;
	}

	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

}
