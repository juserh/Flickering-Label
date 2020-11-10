package ch13;
import javax.swing.*;
import java.awt.*;
class FlickeringLabel extends JLabel implements Runnable{ //�̹� JLabel�� �޾Ƽ� extends Thread�� ��
	private long delay;
	public FlickeringLabel(String text, long delay) {
		super(text); //new JLabel("���ڿ�");
		this.delay=delay;
		setOpaque(true);
		Thread th=new Thread(this);
		th.start();
	}

	@Override
	public void run() {
		int n=0;
		Color[] c= {Color.red, Color.yellow, Color.green, Color.blue, Color.magenta};
		while(true) {
			setBackground(c[n]);
			n++;
			n%=5;
			/*if(n==0) setBackground(Color.yellow);
			else setBackground(Color.green);
			if(n==0) n=1;
			else n=0;*/
			try {
				Thread.sleep(delay);
			}catch(InterruptedException e) {
				return;
			}
		}
	}
	
}
public class FlickeringLabelEx extends JFrame{
	public FlickeringLabelEx() {
		setTitle("�����̴� ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		//3���� ���̺� ���� �� ���
		FlickeringLabel label1=new FlickeringLabel("����",500);
		JLabel label2=new JLabel("�ȱ���");
		FlickeringLabel label3=new FlickeringLabel("����",300);
		
		c.add(label1); c.add(label2); c.add(label3);
		
		setSize(300,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new FlickeringLabelEx();

	}

}
