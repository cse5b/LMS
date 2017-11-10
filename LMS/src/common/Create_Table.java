package common;

import java.sql.Connection;
import java.sql.Statement;

import common_use_bean.Sequence_Book_Id;
import common_use_bean.Sequence_Issue_Id;
import common_use_bean.Sequence_Student_Id;
import common_use_bean.Sequence_inventry_Id;

public class Create_Table {

		public static void call_me() {
			Connection connection=null;
			DBConnection_LMS_Portal obj_DBConnection_LMC=new DBConnection_LMS_Portal();
			connection=obj_DBConnection_LMC.getConnection();
			Statement st=null;
			try {
				st=connection.createStatement();
				Sequence_Book_Id obj_Sequence_Book_Id=new Sequence_Book_Id();
				
				obj_Sequence_Book_Id.create_table();
				Sequence_inventry_Id obj_Sequence_inventry_Id=new Sequence_inventry_Id();
				
				obj_Sequence_inventry_Id.create_table();
				
				Sequence_Student_Id obj_Sequence_Student_Id=new Sequence_Student_Id();
				
				obj_Sequence_Student_Id.create_table();
				
				 st.execute("create table admin(" +
						"sl_no int(35) auto_increment," +
						"user_name varchar(100) not null," +
						"password varchar(100) not null," +
						"primary key(sl_no))");
			
				st.execute("insert into admin(user_name,password) values('admin','admin')");
			
				
				
				
				st.execute("create table publisher(" +
						"sl_no int(35) auto_increment," +
						"publisher_name varchar(100) not null," +
						"profile varchar(100)," +
						"added_on varchar(100)," +
						"primary key(sl_no))");
				
				st.execute("create table author(" +
						"sl_no int(35) auto_increment," +
						"author_name varchar(100) not null," +
						"profile varchar(100)," +
						"added_on varchar(100)," +
						"primary key(sl_no))");
				
					
					
					
					
					
					
					
				st.execute("create table category(" +
						"sl_no int(35) auto_increment," +
						"category_name varchar(100) not null unique," +
						"profile varchar(100)," +
						"added_on varchar(100)," +
						"primary key(sl_no))");
				
					
					
					
					
			
					
				
				
				
				
				
				
				st.execute("create table student_table(" +
						"student_id varchar(100) unique not null," +
						"admission_no varchar(100) unique not null," +
						"student_name varchar(100) not null," +
						"profile varchar(10000)," + 
						"grade varchar(100)," +
						"section varchar(100)," +
						"added_by varchar(100)," +
						"added_on varchar(100)," +
						"status int(1) not null," +
						"primary key(student_id))");
				
				
				
				
				
				
				st.execute("create table book_table(" +
						"book_sl_no varchar(100) not null," +
						"book_title varchar(100) unique not null," +
						"category_name varchar(100)," +
						"category_num varchar(10)," +
						"author_name varchar(100)," +
						"author_num varchar(10)," +
						"publisher_name varchar(100)," +
						"publisher_num varchar(10)," +
						"edition varchar(100)," +
						"volume varchar(100)," +
						"ean_code varchar(100)," +
						"isbn varchar(100)," +
						"price varchar(100)," +
						"purchase_date varchar(100)," +
						"language varchar(100)," +
						"total_book_in_library int(35)," +
						"total_book_available int(35)," +
						"description varchar(10000)," +
						"added_on varchar(100)," +
						"edited_on varchar(100)," +
						"added_by varchar(100)," +
						"edited_by varchar(100)," +
						"primary key(book_sl_no))");
				
			
					
				st.execute("create table inventry_table(" +
						"sl_no varchar(100) not null," +
						"book_sl_no varchar(100) not null," +
						"book_title varchar(100) not null," +
						"count int(35) not null," +
						"added_on varchar(100) not null," +
						"added_by varchar(100)," +
						"primary key(sl_no),FOREIGN KEY (book_sl_no) REFERENCES book_table(book_sl_no))");
				
				
				
				
				st.execute("create table serial_number(" +
						"sl_no int(35) auto_increment," +
						"invertry_sl_no varchar(100) not null," +
						"book_title varchar(100)," +
						"book_sl_no varchar(100) not null," +
						"bar_code varchar(100) unique not null," +
						"book_status varchar(100) not null," +
						"added_on varchar(100) not null," +
						"description varchar(10000)," +
						"shelf varchar(100)," +
						"rack varchar(100)," +
						"primary key(sl_no))");
				
				st.execute("create table last_inventry(" +
						"sl_no int(35) auto_increment," +
						"bar_code int(35) not null," +
						"book_sl_no varchar(100)," +
						
						"primary key(sl_no))");
				
				
				Sequence_Issue_Id obj_Sequence_Issue_Id=new Sequence_Issue_Id();
				
				obj_Sequence_Issue_Id.create_table();
				
				
				st.execute("create table issue_book(" +
						"issue_sl_no varchar(50) not null unique," +
						"student_id varchar(100) not null," +
						"admission_no varchar(100) not null," +
						"student_name varchar(100) not null," +
						"book_title varchar(100) not null," +
						"book_sl_no varchar(100) not null," +
						"barcode varchar(100) not null," +
						"issue_date varchar(100) not null," +
						"renew_date1 varchar(100)," +
						"renew_date2 varchar(100)," +
						"renew_date3 varchar(100)," +
						"renew_date4 varchar(100)," +
						"renew_date5 varchar(100)," +
						"return_date varchar(100)," +
						"returned_date varchar(100)," +
						"status varchar(100) not null," +
						"description varchar(10000)," +
						
						"primary key(issue_sl_no))");
				
				
				
					
				} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					if(connection!=null){
						connection.close();
					}
				} catch (Exception e2) {
				}
				try {
					if(st!=null){
						st.close();
					}
				} catch (Exception e2) {
				}
			}
			System.out.println("all tables created");
		}
		
		
		
		public static void main(String[] args) {
			call_me();
		}
		
		
		
}
