package app;


public class Student {
	public enum Gender {
	    MALE,
	    FEMALE,
	};
    private String name;
    private int rollNo;
    private int age;
    private String standard;
    private Gender gender;
    private SchoolDetails.SchoolName schoolName;
    private double percentage;
    private Fees feeDetails;

    public Student(int rollNo, String name, int age, String standard, Gender gender, SchoolDetails.SchoolName schoolName, double percentage, int feesPaid) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.standard = standard;
        this.gender = gender;
        this.schoolName = schoolName;
        this.percentage = percentage;
        this.feeDetails = new Fees(schoolName, feesPaid);
    }
    public String toString() {
    	return "(" +
                "name='" + name+
                ", rollNo=" + rollNo +
                ", age=" + age +
                ", standard='" + standard +
                ", gender=" + gender +
                ", schoolName=" + schoolName +
                ", percentage=" + percentage +
                ", feesPaid=" + feeDetails.getFeesPaid() +
                ", feesPending=" + feeDetails.getFeesPending() +
                ")\n";
    }
    
    public int getRollNo() {
        return rollNo;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getStandard() {
        return standard;
    }
    public Gender getGender() {
        return gender;
    }
    public SchoolDetails.SchoolName getSchoolName() {
        return schoolName;
    }
    public double getPercentage() {
        return percentage;
    }
    public Fees getFeesDetails() {
        return feeDetails;
    }
    public int getFeesPending() {
    	return feeDetails.getFeesPending();
    }
    public int getFeesPaid() {
    	return feeDetails.getFeesPaid();
    }
    public int getTotalFees() {
    	return feeDetails.getTotalFees();
    }
}
