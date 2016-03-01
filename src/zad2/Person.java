package zad2;

public class Person implements Comparable<Person> {
	
	private String Name;
	private String lastname;
	private String adress;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Person(){};
	public Person (String name, String lastname, String adress){
		this.Name = name;
		this.lastname = lastname;
		this.adress = adress;
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return 0;
	};
	
	

}
