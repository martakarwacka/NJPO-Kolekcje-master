package zad2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Zad2 {
	
	static ArrayList<Person> people=new ArrayList<>();

	public static void main(String[] args) {
		
		notSoRandomPeople();

		JFrame frame = new JFrame("Ksi¹¿ka adresowa");
		JLabel label = new JLabel("Ksi¹¿ka adresowa");
		JLayeredPane mainPane = new JLayeredPane();
		JLayeredPane subPane2 = new JLayeredPane();

		JTextArea ta = new JTextArea("");
		JLabel sortLabel = new JLabel("sortuj:");
		JButton sortName = new JButton("Imiê");
		JButton sortLastname = new JButton("Nazwisko");
		JButton sortAdress = new JButton("Adres");
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem add = new JMenuItem("Dodaj");
		JMenuItem exit = new JMenuItem("Zamknij");
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1024, 768);
		frame.setJMenuBar(menuBar);
		
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
		subPane2.setLayout(new BoxLayout(subPane2, BoxLayout.LINE_AXIS));

		menuBar.add(menu);
		menu.add(add);
		menu.add(exit);
		frame.add(mainPane);
		mainPane.add(label);
		mainPane.add(ta);
		mainPane.add(subPane2);
		subPane2.add(sortLabel);
		subPane2.add(sortName);
		subPane2.add(sortLastname);
		subPane2.add(sortAdress);
		
		refresh(ta);
		
		
		

		
	    sortName.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	        	Collections.sort(people, new Comparator<Person>() {
	                
	        		public int compare(Person  person1, Person  person2)
	                {

	        			return  person1.getName().compareTo(person2.getName());
	                }
	            });
	        	refresh(ta);
	        }
	    });
	    
	    
	    sortLastname.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	        	Collections.sort(people, new Comparator<Person>() {
	                
	        		public int compare(Person  person1, Person  person2)
	                {

	        			return  person1.getLastname().compareTo(person2.getLastname());
	                }
	            });
	        	refresh(ta);
	        }
	    });
	    
	    
	    sortAdress.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	        	Collections.sort(people, new Comparator<Person>() {
	                
	        		public int compare(Person  person1, Person  person2)
	                {

	        			return  person1.getAdress().compareTo(person2.getAdress());
	                }
	            });
	        	refresh(ta);
	        }
	    });
		
		
		
	    add.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	        	addWindow(ta);
	        }
	    });
		
		
	    exit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	        	System.exit(0);
	        }
	    });

	}
	
	public static void addWindow(JTextArea ta){
		JFrame frame2 = new JFrame("nowy kontakt");
		JLayeredPane pane1 = new JLayeredPane();
		JLayeredPane pane5 = new JLayeredPane();
		JLayeredPane pane4 = new JLayeredPane();
		JLayeredPane pane3 = new JLayeredPane();
		JLayeredPane pane2 = new JLayeredPane();
		JLabel label1 = new JLabel("Imie");
		JLabel label2 = new JLabel("Nazwisko");
		JLabel label3 = new JLabel("Adres");
		JTextField tf1 = new JTextField();
		JTextField tf2 = new JTextField();
		JTextField tf3 = new JTextField();
		JButton commitButton = new JButton("Dodaj");
		
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(300, 140);
		
		pane1.setLayout(new BoxLayout(pane1, BoxLayout.PAGE_AXIS));
		pane2.setLayout(new BoxLayout(pane2, BoxLayout.LINE_AXIS));
		pane3.setLayout(new BoxLayout(pane3, BoxLayout.LINE_AXIS));
		pane4.setLayout(new BoxLayout(pane4, BoxLayout.LINE_AXIS));
		pane5.setLayout(new BoxLayout(pane5, BoxLayout.LINE_AXIS));
		
		frame2.add(pane1);
		pane1.add(pane2);
		pane1.add(pane3);
		pane1.add(pane4);
		pane1.add(pane5);
		pane2.add(label1);
		pane2.add(tf1);
		pane3.add(label2);
		pane3.add(tf2);
		pane4.add(label3);
		pane4.add(tf3);
		pane5.add(commitButton);
		
	    commitButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	        	people.add(new Person(tf1.getText(), tf2.getText(), tf3.getText()));
	        	frame2.setVisible(false);
	        	refresh(ta);
	        }
	    });
	}
	
	public static void refresh(JTextArea ta){
		ta.setText("");
		for(Person person : people){
			ta.append(person.getName()+", "+person.getLastname()+", "+person.getAdress()+"\n");
		}
	}
	
	public static void notSoRandomPeople(){
		
		people.add(new Person("£ukasz", "Kowalski", "Zamoœæ, Polska"));
		people.add(new Person("Adam", "Nowak", "Sosonowiec, Polska"));
		people.add(new Person("Pawe³", "Kos", "Warszawa, Polska"));
		people.add(new Person("Partyk", "Wonsz", "Londyn, Anglia"));
		people.add(new Person("Piotr", "Adamowicz", "Katowice, Polska"));
		}
	


}
