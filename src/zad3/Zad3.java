package zad3;

import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

public class Zad3 {
	
	
	private static final int AMOUNT=300000;
    private static List<String> al = new LinkedList<>();
    private static List<String> ll = new LinkedList<>();
    public static void main(String[] args) {
		
		JFrame frame = new JFrame("Wyniki");
		JLayeredPane lp = new JLayeredPane();
		JTextArea ta = new JTextArea("");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(200, 700);
		lp.setLayout(new BoxLayout(lp, BoxLayout.PAGE_AXIS));
		
		frame.add(lp);
		lp.add(ta);
		
	        for(int i=0;i<AMOUNT;i++){
	            al.add("word");
	            ll.add("word");
	        }
	        
	        ta.append("\nWstawianie na poczatek: \nArrayList: "+insertTest(0, al)+
	                "\nLinkedList:"+insertTest(0, ll)+"\n");
	        ta.append("\nWstawianie na koniec: \nArrayList: "+insertTest(AMOUNT+1, al)+
	                "\nLinkedList:"+insertTest(AMOUNT+1, ll)+"\n");
	        ta.append("\nWstawianie do srodka: \nArrayList: "+insertTest((int)AMOUNT/2, al)+
	                "\nLinkedList:"+insertTest((int)AMOUNT/2, ll)+"\n");
	        ta.append("\nUsuwanie z poczatku: \nArrayList: "+removeTest(0, al)+
	                "\nLinkedList:"+removeTest(0, ll)+"\n");
	        ta.append("\nUsuwanie z konca: \nArrayList: "+removeTest(AMOUNT, al)+
	                "\nLinkedList:"+removeTest(AMOUNT, ll)+"\n");
	        ta.append("\nUsuwanie z srodka: \nArrayList: "+removeTest((int)AMOUNT/2, al)+
	                "\nLinkedList:"+removeTest((int)AMOUNT/2, ll)+"\n");
	        ta.append("\nCzytanie z poczatku: \nArrayList: "+readTest(0, ll)+
	                "\nLinkedList:"+readTest(0, ll)+"\n");
	        ta.append("\nCzytanie z konca: \nArrayList: "+readTest(AMOUNT-1, al)+
	                "\nLinkedList:"+readTest(AMOUNT-1, ll)+"\n");
	        ta.append("\nCzytanie z srodka: \nArrayList: "+readTest((int)AMOUNT/2, ll)+
	                "\nLinkedList:"+readTest((int)AMOUNT/2, ll)+"\n");
	        
	        
	        
	        
	    }
	    
	    public static long insertTest(int position,List<String> list){
	        long time=System.currentTimeMillis();
	        list.add(position, "word");
	        return System.currentTimeMillis()-time;
	    }
	    
	    
	    public static long removeTest(int position,List<String> list){
	        long time=System.currentTimeMillis();
	        list.remove(position);
	        return System.currentTimeMillis()-time;
	    }
	    
	    public static long readTest(int position,List<String> list){
	        long time=System.nanoTime();
	        list.get(position);
	        return System.nanoTime()-time;
	    }
	    
	}