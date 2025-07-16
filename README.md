⏱️ ProductivityAnalyzer
Task Time Tracker using Spring Boot + MySQL
A robust and efficient task tracking system built with Spring Boot, Spring Data JPA, and MySQL. It logs tasks along with their start and end times, automatically computes durations, and generates detailed time-based reports.

📁 Project Structure
Task – Basic entity to store task descriptions and creation timestamps.

CompleteTasks – Entity for advanced time tracking, including start time, end time, and calculated duration.

Tasks – A projection interface used for fetching summarized task data like work name and total duration.

CompleteTaskRepo – Spring Data JPA repository that provides native SQL queries for efficient analytics.

✅ Key Features
Add and store task entries with precise timestamps.

Automatically calculate task duration between start and end times.

Generate detailed reports by:

📌 All recorded tasks

📅 Tasks for Today

📈 Tasks for the Current Week

📆 Tasks between Custom Date Ranges

📍 Tasks on a Specific Date

Native SQL support for performance-optimized querying.

Summarized analytics returned include:

work (task name/description)

total_seconds (duration in raw seconds)

total_duration (formatted as HH:MM:SS or days:hours:minutes)

📦 Tech Stack
Layer	Technology
Backend	Java 17+, Spring Boot
Persistence	Spring Data JPA, Hibernate
Database	MySQL
ORM API	Jakarta Persistence (JPA)
Build Tool	Maven

🛠️ Core Endpoints & Repository Methods
🔍 Repository: CompleteTaskRepo
java
Copy
Edit
// Fetch tasks created today
List<CompleteTasks> findTodayTasksSummary();

// Fetch tasks between two specific dates
List<CompleteTasks> find(Date startDate, Date endDate);

// Return summarized durations grouped by 'work'
List<Tasks> getWorkDurations();

// Get total summary of all tasks (raw seconds)
List<Tasks> getall();

// Get total summary (formatted duration e.g., 2d 4h)
List<Tasks> getAll2();

// Fetch today's summarized task durations
List<Tasks> getTodayTasks();

// Fetch summarized durations for the current week
List<Tasks> getCurrentWeekTasks();

// Fetch tasks on a specific date
List<Tasks> getByDate(Date date);

// Fetch tasks between any two timestamps (without date-only filtering)
List<Tasks> getByNoInputPeriod(Timestamp start, Timestamp end);
📊 Example Use Cases
✅ Track working hours per project or task.

🔁 Review weekly time spent and optimize productivity.

📆 Analyze time usage patterns on specific dates.

📈 Generate reports for performance evaluation.

🚀 Getting Started
Clone the repository:

bash
Copy
Edit
git clone https://github.com/Dinesh1305/ProductivityAnalyzer.git
Set up your MySQL database and update application.properties:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password
Run the application:

bash
Copy
Edit
