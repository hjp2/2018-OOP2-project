package clientgui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.ActionEvent;
public class MainFrame {
	private JFrame frame;
	Socket socket=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setTitle("부산 자전거");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public MainFrame() {
		socket=setNetwork(socket);
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 553, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFff = new JLabel("부산 자전거");
		lblFff.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblFff.setBounds(29, 23, 120, 44);
		frame.getContentPane().add(lblFff);
		
		JButton button = new JButton("자전거 보관소 찾기");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RentFrame rental = new RentFrame(socket);
				rental.setVisible(true);
			}
		});
		button.setBounds(62, 101, 166, 134);
		frame.getContentPane().add(button);
		
		JButton btPump = new JButton("펌프 주입소 찾기");
		btPump.setBounds(292, 101, 166, 134);
		btPump.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PumpFrame pump = new PumpFrame(socket);
				pump.setVisible(true);
			}
		});
		frame.getContentPane().add(btPump);
		
		JButton btRoad = new JButton("자전거 도로 찾기");
		btRoad.setBounds(62, 256, 166, 134);
		frame.getContentPane().add(btRoad);
		
		JButton btWearther = new JButton("날씨 확인하기");
		btWearther.setBounds(292, 256, 166, 134);
		frame.getContentPane().add(btWearther);
	}
	
	private Socket setNetwork(Socket socket) {
		try {
			socket=new Socket("localhost", 14545);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return socket;
	}
	
}