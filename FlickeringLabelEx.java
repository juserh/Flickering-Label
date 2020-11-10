package ch13;
import javax.swing.*;
import java.awt.*;
class FlickeringLabel extends JLabel implements Runnable{ //ÀÌ¹Ì JLabelÀ» ¹Þ¾Æ¼­ extends Thread¾È µÊ
	private long delay;
	public FlickeringLabel(String text, long delay) {
		super(text); //new JLabel("¹®ÀÚ¿­");
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
		setTitle("±ôºýÀÌ´Â ¶óº§");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		//3°³ÀÇ ·¹ÀÌºí »ý¼º ÈÄ µî·Ï
		FlickeringLabel label1=new FlickeringLabel("±ôºý",500);
		JLabel label2=new JLabel("¾È±ôºý");
		FlickeringLabel label3=new FlickeringLabel("±ôºý",300);
		
		c.add(label1); c.add(label2); c.add(label3);
		
		setSize(300,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new FlickeringLabelEx();

	}

}
