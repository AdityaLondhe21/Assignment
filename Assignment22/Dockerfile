# Use the openjdk base image
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /root/demo

# Copy all Java files and PostgreSQL driver into the container
COPY *.java /root/demo/
COPY postgresql-42.7.5.jar /root/demo/

# Compile all Java files
RUN javac -cp ".:/root/demo/postgresql-42.7.5.jar" EmployeeManagementApp.java

# Command to run the Java program
CMD ["java", "-cp", ".:/root/demo/postgresql-42.7.5.jar", "EmployeeManagementApp"]
