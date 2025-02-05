package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;

public interface EmployeeDAO {
	
	public static List<Document> getDocuments(Bson filter){
		List<Document> documents = new ArrayList();
		MongoCollection<Document> collection = DBConnection.getCollection();
		
		
		FindIterable<Document> docs = collection.find(filter);
		for(Document doc:docs) {
			documents.add(doc);
		}
		return documents;
	}
	
	public static void loadData(HashMap<Integer,Employee>employees) {
		try{
			MongoCollection<Document> collection = DBConnection.getCollection();
			
			List<Document> documents = getDocuments(null);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static void addEmployee() {	
        try{
        	MongoCollection<Document> collection = DBConnection.getCollection();

	        int createEmpChoice = 0;
	        while (createEmpChoice != 5) {
	    
	            Menu.createEmployeeMenu();
	            createEmpChoice = Menu.readChoice(5);
	            if (createEmpChoice == 5) {
	                break;
	            }
	            String designation;
	            if (createEmpChoice == 1) {
	                designation = "CLERK";
	            } else if (createEmpChoice == 2) {
	                designation = "PROGRAMMER";
	            } else if (createEmpChoice == 3) {
	                designation = "MANAGER";
	            } else if (createEmpChoice == 4) {
	                designation = "OTHER";
	            } else {
	                designation = "OTHER";
	            }
	            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) 
	        	{	            	
	            	System.out.print("Enter EID:");
	                int eid = Integer.parseInt(br.readLine());
	            	System.out.print("Enter Name:");
	                String name = br.readLine();
	                System.out.print("Enter age:");
	                int age = Integer.parseInt(br.readLine());
	                System.out.print("Enter Salary:");
	                int salary = Integer.parseInt(br.readLine());
	
	                Document employee = new Document("EID",eid).append("NAME", name)
	                                        .append("AGE", age)
	                                        .append("SALARY", salary)
	                                        .append("DESIGNATION", designation);
	                collection.insertOne(employee);
	             } 
	            catch (Exception e) {
	                System.out.println(e);
	            }
	        }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void displayEmployee() {
    	try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) 
    	{
        	MongoCollection<Document> collection = DBConnection.getCollection();
	    	int displayEmpChoice = 0;
	    	while (displayEmpChoice != 6) {
	    	    Menu.displayEmployeeMenu();
	    	    displayEmpChoice = Menu.readChoice(6);
	    	    if (displayEmpChoice == 6) {
	    	        break;
	    	    }
	    	    String sortBy;
	    	    if (displayEmpChoice == 1) {
	    	        sortBy = "EID";
	    	    } else if (displayEmpChoice == 2) {
	    	        sortBy = "NAME";
	    	    } else if (displayEmpChoice == 3) {
	    	        sortBy = "AGE";
	    	    } else if (displayEmpChoice == 4) {
	    	        sortBy = "SALARY";
	    	    } else if (displayEmpChoice == 5) {
	    	        sortBy = "DESIGNATION";
	    	    } else {
	    	        sortBy = "EID";
	    	    }
	    	    
	    	    Bson sort = Sorts.ascending(sortBy);
		        FindIterable<Document> employees = collection.find().sort(sort);
		        for (Document employee : employees) {
		            System.out.println(employee.toJson());
		        }
	    	}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }

    public static void raiseSalary() {
    	try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) 
    	{
    		
        	MongoCollection<Document> collection = DBConnection.getCollection();
    	    System.out.print("Enter EID to raise Salary: ");
    	    String eid = br.readLine();
    	    
    	    Bson filter = Filters.eq("EID",eid);
    	    FindIterable<Document> employees = collection.find(filter);
    	    
    	    boolean empPresent = false;
    	    for (Document employee : employees) {
    	        empPresent = true;
    	        System.out.println(employee.toJson());
    	        System.out.println("-----------------------------------------------------------------");
    	    }

    	    if (!empPresent) {
    	        System.out.println("Employee not found");
    	        return;
    	    }

    	    System.out.print("Enter the new Amount: ");
    	    int amount = Integer.parseInt(br.readLine());
    	    
    	    Bson update = Updates.set("SALARY",amount);
    	    
    	    collection.updateOne(filter, update);

    	    System.out.println("Salary updated");
    	    
    	    employees = collection.find(filter);
    	    for (Document employee : employees) {
    	        System.out.println(employee.toJson());
    	        System.out.println("-----------------------------------------------------------------");
    	    }
    	} catch (Exception e) {
    	    System.out.println(e);
    	}
    }

    public static void searchEmployee() {    	
    	try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) 
    	{
    		
        	MongoCollection<Document> collection = DBConnection.getCollection();
    	    System.out.print("Enter EID to raise Salary: ");
    	    String eid = br.readLine();
    	    
    	    Bson filter = Filters.eq("EID",eid);
    	    FindIterable<Document> employees = collection.find(filter);
    	    
    	    boolean empPresent = false;
    	    for (Document employee : employees) {
    	        empPresent = true;
    	        System.out.println(employee.toJson());
    	        System.out.println("-----------------------------------------------------------------");
    	    }

    	    if (!empPresent) {
    	        System.out.println("Employee not found");
    	        return;
    	    }
    	} catch (Exception e) {
    	    System.out.println(e);
    	}    }

    public static void deleteEmployee() {

    	try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) 
    	{
        	MongoCollection<Document> collection = DBConnection.getCollection();

    	    System.out.print("Enter EID to Delete: ");
    	    String eid = br.readLine();
    	    
    	    Bson filter = Filters.eq("EID",eid);
    	    FindIterable<Document> employees = collection.find(filter);
    	    
    	    boolean empPresent = false;
    	    for (Document employee : employees) {
    	        empPresent = true;
    	        System.out.println(employee.toJson());
    	        System.out.println("-----------------------------------------------------------------");
    	    }

    	    if (!empPresent) {
    	        System.out.println("Employee not found");
    	        return;
    	    }

    	    collection.deleteOne(filter);
    	    
    	    System.out.println("Employee Deleted");
    	} catch (Exception e) {
    	    System.out.println(e);
    	}
    }
}
