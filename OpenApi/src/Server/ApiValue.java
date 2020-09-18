package Server;

public class ApiValue {
	
	//보관소//
	private String gugun;
	private String spot;
	private String spotgubun;
	
	
	//******* 보관소           //
	////////////////////////////////////////////
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	////////////////////////////////////////////
	////////////////////////////////////////////
	public String getSpot() {
		return spot;
	}
	public void setSpot(String spot) {
		this.spot = spot;
	}
	////////////////////////////////////////////
	////////////////////////////////////////////
	public String getSpotgubun() {
		return spotgubun;
	}
	public void setSpotgubun(String spotgubun) {
		this.spotgubun = spotgubun;
	}
	////////////////////////////////////////////
	////////////////////////////////////////////
	
	//******* 보관소 값 출력          //
	public void printData() {
		System.out.println("***************************");
		System.out.println("구: "+gugun);
		System.out.println("위치: "+spot);
		System.out.println("주소: "+spotgubun);
		System.out.println("***************************");
	}
}
