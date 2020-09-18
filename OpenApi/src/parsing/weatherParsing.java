package parsing;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


public class weatherParsing
{
	
	
	private static String getTagValue(String tag, Element eElement)
	{
		NodeList nlist = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node)nlist.item(0);
		if(nValue == null)
			return null;
		return nValue.getNodeValue();
	}
	
	public static void main(String[] args)
	{
		int i = 0;
		int weatherDate = 20181212;
		int wnxList[] = {97, 97, 98, 98, 97, 98, 98, 97, 99, 96, 98, 96, 98, 99, 96, 100};
		int wnyList[] = {74, 74, 75, 74, 75, 76, 75, 76, 75, 74, 77, 76, 76, 75, 75, 77};
		
		int page = 1;
		
		try
		{
			while(i<16)
			{
				
				while(page<10)
				{
					
					String urlstr = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?serviceKey=e3qOlG%2BKl93HshV1j8kCNt1aOmWKhY6mq3BW7YubOsH%2BidlhD5PAokSEAyVhwSitcAivDxKp9ZxfDULnWI7RNg%3D%3D&base_date="+weatherDate+"&base_time=0200"+"&nx="+wnxList[i]+"&ny="+wnyList[i]+"&numOfRows=10&pageSize=10&pageNo="+page;
					//url바뀌는 것 : 날짜, 위도 경도값, 전체 페이지
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(urlstr);
					
					doc.getDocumentElement().normalize();
					
					NodeList nList = doc.getElementsByTagName(""+"item");
					
					for(int temp = 0; temp<nList.getLength();temp++)
					{
						Node nNode = nList.item(temp);
						if(nNode.getNodeType() == Node.ELEMENT_NODE)
						{
							Element eElement = (Element)nNode;
							String str=(String)getTagValue("category", eElement);
							
							if(str.equals("POP")==true) {
								
								System.out.println("######################################");
								System.out.println("20181212 예보");
								System.out.println(getTagValue("fcstDate", eElement)+"의 날씨");
								System.out.println(getTagValue("fcstTime", eElement)+"시");
								System.out.println(getTagValue("category", eElement)+"=강수확률");
								System.out.println(getTagValue("fcstValue", eElement)+"%");
								System.out.println("nx : " + getTagValue("nx", eElement)+"ny : " + getTagValue(" ny", eElement) );
								
								
							}
							if(str.equals("TMN")==true)
							{
								/*
								String fcstDate = (String)getTagValue("fcstDate", eElement);
								String fcstTime = (String)getTagValue("fcstTime", eElement);
								String category = (String)getTagValue("category", eElement);
								*/
								
								System.out.println("######################################");
								System.out.println("20181212 오늘의 날씨");
								System.out.println(getTagValue("fcstDate", eElement)+"의 날씨");
								System.out.println(getTagValue("fcstTime", eElement)+"시");
								System.out.println(getTagValue("category", eElement)+"= 아침 최저 기온");
								System.out.println(getTagValue("fcstValue", eElement)+"도");
								System.out.println("nx : " + getTagValue("nx", eElement)+"ny : " + getTagValue("ny", eElement) );
								
							}
							if(str.equals("TMX")==true)
							{
								
								System.out.println("######################################");
								System.out.println("20181212 오늘의 날씨");
								System.out.println(getTagValue("fcstDate", eElement)+"의 날씨");
								System.out.println(getTagValue("fcstTime", eElement)+"시");
								System.out.println(getTagValue("category", eElement)+"= 낮 최고 기온");
								System.out.println(getTagValue("fcstValue", eElement)+"도");
								System.out.println("nx : " + getTagValue("nx", eElement)+"ny : " + getTagValue("ny", eElement) );
								
							}
						
							
							//파싱된 데이터를 ArrayList에 저장하기 위해 함수 필요.
						}
						
					}//for구문 끝
					
					page = page+1;
					
				}//while(page<20)끝
				
				i = i+1;
				
			}//while(true)끝
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
	
	