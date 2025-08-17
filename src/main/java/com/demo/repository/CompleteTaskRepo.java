package com.demo.repository;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.model.CompleteTasks;
import com.demo.model.Tasks;
@Repository
public interface CompleteTaskRepo extends JpaRepository<CompleteTasks,Integer>{


	@Query(value = "SELECT * FROM complete_tasks WHERE DATE(created_date) = CURDATE()", nativeQuery = true)
	List<CompleteTasks> findTodayTasksSummary();

	@Query(value = "SELECT * FROM complete_tasks WHERE DATE(created_date) BETWEEN :startDate AND :endDate", nativeQuery = true)
	List<CompleteTasks> find(@Param("startDate") Date d1, @Param("endDate") Date d2);
	

    @Query(value = """
            SELECT work, 
                   SEC_TO_TIME(SUM(TIMESTAMPDIFF(SECOND, starting_time, ending_time))) AS total_duration 
            FROM complete_tasks 
            WHERE starting_time IS NOT NULL AND ending_time IS NOT NULL AND DATE(created_date) = CURDATE()
            GROUP BY work
        """, nativeQuery = true)
        List<CompleteTasks> getWorkDurations();
    
    
    @Query(value = """
    	    SELECT 
    	        work,
    	        SUM(TIMESTAMPDIFF(SECOND, starting_time, ending_time)) AS total_seconds,
    	        SEC_TO_TIME(SUM(TIMESTAMPDIFF(SECOND, starting_time, ending_time))) AS total_duration
    	    FROM 
    	        complete_tasks
    	    WHERE 
    	        starting_time IS NOT NULL 
    	        AND ending_time IS NOT NULL
    	    GROUP BY 
    	        work;
    	""",nativeQuery=true)
    List<Tasks> getall();
    
    @Query(value = """
    	    SELECT 
    	        work,
    	        CONCAT(
    	            FLOOR(SUM(TIMESTAMPDIFF(SECOND, starting_time, ending_time)) / 86400), ' day(s) ',
    	            SEC_TO_TIME(SUM(TIMESTAMPDIFF(SECOND, starting_time, ending_time)) % 86400)
    	        ) AS total_duration
    	    FROM complete_tasks
    	    WHERE starting_time IS NOT NULL 
    	      AND ending_time IS NOT NULL
    	    GROUP BY work
    	""", nativeQuery = true)
    	List<Tasks> getAll2();

    
    
    @Query(value = """
    	    SELECT 
    	        work,
    	        SUM(TIMESTAMPDIFF(SECOND, starting_time, ending_time)) AS total_seconds,
    	        SEC_TO_TIME(SUM(TIMESTAMPDIFF(SECOND, starting_time, ending_time))) AS total_duration
    	    FROM 
    	        complete_tasks
    	    WHERE 
    	        starting_time IS NOT NULL 
    	        AND ending_time IS NOT NULL
    	        AND DATE(created_date) = CURDATE()
    	    GROUP BY 
    	        work;
    	""", nativeQuery = true)
    	List<Tasks> getTodayTasks();

    
    
    @Query(value = """
    	    SELECT 
    	        work,
    	        SUM(TIMESTAMPDIFF(SECOND, starting_time, ending_time)) AS total_seconds,
    	        SEC_TO_TIME(SUM(TIMESTAMPDIFF(SECOND, starting_time, ending_time))) AS total_duration
    	    FROM 
    	        complete_tasks
    	    WHERE 
    	        starting_time IS NOT NULL 
    	        AND ending_time IS NOT NULL
    	        AND YEARWEEK(created_date, 1) = YEARWEEK(CURDATE(), 1)
    	    GROUP BY 
    	        work;
    	""", nativeQuery = true)
    	List<Tasks> getCurrentWeekTasks();

    
    
    @Query(value = """
    	    SELECT 
    	          work,
    	        SUM(TIMESTAMPDIFF(SECOND, starting_time, ending_time)) AS total_seconds,
    	        SEC_TO_TIME(SUM(TIMESTAMPDIFF(SECOND, starting_time, ending_time))) AS totalDuration
    	    FROM 
    	        complete_tasks
    	    WHERE 
    	        starting_time IS NOT NULL 
    	        AND ending_time IS NOT NULL
    	        AND created_date = :date
    	    GROUP BY 
    	        work
    	""", nativeQuery = true)
    	List<Tasks> getByDate(@Param("date") Date date);

    
   
  

}
