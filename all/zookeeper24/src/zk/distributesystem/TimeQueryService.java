package zk.distributesystem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeQueryService extends Thread{
	int port = 0;

	public TimeQueryService(int port) {
		this.port = port;
	}
	
	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(port);
			System.out.println("ҵ���߳��Ѱ󶨶˿� ::"+port+": ׼���������Ѷ�������.....");
			while(true) {
				Socket sc = ss.accept();
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
				out.write(new Date().toString());
				System.out.println(new Date().toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
