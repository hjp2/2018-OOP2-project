package Server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import parsing.javaparsing2;

public class BycycleServerTest {
///////////////////////////////////////////////////
	/////////////// 펌프 데이터 넣을 ArrayList ///////////////
	static ArrayList<ApiPump> dataP_Gangseo=new ArrayList<ApiPump>();
	static ArrayList<ApiPump> dataP_Geumjeong=new ArrayList<ApiPump>();
	static ArrayList<ApiPump> dataP_Nam=new ArrayList<ApiPump>();
	static ArrayList<ApiPump> dataP_Dong=new ArrayList<ApiPump>();
	static ArrayList<ApiPump> dataP_Dongnae=new ArrayList<ApiPump>();
	static ArrayList<ApiPump> dataP_Busanjin=new ArrayList<ApiPump>();
	static ArrayList<ApiPump> dataP_Buk=new ArrayList<ApiPump>();
	static ArrayList<ApiPump> dataP_Saha=new ArrayList<ApiPump>();
	static ArrayList<ApiPump> dataP_Sasang=new ArrayList<ApiPump>();
	static ArrayList<ApiPump> dataP_Seo=new ArrayList<ApiPump>();
	static ArrayList<ApiPump> dataP_Suyeong=new ArrayList<ApiPump>();
	static ArrayList<ApiPump> dataP_Yeonje=new ArrayList<ApiPump>();
	static ArrayList<ApiPump> dataP_Yeongdo=new ArrayList<ApiPump>();
	static ArrayList<ApiPump> dataP_Jung=new ArrayList<ApiPump>();
	static ArrayList<ApiPump> dataP_Heaundae=new ArrayList<ApiPump>();
	static ArrayList<ApiPump> dataP_Gijang=new ArrayList<ApiPump>();

	///////////////////////////////////////////////////
	/////////////// 보관소 데이터 넣을 ArrayList ///////////////
	static ArrayList<ApiValue> data_Gangseo=new ArrayList<ApiValue>();
	static ArrayList<ApiValue> data_Geumjeong=new ArrayList<ApiValue>();
	static ArrayList<ApiValue> data_Nam=new ArrayList<ApiValue>();
	static ArrayList<ApiValue> data_Dong=new ArrayList<ApiValue>();
	static ArrayList<ApiValue> data_Dongnae=new ArrayList<ApiValue>();
	static ArrayList<ApiValue> data_Busanjin=new ArrayList<ApiValue>();
	static ArrayList<ApiValue> data_Buk=new ArrayList<ApiValue>();
	static ArrayList<ApiValue> data_Saha=new ArrayList<ApiValue>();
	static ArrayList<ApiValue> data_Sasang=new ArrayList<ApiValue>();
	static ArrayList<ApiValue> data_Seo=new ArrayList<ApiValue>();
	static ArrayList<ApiValue> data_Suyeong=new ArrayList<ApiValue>();
	static ArrayList<ApiValue> data_Yeonje=new ArrayList<ApiValue>();
	static ArrayList<ApiValue> data_Yeongdo=new ArrayList<ApiValue>();
	static ArrayList<ApiValue> data_Jung=new ArrayList<ApiValue>();
	static ArrayList<ApiValue> data_Heaundae=new ArrayList<ApiValue>();

