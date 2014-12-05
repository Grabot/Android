package onzichtbaar.net.greaterThanFive6.objects;

public class Citizen 
{

	public String name;
	public int age;
	public int happiness;
	public String profession;
	
	public Citizen( String name, int age, int happiness, String profession )
    {
		this.name = name;
		this.age = age;
		this.happiness = happiness;
		this.profession = profession;
    }
	
	public void setName( String name )
	{
		this.name = name;
	}
	
}
