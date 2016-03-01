package zad1;

public class Symbol {
	
    private char symbol;
    private int quantity;
    
    public Symbol(){};

    public Symbol(char symbol){
        this.symbol=symbol;
        quantity=1;
    };
    
    public char getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void incrementQuantity(){
        quantity++;
    }


	}

    


