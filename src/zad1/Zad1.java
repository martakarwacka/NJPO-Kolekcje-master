package zad1;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Zad1 {
	
	static List<Symbol> symbols=new ArrayList<>();
	
	public static void main(String[] args) {

	JFrame frame = new JFrame("Analiza tekstu");
	JLayeredPane lp = new JLayeredPane();
	JTextArea ta = new JTextArea();
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("Menu");
	JMenuItem load = new JMenuItem("Otwórz");
	JMenuItem close = new JMenuItem("Zamknij");
	JMenuItem analyze = new JMenuItem("Analizuj");
	JFileChooser fc = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Pliki tekstowe", "txt");

	
	menuBar.add(menu);
	menu.add(load);
	menu.add(analyze);
	menu.add(close);
	fc.setFileFilter(filter);
	frame.setVisible(true);
	frame.setSize(1024,  768);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(lp);
	lp.setLayout(new BoxLayout(lp, BoxLayout.PAGE_AXIS));
	lp.add(ta);
	frame.setJMenuBar(menuBar);
	
    load.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            try {
				Methods.read(Methods.open(fc.showOpenDialog(menu), fc), ta, fc);
			} catch (HeadlessException | IOException e) {
				e.printStackTrace();
			}
        }
    });
    
    close.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            Methods.exit();
        }
    });
	
    analyze.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            Methods.examine(ta, symbols);
            Methods.display(symbols);
        }
    });
    
    	
	} 
    
}
