package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OutData {
	PrintWriter writer=null;
	
	public void rentData(PrintWriter pw, ArrayList<ApiValue> tmp) {
			writer=pw;
			for(ApiValue writeApiData:tmp) {
				writer.println(writeApiData.getGugun());
				writer.println(writeApiData.getSpot());
				writer.println(writeApiData.getSpotgubun());
				writer.flush();
			}
			writer.println("END");
			writer.flush();
			
	}
	
	
	public void pumpData(PrintWriter pw, ArrayList<ApiPump> tmp) {
		writer=pw;
		for(ApiPump writeApiData:tmp) {
			//writer.println(writeApiData.getPgugun());
			writer.println(writeApiData.getPspot());
			//writer.println(writeApiData.getPumpCnt());
			//writer.println(writeApiData.getPumpSetCost());
			//writer.println(writeApiData.getPumpGubun());
			writer.flush();
		}
		writer.println("END");
		writer.flush();
	}
	
	
}
