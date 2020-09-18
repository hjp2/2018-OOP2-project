package Server;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class OpenApiI {
	 private static String getTagValue(String tag, Element eElement) {
	      NodeList nlist = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	      Node nValue = (Node)nlist.item(0);
	      if(nValue == null)
	         return null;
	      return nValue.getNodeValue();
	 }
	   public void go() {
	      int page = 1;
	      try {
	   
	         while(true) {
	            String urlstr = "http://apis.data.go.kr/6260000/BusanBicycleInfoService/getBicycleRackInfo?ServiceKey=e3qOlG%2BKl93HshV1j8kCNt1aOmWKhY6mq3BW7YubOsH%2BidlhD5PAokSEAyVhwSitcAivDxKp9ZxfDULnWI7RNg%3D%3D&pageNo="+page;
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.parse(urlstr);
	    
	            doc.getDocumentElement().normalize();
	           // System.out.println("Root element : " + doc.getDocumentElement());
	    
	            NodeList nList = doc.getElementsByTagName(""+ "item");
	            
	            BycycleServerTest changeS=new BycycleServerTest();
	            
	            for(int temp = 0;temp < nList.getLength(); temp++) {
	               Node nNode = nList.item(temp);
	               if(nNode.getNodeType() == Node.ELEMENT_NODE) {
	                  Element eElement = (Element) nNode;
	                  /*
	                  System.out.println("########################");
	                  System.out.println("구 : " + getTagValue("instt",eElement));
	                  System.out.println("위치 : " + getTagValue("spot", eElement));
	                  System.out.println("주소 : " + getTagValue("spotGubun", eElement));
	                  */
	                  String instt=(String)getTagValue("instt", eElement);
	                  String spot=(String)getTagValue("spot", eElement);
	                  String spotgubun=(String)getTagValue("spotGubun", eElement);
	                  
	                  changeS.changeApiMain(instt, spot, spotgubun);//파싱된 데이터 Arraylist에 저장하기 위한 함수
	               }
	            }
	            page = page + 1;
	            //System.out.println("page number : " + page);
	            if(page > 96) {
	               break;
	            }

	         }
	         
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	      }
	   }
}