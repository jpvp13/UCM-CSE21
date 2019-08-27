import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Match {

	public ArrayList<Student> readFile() {

		System.out.println("Enter file name: ");
		Scanner input = new Scanner(System.in);
		String roster = input.next();
		//System.out.println("test: " + roster);

		input.close();
		return readFile(roster);

	}

	public ArrayList<Student> readFile(String fileName) {
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			System.out.println("test: " + fileName);
			Scanner in = new Scanner(new FileReader(fileName));

			System.out.println("------");
			while (in.hasNextLine()) {
				@SuppressWarnings("resource")
				Scanner s = new Scanner(in.nextLine());

				s.useDelimiter("[\t-]");

				String name = s.next();

				char c = s.next().charAt(0);

				Date d = new Date(s.nextInt(), s.nextInt(), s.nextInt());

				Preference p = new Preference(s.nextInt(), s.nextInt(),
						s.nextInt(), s.nextInt());

				Student s1 = new Student(name, c, d, p);

				students.add(s1);

				// System.out.println(students.get(0).toString(s1));
				//
				// System.out.println(count);
			}
			System.out.println("test: "  );
			in.close();

		} catch (NoSuchElementException e) {

			System.out.println(e);
		}

		catch (FileNotFoundException e) {

			System.out.println(e);
		}

		return students;
	}

	public static void finalMatches(Match m) {

		ArrayList<Student> students = m.readFile();
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getMatched()) {
				continue;
			}
			int maxScore = 0;
			Student bestMatchStudent = null;

			for (int j = i + 1; j < students.size(); j++) {
				if (students.get(j).getMatched()) {
					continue;
				}

				int currentScore = students.get(i).Compare(students.get(j));

				if (currentScore > maxScore) {
					maxScore = currentScore;
					bestMatchStudent = students.get(j);
				}
			}
			if (bestMatchStudent != null) {
				students.get(i).setMatched(true);
				bestMatchStudent.setMatched(true);
				System.out.println(students.get(i).getName() + " matches with "
						+ bestMatchStudent.getName() + " with score "
						+ maxScore);

			} else {
				System.out.println(students.get(i).getName()
						+ " has no matches.");
			}
		}
	}

	public static void main(String[] args) {

		Match m = new Match();

		finalMatches(m);

	}

}
