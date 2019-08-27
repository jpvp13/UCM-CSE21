
public class Student {
	private String name;
	private char gender;
	private Date birthDay;
	private Preference pref;
	public boolean matched; //boolean will allow the reponse to be either true or false instead of a value or string
	private int month;//this variable is private because we want to be as defensive when coding to stop this number from being changed
	private int year;//this variable is private because we want to be as defensive when coding to stop this number from being changed
	private int day; //this variable is private because we want to be as defensive when coding to stop this number from being changed
	public int compatableScore; // this is public instead of private because this object will be used by multiple classes and can be changed from outside of this class

	public Student() { //this is the default constructor
		name = "John";
		gender = 'M';
		matched = false;
		birthDay = new Date(year, month, day); //this is initializing and calling a new class to gather the information
	}

	public Student(String name, char gender, Date birthDay, Preference pref) { //each one of these instance variables are what make up a specific student, or object
		this.name = name;//Input parameter #1
		this.gender =gender; //Input parameter #2
		this.birthDay = birthDay; //Input parameter #3
		this.pref= pref; //Input parameter #4

	}

	public void setName(String name) { //Mutator that changes name
		this.name = name;
	}

	public void setGender(char gender) {//Mutator that changes gender
		this.gender = gender;
	}

	public void setbirthDay(Date birthDay) { // Mutator that changes birthday
		this.birthDay = birthDay;
	}

	public void setPreference(Preference pref) { //Mutator that changes preference
		this.pref=pref;
	}

	public void setMatched(boolean matched) { //Mutator that changes boolean
		this.matched = matched;
	}

	// Accessors --> this means that this is where the instance variable can be brought back and used.

	public String getName() {// Accessor for name
		return name;
	}

	public char getGender() { //Accessor for gender
		return gender;
	}

	public Date birthDay() { //Acessor for birthday
		return birthDay;
	}

	public Preference getPref() { //Accessor for preference
		return pref;
	}

	public boolean getMatched() { //Accessor for boolean
		return matched;
	}


	public int Compare(Student st) { //Compare(Student st) being the method with a parameter
		if(gender != st.gender) {
			return 0;
		}
		//compatableScore = (40 - pref.compare(st.pref)) + (60 - Math.abs((birthDay.compare(st.birthDay))));

		if(compatableScore < 100) {
			return 0; //the highest score is 100 and lowest is 0
		} else if (compatableScore >100) {
			return 100; //the highest score is 100 and lowest is 0
		}
		return compatableScore;
	}
}
