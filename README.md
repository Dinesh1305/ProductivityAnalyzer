ProductivityAnalyzer
# ⏱️ Task Time Tracker (Spring Boot + MySQL)

This project is a task tracking system developed using **Spring Boot**, **Spring Data JPA**, and **MySQL**, designed to log tasks, their start and end times, and automatically compute the duration. It also provides summaries for daily, weekly, and custom time periods.

---

## 📁 Project Structure

- **`Task`** – Entity for simple task entries with automatic timestamp.
- **`CompleteTasks`** – Entity for detailed task tracking including start, end times, and computed durations.
- **`Tasks`** – Projection interface for summarizing task durations.
- **`CompleteTaskRepo`** – Repository with native SQL queries to fetch time-based analytics.
- **Database** – MySQL is used as the underlying database.

---

## ✅ Features

- Add and track task entries with timestamps.
- Automatically compute task duration from start and end times.
- Get reports:
  - 🔹 All tasks
  - 🔹 Tasks for **today**
  - 🔹 Tasks for **current week**
  - 🔹 Tasks between custom **date ranges**
  - 🔹 Tasks on a **specific date**
- Flexible date/time-based query support using native SQL.
- Summarized results include:
  - `work`
  - `total_seconds`
  - `total_duration`

---

## 📦 Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Jakarta Persistence (JPA)
- Maven

---

## 🗃️ Endpoints & Queries (via Repository)

### ✔️ `CompleteTaskRepo` Highlights

```java
List<CompleteTasks> findTodayTasksSummary();
List<CompleteTasks> find(Date startDate, Date endDate);
List<Tasks> getWorkDurations();
List<Tasks> getall(); // Total for all time
List<Tasks> getAll2(); // Duration formatted with days
List<Tasks> getTodayTasks();
List<Tasks> getCurrentWeekTasks();
List<Tasks> getByDate(Date date);
List<Tasks> getByNoInputPeriod(Timestamp start, Timestamp end);
