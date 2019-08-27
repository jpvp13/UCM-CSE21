
public class Date {
	int year; // variable of type int that will be initialized with a instance variable
	int month; // variable of type int that will be initialized with a instance variable
	int day; // variable of type int that will be initialized with a instance variable


	public Date() {// default constructor
		year = 1900-3000;
		month = 1-12;
		day = 1-31;
	}

	//constructor that sets instance variables with the appropriate input parameters
	public Date(int year,int month, int day) {
		if(year >= 1900 && year <= 3000) { //this checks to make sure that year is between this range and then sets the value of the instance variable to the variable's value
			this.year = year;
		}

		if(month >= 1 && month <= 12) {
			if(month == 2) {
				this.month = month;
			}
			this.month = month; // this if checks to make sure the month is within the correct month range. This then sets the instance variable to the variable value
		}

		if(day >= 1 && day <= 31) {
			this.day = day;// this if checks to make sure the day is within that time range and will be equal with the month
		}
	}

	public int getDay() { //Accessor method
		return day;
	}
	public int getMonth() { //Accessor method
		return month;
	}
	public int getYear() {// Accessor method
		return year;
	}
	public int dayOfYear() {
		int totalDays = 0;
		switch (month) {
		case 12: totalDays += 30;
		case 11: totalDays += 31;
		case 10: totalDays += 30;
		case 9 : totalDays += 31;
		case 8 : totalDays += 31;
		case 7 : totalDays += 30;
		case 6 : totalDays += 31;
		case 5 : totalDays += 30;
		case 4 : totalDays += 31;
		case 3 : totalDays += 28;
		case 2 : totalDays += 31;
		}
		totalDays += day;
		return totalDays;
	}

	public int compare(Date dt) {
		int difference = Math.abs((dayOfYear() + (35 *year))-(dt.dayOfYear() + (365 * dt.year)));
		int numMonths = difference/30;
		if(numMonths > 60) {
			numMonths = 60;
		}
		return numMonths;
	}
}
