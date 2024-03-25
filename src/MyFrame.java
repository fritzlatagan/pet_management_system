import javax.swing.JFrame;
public class MyFrame extends JFrame{
	private int W, H;
	public MyFrame() {
		H=800;
		W=500;
	}
	public MyFrame(int width, int height) {
		H=height;
		W=width;
	}
	public MyFrame(String title,int width, int height) {
		super(title);
		H=width;
		W=height;
	}
	public void setTitulo(String title) {
		super.setTitle(title); 
	}
	public void setWindowSize(int width, int height) {
		H=height; W=width;
		super.setSize(width, height);
	}
	public void setMyFrame(String title, int width, int height){
		setTitle(title);
		setWindowSize(width, height);
	}
	public void setMyFrame(String title, int width, int height, boolean visible){
		setMyFrame(title, width, height);
		setVisible(true);
	}
}
