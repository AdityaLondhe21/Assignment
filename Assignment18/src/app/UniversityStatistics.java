package app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import app.SchoolDetails.SchoolName;
import app.Student.Gender;

public class UniversityStatistics {
    private static List<Student> students = new ArrayList<Student>();
	
    private static void loadStudents() {
//    						     rN, name,  age,  std,      gender,                  schoolName,          percentage,feesPaid
    	students.add(new Student(1, "Amit", 15, "10th", Student.Gender.MALE, SchoolDetails.SchoolName.OAKWOOD, 85.5, 70000));
    	students.add(new Student(2, "Riya", 14, "9th", Student.Gender.FEMALE, SchoolDetails.SchoolName.GREENFIELD, 92.0, 50000));
    	students.add(new Student(3, "Rahul", 16, "11th", Student.Gender.MALE, SchoolDetails.SchoolName.RIVERSIDE, 78.0, 60000));
    	students.add(new Student(4, "Sneha", 15, "10th", Student.Gender.FEMALE, SchoolDetails.SchoolName.HILLTOP, 88.5, 40000));
    	students.add(new Student(5, "Vikram", 17, "12th", Student.Gender.MALE, SchoolDetails.SchoolName.SUNRISE, 95.0, 55000));
    	students.add(new Student(6, "Anjali", 13, "8th", Student.Gender.FEMALE, SchoolDetails.SchoolName.OAKWOOD, 82.0, 75000));
    	students.add(new Student(7, "Karan", 14, "9th", Student.Gender.MALE, SchoolDetails.SchoolName.GREENFIELD, 76.5, 50000));
    	students.add(new Student(8, "Pooja", 15, "10th", Student.Gender.FEMALE, SchoolDetails.SchoolName.RIVERSIDE, 89.0, 60000));
    	students.add(new Student(9, "Rohit", 16, "11th", Student.Gender.MALE, SchoolDetails.SchoolName.HILLTOP, 91.5, 40000));
    	students.add(new Student(10, "Meera", 17, "12th", Student.Gender.FEMALE, SchoolDetails.SchoolName.SUNRISE, 87.0, 55000));
    	students.add(new Student(11, "Arjun", 15, "10th", Student.Gender.MALE, SchoolDetails.SchoolName.OAKWOOD, 84.0, 75000));
    	students.add(new Student(12, "Priya", 14, "9th", Student.Gender.FEMALE, SchoolDetails.SchoolName.GREENFIELD, 90.5, 50000));
    	students.add(new Student(13, "Sahil", 16, "11th", Student.Gender.MALE, SchoolDetails.SchoolName.RIVERSIDE, 79.5, 60000));
    	students.add(new Student(14, "Neha", 15, "10th", Student.Gender.FEMALE, SchoolDetails.SchoolName.HILLTOP, 85.0, 40000));
    	students.add(new Student(15, "Vivek", 17, "12th", Student.Gender.MALE, SchoolDetails.SchoolName.SUNRISE, 93.0, 55000));
    	students.add(new Student(16, "Divya", 13, "8th", Student.Gender.FEMALE, SchoolDetails.SchoolName.OAKWOOD, 81.0, 75000));
    	students.add(new Student(17, "Manish", 14, "9th", Student.Gender.MALE, SchoolDetails.SchoolName.GREENFIELD, 77.0, 50000));
    	students.add(new Student(18, "Kavya", 15, "10th", Student.Gender.FEMALE, SchoolDetails.SchoolName.RIVERSIDE, 88.0, 60000));
    	students.add(new Student(19, "Aakash", 16, "11th", Student.Gender.MALE, SchoolDetails.SchoolName.HILLTOP, 90.0, 40000));
    	students.add(new Student(20, "Sonia", 17, "12th", Student.Gender.FEMALE, SchoolDetails.SchoolName.SUNRISE, 86.0, 55000));
    	students.add(new Student(21, "Nikhil", 15, "10th", Student.Gender.MALE, SchoolDetails.SchoolName.OAKWOOD, 83.0, 75000));
    	students.add(new Student(22, "Tina", 14, "9th", Student.Gender.FEMALE, SchoolDetails.SchoolName.GREENFIELD, 91.0, 50000));
    	students.add(new Student(23, "Rakesh", 16, "11th", Student.Gender.MALE, SchoolDetails.SchoolName.RIVERSIDE, 80.0, 60000));
    	students.add(new Student(24, "Anita", 15, "10th", Student.Gender.FEMALE, SchoolDetails.SchoolName.HILLTOP, 87.5, 40000));
    	students.add(new Student(25, "Suresh", 17, "12th", Student.Gender.MALE, SchoolDetails.SchoolName.SUNRISE, 94.0, 55000));
    	students.add(new Student(26, "Raj", 15, "10th", Student.Gender.MALE, SchoolDetails.SchoolName.OAKWOOD, 35.0, 70000));
    	students.add(new Student(27, "Simran", 14, "9th", Student.Gender.FEMALE, SchoolDetails.SchoolName.GREENFIELD, 28.0, 50000));
    	students.add(new Student(28, "Mohan", 16, "11th", Student.Gender.MALE, SchoolDetails.SchoolName.RIVERSIDE, 22.0, 60000));
    	students.add(new Student(29, "Anita", 15, "10th", Student.Gender.FEMALE, SchoolDetails.SchoolName.HILLTOP, 30.5, 40000));
    	students.add(new Student(30, "Vijay", 17, "12th", Student.Gender.MALE, SchoolDetails.SchoolName.SUNRISE, 38.0, 55000));
    	students.add(new Student(31, "Rani", 13, "8th", Student.Gender.FEMALE, SchoolDetails.SchoolName.OAKWOOD, 25.0, 75000));
    	students.add(new Student(32, "Arjun", 14, "9th", Student.Gender.MALE, SchoolDetails.SchoolName.GREENFIELD, 33.5, 50000));
    	students.add(new Student(33, "Pooja", 15, "10th", Student.Gender.FEMALE, SchoolDetails.SchoolName.RIVERSIDE, 29.0, 60000));
    	students.add(new Student(34, "Rohit", 16, "11th", Student.Gender.MALE, SchoolDetails.SchoolName.HILLTOP, 27.5, 40000));
    	students.add(new Student(35, "Meera", 17, "12th", Student.Gender.FEMALE, SchoolDetails.SchoolName.SUNRISE, 36.0, 55000));
    	students.add(new Student(36, "Amit", 15, "10th", Student.Gender.MALE, SchoolDetails.SchoolName.OAKWOOD, 34.0, 75000));
    }
    
