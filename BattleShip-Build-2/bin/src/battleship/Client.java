package battleship;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	private DataInputStream dis;
	private DataOutputStream dos;
	private String received;

	public DataInputStream getDis() {
		return dis;
	}

	public void setDis(DataInputStream dis) {
		this.dis = dis;
	}

	public DataOutputStream getDos() {
		return dos;
	}

	public void setDos(DataOutputStream dos) {
		this.dos = dos;
	}

	public String getReceived() {
		return received;
	}

	public void setReceived(String received) {
		this.received = received;
	}

	public static void main(String[] args) throws IOException {
		byte[] ipAddr = new byte[] { (byte) 10, (byte) 128, (byte) 128, (byte) 128 };
		InetAddress ip = InetAddress.getByAddress(ipAddr);
		try (Socket s = new Socket("192.168.43.251", 55555);
				// obtaining input and out streams
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());) {
			s.setTcpNoDelay(true);
			// printing date or time as requested by client
			String received = dis.readUTF();
			System.out.println(received);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