	///////////////////////////////////////////////////
	//////ArrayList static으로 선언-> 좋은 방식은 아니니까 다른 방법으로 바꿀수 있는지 찾아볼것.... 
	//////리스트에 저장되어야 할 값이 저장되지 않아서 부득이하게 static 선언했음
	
	
	//****** 펌프 데이터 불러오는 함수 ******//
	public void changePApiMain(String gugun, String spot) {
		ApiPump tmp=new ApiPump();
		
		if(gugun.equals("강서구")) {
			tmp.setPgugun(gugun);
			tmp.setPspot(spot);
			dataP_Gangseo.add(tmp);
		}
		if(gugun.equals("금정구")) {
			tmp.setPgugun(gugun);
			tmp.setPspot(spot);
			dataP_Geumjeong.add(tmp);
		}
		if(gugun.equals("기장군")) {
			tmp.setPgugun(gugun);
			tmp.setPspot(spot);
			
			dataP_Gijang.add(tmp);
		}
		if(gugun.equals("남구")) {
			tmp.setPgugun(gugun);
			tmp.setPspot(spot);
			
			dataP_Nam.add(tmp);
		}
		if(gugun.equals("동구")) {
			tmp.setPgugun(gugun);
			tmp.setPspot(spot);
			
			dataP_Dong.add(tmp);
		}
		if(gugun.equals("동래구")) {
			tmp.setPgugun(gugun);
			tmp.setPspot(spot);
			
			dataP_Dongnae.add(tmp);
		}
		if(gugun.equals("부산진구")) {
			tmp.setPgugun(gugun);
			tmp.setPspot(spot);
			
			dataP_Busanjin.add(tmp);
		}
		if(gugun.equals("북구")) {
			if(!spot.equals("＂")) {
				tmp.setPgugun(gugun);
				tmp.setPspot(spot);
				
				dataP_Buk.add(tmp);}
		}
		if(gugun.equals("낙동강관리본부")) {
			tmp.setPgugun("북구");
			tmp.setPspot(gugun+" "+spot);
			
			dataP_Buk.add(tmp);
		}
		if(gugun.equals("사하구")) {
			tmp.setPgugun(gugun);
			tmp.setPspot(spot);
			
			dataP_Saha.add(tmp);
		}
		if(gugun.equals("사상구")) {
			tmp.setPgugun(gugun);
			tmp.setPspot(spot);
			
			dataP_Sasang.add(tmp);
		}
		if(gugun.equals("서구")) {
			tmp.setPgugun(gugun);
			tmp.setPspot(spot);
		
			dataP_Seo.add(tmp);
		}
		if(gugun.equals("수영구")) {
			tmp.setPgugun(gugun);
			tmp.setPspot(spot);
			
			dataP_Suyeong.add(tmp);
		}
		if(gugun.equals("연제구")) {
			tmp.setPgugun(gugun);
			tmp.setPspot(spot);
			
			dataP_Yeonje.add(tmp);
		}
		if(gugun.equals("영도구")) {
			tmp.setPgugun(gugun);
			tmp.setPspot(spot);
			
			dataP_Yeongdo.add(tmp);
		}
		if(gugun.equals("중구")) {
			tmp.setPgugun(gugun);
			tmp.setPspot(spot);
			
			dataP_Jung.add(tmp);
		}
		if(gugun.equals("해운대구")) {
			tmp.setPgugun(gugun);
			tmp.setPspot(spot);
			
			dataP_Heaundae.add(tmp);
		}
	}
	
