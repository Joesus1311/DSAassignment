package Studentmanagement;
class Student {
    private int id;
    private String name;
    private double marks;


    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }


    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }

    // Determine rank based on marks
    public String getRank() {
        if (marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else return "Excellent";
    }



    @Override
    public String toString() {
        return "Student id = " + id +
                ", name='" + name + '\'' +
                " Marks: " + marks + '\'' +
                " Rank: " + getRank();
    }
}

