package by.home.seabattle.entity;

public enum CellDesignation {
	SHIP_ONE("⛴️"), FREE("​🔵"), SHIP_HALO("🌞"), WOUNDED("❎"), CELL("🔳");
	
	private String designation;
	
	private CellDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
