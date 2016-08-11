package com.programmingfree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.programmingfree.springservice.domain.*;
import com.programmingfree.springservice.utility.DBUtility;
public class TaskManagerService {
 

 public TaskManagerService() {
	 try {
		 
//		 connection = DBUtility.getConnection();
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("No se pudo obtener Conectividad a la Base de datos");
	}
  
 }

 public void addTask(Task task) {
	 
	 Connection connection = null ;
	 PreparedStatement preparedStatement =null;
	  try {
		  connection = DBUtility.getConnection();
	  if(connection==null){
			System.out.println("No se obtuvo conexion para addTask() ");
			  return ;
		  }
    preparedStatement = connection
     .prepareStatement("insert into task_list(task_name,task_description,task_priority,task_status,task_archived,task_start_time,task_end_time) values (?, ?, ?,?,?,?,?)");
   System.out.println("Task:"+task.getTaskName());
   preparedStatement.setString(1, task.getTaskName());
   preparedStatement.setString(2, task.getTaskDescription());   
   preparedStatement.setString(3, task.getTaskPriority());
   preparedStatement.setString(4, task.getTaskStatus());
   preparedStatement.setInt(5,0);
   Date dt = new Date();

   SimpleDateFormat sdf = 
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

   String currentTime = sdf.format(dt);
   preparedStatement.setString(6,currentTime);
   preparedStatement.setString(7,currentTime);
   preparedStatement.executeUpdate();

  } catch (SQLException e) {
   e.printStackTrace();
  }finally{
	  try {
		  if(connection!=null && !connection.isClosed()){
			  connection.close();
		  }
	} catch (Exception e2) {
		e2.printStackTrace();
	}finally{
		connection = null;
	}
	  
	  preparedStatement= null;
  }
  
  
  
 }
 
 public void archiveTask(int taskId) {
	 Connection connection = null ;
	  PreparedStatement preparedStatement=null;
	  try {
		  connection = DBUtility.getConnection();
	  if(connection==null){
		System.out.println("No se obtuvo conexion para archiveTask() ");
		  return ;
	  }
    preparedStatement = connection
     .prepareStatement("update task_list set task_archived=true where task_id=?");
   // Parameters start with 1
   preparedStatement.setInt(1, taskId);
   preparedStatement.executeUpdate();

  } catch (SQLException e) {
   e.printStackTrace();
  }finally{
	  try {
		  if(connection!=null && !connection.isClosed()){
			  connection.close();
		  }
	} catch (Exception e2) {
		e2.printStackTrace();
	}finally{
		connection = null;
	}
	  
	  preparedStatement= null;
  }
 }
 
 public void updateTask(Task task) throws ParseException {
	 Connection connection = null ;
	  PreparedStatement preparedStatement=null;
	  try {
		  connection = DBUtility.getConnection();
	  if(connection==null){
		System.out.println("No se obtuvo conexion para updateTask() ");
		  return ;
	  }
    preparedStatement = connection
     .prepareStatement("update task_list set task_name=?, task_description=?, task_priority=?,task_status=?" +
       "where task_id=?");
   preparedStatement.setString(1, task.getTaskName());
   preparedStatement.setString(2, task.getTaskDescription());
   
   preparedStatement.setString(3, task.getTaskPriority());
   preparedStatement.setString(4, task.getTaskStatus());
   preparedStatement.setInt(4, task.getTaskId());
   preparedStatement.executeUpdate();

  } catch (SQLException e) {
	  e.printStackTrace();
  }finally{
		  try {
			  if(connection!=null && !connection.isClosed()){
				  connection.close();
			  }
		} catch (Exception e2) {
			e2.printStackTrace();
		}finally{
			connection = null;
		}
		  
		  preparedStatement= null;
	  }
	 
	 
 }
 
 public void changeTaskStatus(int taskId,String status) throws ParseException {
	 Connection connection = null ;
	 PreparedStatement preparedStatement =null;
	  try {
		  connection = DBUtility.getConnection();
	   if(connection==null){
			System.out.println("No se obtuvo conexion para changeTaskStatus() ");
			  return ;
		  }
	   
     preparedStatement = connection
      .prepareStatement("update task_list set task_status=? where task_id=?");
    preparedStatement.setString(1,status);
    preparedStatement.setInt(2, taskId);
    preparedStatement.executeUpdate();

   } catch (SQLException e) {
    e.printStackTrace();
   }finally{
		  try {
			  if(connection!=null && !connection.isClosed()){
				  connection.close();
			  }
		} catch (Exception e2) {
			e2.printStackTrace();
		}finally{
			connection = null;
		}
		  
		  preparedStatement= null;
	  }
  }


 public List<Task> getAllTasks() {
  List<Task> tasks = new ArrayList<Task>();
  Connection connection = null ;
  try {
	  connection = DBUtility.getConnection();
	  
	  if(connection==null){
		  
		  Task tarea= new Task();
		  tarea.setTaskId(9);
		  tarea.setTaskName("Mj");
		  tarea.setTaskDescription("GGWP");
		  tarea.setTaskPriority("MEDIUM");
		  tarea.setTaskStatus("ACTIVE");
		  tasks.add(tarea);
		 System.out.println("No se obtuvo conexion para getAllTasks() ");
			
			  return tasks;
	  }else{
	
	
	  
   Statement statement = connection.createStatement();
   ResultSet rs = statement.executeQuery("select * from task_list where task_archived=0");
   while (rs.next()) {
    Task task = new Task();
    task.setTaskId(rs.getInt("task_id"));
    task.setTaskName(rs.getString("task_name"));
    task.setTaskDescription(rs.getString("task_description"));    
    task.setTaskPriority(rs.getString("task_priority"));
    task.setTaskStatus(rs.getString("task_status"));
    tasks.add(task);
   }
  }
	  
  }catch (Exception e) {
   e.printStackTrace();
  }finally{
	
	  try {
		  if(connection!=null && !connection.isClosed()){
			  connection.close();
		  }
	} catch (Exception e2) {
		e2.printStackTrace();
	}finally{
		connection = null;
	}
	  
  }

  return tasks;
 }
 
 public Task getTaskById(int taskId) {
  Task task = new Task();
  Connection connection = null ;
  try {
	  connection = DBUtility.getConnection();
	  if(connection==null){
			System.out.println("No se obtuvo conexion para getTaskById("+taskId+") ");
			  return task;
		  }
	  
   PreparedStatement preparedStatement = connection.
     prepareStatement("select * from task_list where task_id=?");
   preparedStatement.setInt(1, taskId);
   ResultSet rs = preparedStatement.executeQuery();
   
   if (rs.next()) {
     task.setTaskId(rs.getInt("task_id"));
     task.setTaskName(rs.getString("task_name"));
     task.setTaskDescription(rs.getString("task_description"));    
     task.setTaskPriority(rs.getString("task_priority"));
     task.setTaskStatus(rs.getString("task_status"));
   }
  } catch (SQLException e) {
   e.printStackTrace();
  }finally{
		
	  try {
		  if(connection!=null && !connection.isClosed()){
			  connection.close();
		  }
	} catch (Exception e2) {
		e2.printStackTrace();
	}finally{
		connection = null;
	}
	  
  }

  return task;
 }
}