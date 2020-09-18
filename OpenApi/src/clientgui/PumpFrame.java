package clientgui;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Server.ApiValue;

import java.awt.Color;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTextField;

public class PumpFrame extends JFrame {
	
	public GoogleApi googleApi = new GoogleApi();
	private JLabel googleMap = new JLabel();
	private ArrayList<String> jang_so=new ArrayList<String>();
	public int guIndex;
	static Socket socket=null;
	private JPanel contentPane;
	private String Area[] = {"강서구", "금정구", "기장군", "남구", "동구", "동래구", "부산진구", "북구", "사하구", "사상구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구"};
	String Sel[];
	JScrollPane scrollPane_1=null;
	
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PumpFrame frame = new PumpFrame(socket);		
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public PumpFrame(Socket s) {
		guIndex=20;
		socket=s;
		//socket=setNetwork(socket);//network연결
		try {
			sendFrame(socket);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setTitle("펌프 주입소 찾기");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setMap("부산");
		
		
		JLabel lblSelectCity = new JLabel("구 선택");
		lblSelectCity.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblSelectCity.setBounds(24, 25, 111, 15);
		contentPane.add(lblSelectCity);
		
		JLabel resultText = new JLabel("장소선택");
		resultText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		resultText.setBounds(246, 25, 111, 15);
		contentPane.add(resultText);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 58, 192, 178);
		contentPane.add(scrollPane);
		
		JList gu = new JList(Area);
		scrollPane.setViewportView(gu);
		gu.addListSelectionListener(new ListSelectionListener() {
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                	jang_so.clear();
	                	System.out.println(gu.getSelectedIndex());
	                	int index=gu.getSelectedIndex();
	                	setGuIndex(index);
	                    System.out.println(gu.getSelectedValuesList());
	                   
	                    gThread gthread = new gThread();
	            		
	            		Thread g=new Thread(gthread);
	            		
	            		g.start();
	                }
	            }
		});

		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(246, 58, 172, 178);
		contentPane.add(scrollPane_1);
				
	}
	
	public void setMap(String location) {
		googleApi.downloadMap(location);
		googleMap.setIcon(googleApi.getMap(location));
		googleMap.setBounds(78, 288, 300, 300);
		googleApi.fileDelete(location);
		contentPane.add(googleMap);
	}
	
	public void cList() { //JList jangso, JScrollPane scrollPane_1
		
		int size=jang_so.size();
		Sel=new String[size];
		
		for(int i=0;i<size;i++) {
			Sel[i]=jang_so.get(i);
			System.out.println("위치: "+Sel[i]);
		}
		
		JList jangso = new JList(Sel);
		
		
		scrollPane_1.setViewportView(jangso);
		
		jangso.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                	setMap(jangso.getSelectedValuesList().toString());
                	System.out.println(jangso.getSelectedValuesList().toString());
    

                }
            }
		});
		
		
	}
	
	
	
	public void setGuIndex(int index) {
		guIndex = index;
		System.out.println("index: "+guIndex);
	}
	
	public int getGuIndex() {
		int index=guIndex;
		return index;
	}
	
	
	public void goC() {
		
		gThread gthread = new gThread();
		
		Thread g=new Thread(gthread);
		
		g.start();
	}
	
	public class gThread implements Runnable{
		
		
		public void run() {
			
			getData();
		}
		public void getData() {
			//InputStream in=null;
			OutputStream out=null;
			//DataInputStream reader=null;
			DataOutputStream writer=null;
			InputStreamReader streamReader=null;
			BufferedReader reader=null;
			//PrintWriter writer=null;
			
			try {
				System.out.println("start");
				
					int index=getGuIndex();
					
					if(index!=20) {
						Socket s=getSocket();
						//in=s.getInputStream();
						out=s.getOutputStream();
						//reader=new DataInputStream(in);//입력스트림-데이터 읽어오기
						writer=new DataOutputStream(out);//출력스트림-데이터 보내기
						//writer=new PrintWriter(s.getOutputStream());
						streamReader=new InputStreamReader(s.getInputStream());
						reader=new BufferedReader(streamReader);
						
						System.out.println("s: "+index);
						String test = Integer.toString(index);
						System.out.println("s: "+test);
					
						writer.writeUTF(test);
						//writer.writeUTF(str);//사용자가 입력한 값 출력버퍼에 넣음
						writer.flush();//서버로 전송
				
						////// 서버가 보낸 데이터 받기 //////
						//dataThread dataT=new dataThread(reader);
						//Thread dThread=new Thread(dataT);
						//dThread.start();
						printdata(reader);
						
						System.out.println("clear");
						setGuIndex(20);
						}//데이터 보내는 while문 끝
						
				//System.out.println("exit");
		
				}catch(IOException ex) {
					ex.printStackTrace();
				}finally {
					System.out.println("클라이언트 종료");
					/*try {
						if(reader!=null) reader.close();
						if(writer!=null) writer.close();
						//if(in!=null) in.close();
						//if(streamReader!=null) streamReader.close();
						out.close();
						//if(s!=null) s.close();
						if(socket!=null) socket.close();
					}catch(IOException ex) {
						ex.printStackTrace();
					}*/
				}
				System.out.println("gThread 종료");
			}
		
		
	}
	private Socket getSocket() {
		return this.socket;
	}
	private Socket setNetwork(Socket socket) {
		try {
			socket=new Socket("localhost", 14545);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return socket;
	}
	
	
	public void sendFrame(Socket socket) throws IOException {
		OutputStream os=null;
		DataOutputStream dos=null;
		try {
			os=socket.getOutputStream();
			dos=new DataOutputStream(os);
		
			dos.writeUTF("pump");
			dos.flush();
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			//dos.close();
			//os.close();
		}
	}

	
	public class dataThread implements Runnable{
		BufferedReader reader=null;
		
		public dataThread(BufferedReader dos) {
			reader=dos;
		}
		
		public void run() {
			
			printdata(reader);
		}
		
		private void printdata(BufferedReader dos) {
			try {
			String data="a";
			int count=0;
			while(!data.equals("END")) {
				System.out.println("***************************");
				data=dos.readLine();//다음 데이터 읽어오기
				System.out.println("위치: "+data);
				jang_so.add(data);
				
				count++;
				}
			System.out.println("데이터 모두 받음");
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	private void printdata(BufferedReader dos) {
		try {
		String data="a";
		int count=0;
		while(!data.equals("END")) {
			System.out.println("***************************");
			data=dos.readLine();//다음 데이터 읽어오기
			//System.out.println("위치: "+data);
			jang_so.add(data);
			count++;
			}
		cList();
		System.out.println("데이터 모두 받음");
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
}