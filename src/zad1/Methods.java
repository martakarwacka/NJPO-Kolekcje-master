package zad1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Methods {
	

	public static File open(int val, JFileChooser fc){
		if(val==JFileChooser.APPROVE_OPTION){
		File file = fc.getSelectedFile();
		return file;
		} else return null;
	}
	
	
	public static void read(File file, JTextArea ta, JFileChooser fc) throws IOException{
		
		BufferedReader reader=new BufferedReader(
				new InputStreamReader(
						new FileInputStream(fc.getSelectedFile()),Charset.defaultCharset()));
        ta.setText("");
        while(reader.ready()){
            ta.append(reader.readLine()+"\n");
        }
        reader.close();
	}
	
	 public static void examine(JTextArea ta, List<Symbol> symbols){
	        
	        for(int i=0;i<ta.getText().length();i++){
	            boolean check=false;
	            for (Symbol symbol : symbols) {
		            if(symbol.getSymbol()==ta.getText().charAt(i)){
		                symbol.incrementQuantity();
		                check=true;        
	        } 
	            }if(!check) symbols.add(new Symbol(ta.getText().charAt(i)));
	        }
	    }
	
	
	public static void display(JTextArea ta, List<Symbol> symbols){
		ta.setText("");
		for(Symbol symbol : symbols){
		ta.append(symbol.getSymbol()+symbol.getQuantity()+"\n");
		}
	}
	

	
	
	public static void exit(){
		System.exit(0);
	}

	public static void display(List<Symbol> symbols){
		
		JFrame frame2 = new JFrame("wyniki analizy");
		JPanel panel = new JPanel();
		JTextArea ta = new JTextArea("");
		frame2.add(panel);
		panel.add(ta);
		frame2.setVisible(true);
		frame2.setSize(300, 768);
		
        ta.setText("Znak:           Iloœæ:"+"\n");
        for (Symbol symbol : symbols) {
            ta.append(symbol.getSymbol()+"               "+symbol.getQuantity()+"\n");
        }
    }

}
