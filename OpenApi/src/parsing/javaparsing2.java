package parsing;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import Server.BycycleServerTest;

import org.w3c.dom.Node;

public class javaparsing2 {
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
            String urlstr = "http://apis.data.go.kr/6260000/BusanBicycleInfoService/getAirInjectorInfo?serviceKey=DVc7v9%2Fc6FSsmZfjLHQ0xPaiAI0FTfykZzsNZ1%2BnT0DtK7m2OwsbvQuyTbOia%2F6XKObb7rPomxYH%2FkgXRiVv6Q%3D%3D&pageNo="+page;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(urlstr);
            BycycleServerTest changeS=new BycycleServerTest();
            
            doc.getDocumentElement().normalize();
            //System.out.println("Root element : " + doc.getDocumentElement());
            
            NodeList nList = doc.getElementsByTagName(""+ "item");
    
            for(int temp = 0;temp < nList.getLength(); temp++) {
               Node nNode = nList.item(temp);
               if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element eElement = (Element) nNode;
                 // System.out.println("########################");
                //  System.out.println("구군명 : " + getTagValue("gugun",eElement));
                //  System.out.println("위치 : " + getTagValue("spot", eElement));
                //  System.out.println("설치 수 : " + getTagValue("pumpCnt", eElement));
                //  System.out.println("주입기 가격 : " + getTagValue("pumpSetCost", eElement)); 
                //  System.out.println("주입기 구분 : " + getTagValue("pumpGubun", eElement));
                  
                  String gugun=(String)getTagValue("gugun",eElement);
                  String spot=(String)getTagValue("spot", eElement);
                  String pumpCnt=(String)getTagValue("pumpCnt", eElement);
                  String pumpSetCost=(String)getTagValue("pumpSetCost", eElement);
                  String pumpGubun=(String)getTagValue("pumpGubun", eElement);
                  
                  changeS.changePApiMain(gugun, spot);
               }
            }
            page = page + 1;
            //System.out.println("page number : " + page);
            if(page > 61) {
               break;
            }
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      }
   }
   }