	public static void main(String[] args) {
		loadStudents();
		
//		How many students in each standard 
		Map<String,Long> studentsPerStandard = students.stream().collect(Collectors.
														groupingBy(s->s.getStandard(),Collectors.counting()));
		System.out.println("How many students in each standard \n"+studentsPerStandard);
		System.out.println("-------------------------------------------");
		
//		How many students male & female 
		Map<Gender,Long> maleFemaleCount = students.stream().collect(Collectors.
												groupingBy(s->s.getGender(),Collectors.counting()));
		System.out.println("How many students male & female \n"+maleFemaleCount);
		System.out.println("-------------------------------------------");
		
//		How many students failed and passed (above 40%) 
		Map<Boolean,Long> passedFailedStudentCountU = students.stream().collect(Collectors.
											partitioningBy(s->s.getPercentage()>40 ,Collectors.counting()));
		System.out.println("How many students failed (University) : \n"+passedFailedStudentCountU.get(false));
		System.out.println("How many students passed (University): \n"+passedFailedStudentCountU.get(true));
		System.out.println("-------------------------------------------");
		
//		School wise 
		Map<Boolean, Map<SchoolName, Long>> passedFailedStudentCountS = students.stream()
									.collect(Collectors.partitioningBy(s -> s.getPercentage() > 40,
											Collectors.groupingBy(Student::getSchoolName, Collectors.counting())));
		System.out.println("How many students passed/failed per school: \n"+passedFailedStudentCountS);
		System.out.println("-------------------------------------------");
		
//		Top 3 students 
		List<Student> top3Students = students.stream()
									.sorted(Comparator.comparingDouble(Student::getPercentage).reversed())
                					.limit(3)
                					.collect(Collectors.toList());
		System.out.println("Top 3 Students \n"+top3Students);
		System.out.println("-------------------------------------------");
		
//		Top scorer school wise 
		Map<SchoolName, Optional<Student>> topScorerSchoolWise = students.stream().collect(
								Collectors.groupingBy(
											Student::getSchoolName,
											Collectors.maxBy(Comparator.comparingDouble(Student::getPercentage))));
		System.out.println("Top Students school wise\n"+topScorerSchoolWise);
		System.out.println("-------------------------------------------");
		
//		Average age of male and female students 
		Map<Gender,Double> averageAgeOfStudentsGenderWise = students.stream()
			    		.collect(Collectors.groupingBy(
			    				Student::getGender,
			    				Collectors.averagingInt(Student::getAge)));
		System.out.println("Average age by gender \n"+averageAgeOfStudentsGenderWise);
		System.out.println("-------------------------------------------");
		
//		Total fees collected school wise 
		Map<SchoolName, Integer> totalFeesCollectedSchoolWise = students.stream()
								.collect(
										Collectors.groupingBy(Student::getSchoolName,
												Collectors.summingInt(Student::getTotalFees))
								);
		System.out.println("Total Fees Collected school wise\n"+totalFeesCollectedSchoolWise);
		System.out.println("-------------------------------------------");
		
//		Total fees pending school wise 
		Map<SchoolName, Integer> totalFeesPendingSchoolWise = students.stream()
							.collect(
									Collectors.groupingBy(Student::getSchoolName,
											Collectors.summingInt(Student::getFeesPending))
							);
		System.out.println("Total Fees Pending school wise\n"+totalFeesPendingSchoolWise);
		System.out.println("-------------------------------------------");
		
//		Total number of students (university) 	
		Long totalNumberOfStudents = students.stream().count();
		System.out.println("Total number of students (university)\n"+totalNumberOfStudents);
		System.out.println("-------------------------------------------");

	}

}
