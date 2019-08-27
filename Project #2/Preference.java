
public class Preference {
	int quietTime;
	int music;
	int reading;
	int chatting;

	public Preference() { //default constructor
		quietTime = 0;
		music = 0;
		reading = 0;
		chatting = 0;
	}

	public Preference(int quietTime1, int music, int reading, int chatting) { //constructor that initializes instance variables 
		if(quietTime >=0 && quietTime <= 10) {
			this.quietTime = quietTime1;
		}
		if(music>= 0 && music <= 10) {
			this.music = music;
		}
		if(reading >= 0 && reading <= 10) {
			this.reading = reading;
		}
		if(chatting >= 0 && chatting <= 10) {
			this.chatting = chatting;
		}
	}

	public int setquietTime() { //Accessor
		return quietTime;
	}

	public int setmusic() { //Accessor
		return music;
	}

	public int setreading() { //Accessor
		return reading;
	}

	public int setchatting() { //Accessor
		return chatting;
	}


	public int compare(Preference pref) { //this calculates the difference of all the possible preferences that the students may have
		return (Math.abs(quietTime - pref.quietTime) + (Math.abs(music - pref.music)) + (Math.abs(reading - pref.reading)) +(Math.abs(chatting - pref.chatting)));

	}

}