	//****** 보관소 데이터 불러오는 함수 ******//
	public void changeApiMain(String gugun, String spot, String spotgubun) {
		ApiValue tmp=new ApiValue();
		
		/////////파싱해온 데이터의 키값(구군)을 기준으로 나눈 리스트에 저장한다.
		if(gugun.equals("부산광역시 강서구청")) {
			tmp.setGugun(gugun);
			tmp.setSpot(spot);
			tmp.setSpotgubun(spotgubun);
			data_Gangseo.add(tmp);
		}
		
		else if(gugun.equals("부산광역시 금정구청")) {
			tmp.setGugun(gugun);
			tmp.setSpot(spot);
			tmp.setSpotgubun(spotgubun);
			data_Geumjeong.add(tmp);
		}
		
		else if(gugun.equals("부산광역시 남구청")) {
			tmp.setGugun(gugun);
			tmp.setSpot(spot);
			tmp.setSpotgubun(spotgubun);
			data_Nam.add(tmp);
		}
		
		else if(gugun.equals("부산광역시 동구")) {
			tmp.setGugun(gugun);
			tmp.setSpot(spot);
			tmp.setSpotgubun(spotgubun);
			data_Dong.add(tmp);
		}
		
		else if(gugun.equals("부산광역시 동래구")) {
			tmp.setGugun(gugun);
			tmp.setSpot(spot);
			tmp.setSpotgubun(spotgubun);
			data_Dongnae.add(tmp);
		}
		
		else if(gugun.equals("부산광역시 부산진구")) {
			tmp.setGugun(gugun);
			tmp.setSpot(spot);
			tmp.setSpotgubun(spotgubun);
			data_Busanjin.add(tmp);
		}
		
		else if(gugun.equals("부산광역시 북구청")) {
			tmp.setGugun(gugun);
			tmp.setSpot(spot);
			tmp.setSpotgubun(spotgubun);
			data_Buk.add(tmp);
		}
		
		else if(gugun.equals("부산광역시 사하구청")) {
			tmp.setGugun(gugun);
			tmp.setSpot(spot);
			tmp.setSpotgubun(spotgubun);
			data_Saha.add(tmp);
		}
		
		else if(gugun.equals("부산광역시 사상구청")) {
			tmp.setGugun(gugun);
			tmp.setSpot(spot);
			tmp.setSpotgubun(spotgubun);
			data_Sasang.add(tmp);
		}
		
		else if(gugun.equals("부산광역시 서구")) {
			tmp.setGugun(gugun);
			tmp.setSpot(spot);
			tmp.setSpotgubun(spotgubun);
			data_Seo.add(tmp);
		}
		
		else if(gugun.equals("부산광역시 수영구청")) {
			tmp.setGugun(gugun);
			tmp.setSpot(spot);
			tmp.setSpotgubun(spotgubun);
			data_Suyeong.add(tmp);
		}
		
		else if(gugun.equals("부산광역시 연제구청")) {
			tmp.setGugun(gugun);
			tmp.setSpot(spot);
			tmp.setSpotgubun(spotgubun);
			data_Yeonje.add(tmp);
		}
		
		else if(gugun.equals("부산광역시 영도구청")) {
			tmp.setGugun(gugun);
			tmp.setSpot(spot);
			tmp.setSpotgubun(spotgubun);
			data_Yeongdo.add(tmp);
		}
		
		else if(gugun.equals("부산광역시 중구")) {
			tmp.setGugun(gugun);
			tmp.setSpot(spot);
			tmp.setSpotgubun(spotgubun);
			data_Jung.add(tmp);
		}
		else if(gugun.equals("부산광역시 해운대구청")) {
			tmp.setGugun(gugun);
			tmp.setSpot(spot);
			tmp.setSpotgubun(spotgubun);
			data_Heaundae.add(tmp);
		}
	}
	
	public void totalPrint(ArrayList<ApiPump> tmp) {//배열 안에 있는 데이터 출력하는 함수
		for(ApiPump apidataP:tmp) {					//데이터 잘 들어갔는지 확인하는 용도로 사용했음
				apidataP.printData();
		}
	}
	
