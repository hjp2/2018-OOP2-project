package Server;

public class ApiPump {
	private String pgugun;
	private String pspot;
	
	////////////////////////////////////////////
	////////////////////////////////////////////
	public String getPgugun() {
		return pgugun;
	}
	public void setPgugun(String pgugun) {
		this.pgugun = pgugun;
	}
	////////////////////////////////////////////
	////////////////////////////////////////////
	public String getPspot() {
		return pspot;
	}
	public void setPspot(String pspot) {
		this.pspot = pspot;
	}
	////////////////////////////////////////////
	////////////////////////////////////////////
	
	public void printData() {
		System.out.println("***************************");
		System.out.println("구: "+pgugun);
		System.out.println("위치: "+pspot);
		System.out.println("***************************");
	}
}
