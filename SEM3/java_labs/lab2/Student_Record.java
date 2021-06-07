/*Design a class which represent a student record.Every student record is
  made up to the following fields.
 */

/*
 * (a).Registration number (b).Full name
 * (c).Date of joining
 * (d).Semester(short)
 * (e).gpa(float)
 * (f).cgpa(float)
 * Write a member function to do following
 * (1).Provide default parameterized constructor to this class.
 * (2).Write display method() which display the record.
 * (3).create an array of student record to store minimum of 5 record.
 * (4).sort the student record with respect to semester and cgpa.
 * (5).sort the student record record with respect to name.
 * (6).add member() function to do following
 * (7).List all the student whose name start with particular character
 * (8).whose name start with substring
 * (9).change the full name of object to name with just intial and family.
 * for example->Prakash Kalingrao Aithal must be changed to to P.K.Aithal and store the object in the object.
 */
import java.util.GregorianCalendar;
import java.util.Scanner;

class Student {

    int regno;
    String sname;
    GregorianCalendar calendar;
    short sem;
    float gpa;
    float cgpa;

    /* Default constructor */
    Student() {

        regno = 0;
        sname = "";
        calendar = new GregorianCalendar(0, 0, 0);
        gpa = 0;
        cgpa = 0;

    }

    /* Parameterized constructor */
    Student(String b, int yy, int mm, int dd, short d, float e, float f) {

        this.sname = b;
        this.calendar = new GregorianCalendar(yy, mm, dd);
        this.sem = d;
        this.gpa = e;
        this.cgpa = f;
        this.regno = (this.calendar.get(calendar.YEAR) % 100) * 100;

    }

    public void display() {

        System.out.println("-------------------Student Details Given Below----------------------------");
        System.out.println();
        System.out.println("Student RegNo is = " + regno);
        System.out.println("Student Name is = " + sname);
        System.out.println("Date of Joining is = " + this.calendar.get(calendar.DATE) + "/"
                + this.calendar.get(calendar.MONTH) + "/" + this.calendar.get(calendar.YEAR));
        System.out.println("Semester is = " + sem);
        System.out.println("GPA is = " + gpa);
        System.out.println("CGPA is = " + cgpa);
        System.out.println();

    }

    /* Sorting student record with respect to semester and cgpa */

    public static void sortSem(Student s[], int n) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (s[j].sem > s[j + 1].sem) {
                    short temp;
                    temp = s[j].sem;
                    s[j].sem = s[j + 1].sem;
                    s[j + 1].sem = temp;
                }
            }
        }
    }

    /* Sorting student record with respect to cgpa */
    public static void sortCGPA(Student s[], int n) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (s[j].cgpa > s[j + 1].cgpa) {
                    float temp;
                    temp = s[j].cgpa;
                    s[j].cgpa = s[j + 1].cgpa;
                    s[j + 1].cgpa = temp;
                }
            }

        }
    }


    /* Sorting the record with respect to names */
    public static void sortNames(Student s[], int n) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (s[j].sname.compareTo(s[j + 1].sname) > 0) {
                    String temp;
                    temp = s[j].sname;
                    s[j].sname = s[j + 1].sname;
                    s[j + 1].sname = temp;
                }
            }

        }
    }

    /* Listing the student whose name start with character */
    public static void startWithCharacter(Student s[]) {

        Scanner scanner = new Scanner(System.in);

        int l = s.length;
        System.out.println("Enter the character ");
        char ch = scanner.next().charAt(0);

        for (int i = 0; i < l; i++) {

            if (ch == s[i].sname.charAt(0)) {

                s[i].display();
            }
        }
    }

    /* listing the student whose name start with substring */
    public static void startWithSubstring(Student s[]) {

        int l = s.length;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Substring ");
        String subString = scanner.nextLine();
        for (int i = 0; i < l; i++) {
            if ((s[i].sname).indexOf(subString) != -1) {
                s[i].display();
            }
        }
    }

    /* Changing full name in the object */
    public static void changeNameInitial(Student s[]) {

        int l = s.length;
        for (int i = 0; i < l; i++) {

            String w = "";
            String x = "";
            for (int j = 0; j < s[i].sname.length(); j++) {
                if (s[i].sname.charAt(j) == ' ') {
                    x = x + w.charAt(0) + ".";
                    w = "";
                } else {
                    w = w + s[i].sname.charAt(j);
                }
            }

            x = x + w;
            s[i].sname = x;
        }
    }

}

class Student_Record {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------Enter the details of students-----------------");
        System.out.println();

        System.out.println("Enter the number of student");
        int n = scanner.nextInt();

        Student[] s = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("------Enter the details of " + (i + 1) + " student ------");
            System.out.println();

            System.out.println("Enter the Name of Student  ");
            String sname = scanner.nextLine();
            sname = scanner.nextLine();

            System.out.println("Enter the date of joining ");
            int dd = scanner.nextInt();
            int mm = scanner.nextInt();
            int yy = scanner.nextInt();

            System.out.println("Enter the semester ");
            short sem = scanner.nextShort();
            System.out.println("Enter the GPA ");
            float gpa = scanner.nextFloat();
            System.out.println("Enter CGPA ");
            float cgpa = scanner.nextFloat();
            s[i] = new Student(sname, dd, mm, yy, sem, gpa, cgpa);

        }

        for (int i = 0; i < n; i++) {

            s[i].display();
        }

        System.out.println("------Sorting according to sem------");
        System.out.println("\n");
        Student.sortSem(s, n);
        for (int i = 0; i < n; i++) {
            s[i].display();
        }
        System.out.println("------Sorting according to CGPA------");
        System.out.println("\n");
        Student.sortCGPA(s, n);
        for (int i = 0; i < n; i++) {
            s[i].display();
        }
        System.out.println("------Sorting according to names------");
        System.out.println("\n");
        Student.sortNames(s, n);
        for (int i = 0; i < n; i++) {
            s[i].display();
        }

        Student.startWithCharacter(s);
        Student.startWithSubstring(s);

        System.out.println("----Changing name with initial----");
        System.out.println();

        Student.changeNameInitial(s);
        for (int i = 0; i < n; i++) {

            s[i].display();
        }

    }

}