	//////////////////////////////////서버 돌리기///////////////////////////////////////
	public void goServer() {
		
		ServerSocket serverSocket=null;
		Socket serverB=null;
		ObjectOutputStream oos=null;
		InputStream in=null;
		OutputStream out=null;
		DataInputStream reader=null;
		//DataOutputStream writer=null;
		PrintWriter writer=null;
		///////////////////////// test/////////////////////
		BufferedReader testreader=null;
		InputStreamReader streamReader=null;
		///////////////////////////////////////////////////
		
		try {
			serverSocket = new ServerSocket(14545);//서버 소켓 생성 - 포트번호 14545
			System.out.println("서버 연결 기다림");
			serverB=serverSocket.accept();//클라이언트 연결 요청수락
			
			in=serverB.getInputStream();
			out=serverB.getOutputStream();
			
			streamReader=new InputStreamReader(serverB.getInputStream());
			testreader=new BufferedReader(streamReader);
			
			OutData outdata = new OutData();
			
			/////////////////밑에 있는거 나중에 쓰기
			//reader=new DataInputStream(in);//데이터 입력받는 스트림
			//writer=new DataOutputStream(out);//데이터 보내는 스트림
			writer= new PrintWriter(serverB.getOutputStream());
			oos=new ObjectOutputStream(out);//객체 출력 스트림-사용할 수 있으면 사용하고 아니면 지우기
			
			reader=new DataInputStream(in);
			////// 서버 - 클라이언트 연결 되었음을 출력 //////
			InetAddress clientHost=serverB.getLocalAddress();
			int clientPort=serverB.getPort();
			System.out.println("Client 연결. host: " + clientHost + ", post" + clientPort);//연결하였음을 출력
			
			
			String code;
			code=reader.readUTF();//사용자가 입력한 값 msg에 넣음
			
			System.out.println("입력받은 값: " +code);//클라이언트에서 입력받은 값 출력
			
			
			
			while(true) {
			
			System.out.println("신호를 기다림");
			
			String msg=null;
			
			msg=reader.readUTF();//사용자가 입력한 값 msg에 넣음
			
			System.out.println("입력받은 값: " +msg);//클라이언트에서 입력받은 값 출력
			
			if(msg.equals("EXIT")) {//사용자가 입력한 값이 EXIT면 프로그램 종료
				break;
			}
			int checkNum=0;
			if((msg.equals("pump")|(msg.equals("rent")))) {
				code=msg;
			}
			else {
				checkNum=Integer.parseInt(msg);//찾을 항목 값
			}
			

			if(code.equals("rent")) {//사용자가 입력한 값이 EXIT면 프로그램 종료
				System.out.println("돌아감");
			//클라이언트가 입력한 값에 따라 맞는 데이터 값 출력해줌 -> GUI 호환하면 클라이언트가 누르는 버튼 이벤트에서 실행될것
			if(checkNum==0) {//강서구
				
				//writer.write(data_Gangseo.size());
				System.out.println("강서구 데이터 전송");
				outdata.rentData(writer, data_Gangseo);
				//oos.writeObject(data_Gangseo.get(1));
				/*
				for(ApiValue writeApiData:data_Gangseo) {
					oos.writeObject(writeApiData);
				writer.writeUTF(writeApiData.getGugun());
				writer.writeUTF(writeApiData.getSpot());
				writer.writeUTF(writeApiData.getSpotgubun());
					oos.flush();
				}*/
				//apiChangeData printapi=new apiChangeData();
				//printapi.totalPrint(data_Gangseo);
			}
			
			if(checkNum==1) {//금정구 
				outdata.rentData(writer, data_Geumjeong);
			}
			
			if(checkNum==2) {//남구
				outdata.rentData(writer, data_Nam);
			}
			
			if(checkNum==3) {//동구
				outdata.rentData(writer, data_Dong);
			}
			
			if(checkNum==4) {//동래구
				outdata.rentData(writer, data_Dongnae);
			}
			
			if(checkNum==5) {//부산진구
				outdata.rentData(writer, data_Busanjin);
			}
			
			if(checkNum==6) {//북구
				outdata.rentData(writer, data_Buk);
			}
			if(checkNum==7) {//사하구
				outdata.rentData(writer, data_Saha);
			}
			if(checkNum==8) {
				outdata.rentData(writer, data_Sasang);
			}
			if(checkNum==9) {
				outdata.rentData(writer, data_Seo);
			}
			if(checkNum==10) {
				outdata.rentData(writer, data_Suyeong);
			}
			if(checkNum==11) {
				outdata.rentData(writer, data_Yeonje);
			}
			if(checkNum==12) {
				outdata.rentData(writer, data_Yeongdo);
			}
			if(checkNum==13) {
				outdata.rentData(writer, data_Jung);
			}
			if(checkNum==14) {
				outdata.rentData(writer, data_Heaundae);
			}
			//~15번까지 있을 예정인데 더 효율적으로 할 수 있는 방법이 있는지 찾아볼것 근데 버튼으로 할거라서 굳이 없을듯
			//이 부분만 GUI에 넣으면 되는지
			
			//종료//
			
			}
			
			if(code.equals("pump")) {
				System.out.println("돌아감");
				
				//클라이언트가 입력한 값에 따라 맞는 데이터 값 출력해줌 -> GUI 호환하면 클라이언트가 누르는 버튼 이벤트에서 실행될것
				if(checkNum==0) {//강서구
					
					//writer.write(data_Gangseo.size());
					System.out.println("강서구 데이터 전송");
					outdata.rentData(writer, data_Gangseo);
					//oos.writeObject(data_Gangseo.get(1));
					/*
					for(ApiValue writeApiData:data_Gangseo) {
						oos.writeObject(writeApiData);
					writer.writeUTF(writeApiData.getGugun());
					writer.writeUTF(writeApiData.getSpot());
					writer.writeUTF(writeApiData.getSpotgubun());
						oos.flush();
					}*/
					//apiChangeData printapi=new apiChangeData();
					//printapi.totalPrint(data_Gangseo);
				}
				
				if(checkNum==1) {//금정구 
					outdata.pumpData(writer, dataP_Geumjeong);
				}
				
				if(checkNum==2) {//기장군
					outdata.pumpData(writer, dataP_Gijang);
				}
				
				if(checkNum==3) {//남구
					outdata.pumpData(writer, dataP_Nam);
				}
				
				if(checkNum==4) {//동구
					outdata.pumpData(writer, dataP_Dong);
				}
				
				if(checkNum==5) {//동래구
					outdata.pumpData(writer, dataP_Dongnae);
				}
				
				if(checkNum==6) {//부산진
					outdata.pumpData(writer, dataP_Busanjin);
				}
				if(checkNum==7) {//북구
					outdata.pumpData(writer, dataP_Buk);
				}
				if(checkNum==8) {//사하구
					outdata.pumpData(writer, dataP_Saha);
				}
				if(checkNum==9) {//사상구
					for(ApiPump writeApiData:dataP_Sasang) {
						//writer.println(writeApiData.getPgugun());
						writer.println(writeApiData.getPspot());
						
						writer.flush();
					}
					writer.println("END");
					writer.flush();
				}
				if(checkNum==10) {//서구
					for(ApiPump writeApiData:dataP_Seo) {
						//writer.println(writeApiData.getPgugun());
						writer.println(writeApiData.getPspot());
						
						writer.flush();
					}
					writer.println("END");
					writer.flush();
				}
				if(checkNum==11) {//수영구
					for(ApiPump writeApiData:dataP_Suyeong) {
						//writer.println(writeApiData.getPgugun());
						writer.println(writeApiData.getPspot());
						
						writer.flush();
					}
					writer.println("END");
					writer.flush();
				}
				if(checkNum==12) {//연제구
					for(ApiPump writeApiData:dataP_Yeonje) {
						//writer.println(writeApiData.getPgugun());
						writer.println(writeApiData.getPspot());
						
						writer.flush();
					}
					writer.println("END");
					writer.flush();
				}
				if(checkNum==13) {//영도구
					for(ApiPump writeApiData:dataP_Yeongdo) {
						//writer.println(writeApiData.getPgugun());
						writer.println(writeApiData.getPspot());
						
						writer.flush();
					}
					writer.println("END");
					writer.flush();
				}
				if(checkNum==14) {//중구
					for(ApiPump writeApiData:dataP_Jung) {
						//writer.println(writeApiData.getPgugun());
						writer.println(writeApiData.getPspot());
						
						writer.flush();
					}
					writer.println("END");
					writer.flush();
				}
				if(checkNum==15) {//해운대구
					for(ApiPump writeApiData:dataP_Heaundae) {
						//writer.println(writeApiData.getPgugun());
						writer.println(writeApiData.getPspot());
						
						writer.flush();
					}
					writer.println("END");
					writer.flush();
				}
			}
			}
			
			
		}catch(IOException ex){
			ex.printStackTrace();
		}finally {
			System.out.println("서버 종료");
			try {
				if(writer!=null) writer.close();
				if(reader!=null) reader.close();
				if(in!=null) in.close();
				if(out!=null) out.close();
				if(oos!=null) oos.close();
				if(serverB!=null) serverB.close();
				if(serverSocket!=null) serverSocket.close();
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		
		}
	
	public static void main(String[] args) {
		BycycleServerTest server=new BycycleServerTest();
		OpenApiI makeApi=new OpenApiI();
		javaparsing2 makePump=new javaparsing2();
		
		makeApi.go();//파싱 실행
		makePump.go();
		
		//server.totalPrint(dataP_Heaundae);
		
		server.goServer();//서버 실행
		
	}
}
