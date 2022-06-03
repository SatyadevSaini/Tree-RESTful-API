package com.incapp.repo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.incapp.bean.Tree;

@Repository
public class TreeREPO {
       
	   @Autowired
	  JdbcTemplate jdbcTemplate;
	   
	   // Add tree 
	   
	   public String addTree(Tree tree , MultipartFile image) {
		   
		   try {
			String query = "insert into tree values(?,?,?,?)";
			int x = jdbcTemplate.update(query ,new Object[] {tree.getId() , tree.getName() , tree.getFruit() , image.getInputStream()});
			
			if(x!=0) {
				return "success";
			}
			else {
				return "failed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return"failed";
		}  
	   } 


  // get All trees 

  public List<Tree> getAllTrees(){
	  
	  class DataMapper implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Tree t = new Tree();
			t.setId(rs.getInt("id"));
			t.setName(rs.getString("name"));
			t.setFruit(rs.getString("fruit"));
			
			return t;
		}  
	  }
	  
	  try {
		  String query = "select * from tree";
		List<Tree> tree=   jdbcTemplate.query(query, new DataMapper());
		
		return tree;
		
	} catch (Exception e) {
		e.printStackTrace();
	return null;
	}  
  }
  
  
  //get All Trees ID 
  public List<Integer> getAllIdTrees(){
	  class DataMapper implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return rs.getInt("id");
		}  
	  }
	  try { String query = "select id from tree";
	  List<Integer> ids = jdbcTemplate.query(query, new DataMapper());
	  
	  return ids;
		
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}  
  }
  
  
   public String deleteID(int id) {
	 
	   try {
		   String query = "delete from tree where id=?";
		    int x = jdbcTemplate.update(query, new Object[] {id});
		    	if(x!=0) {
		    		return "success";}
		    		else {
						return "failed";
					}
		    
	} catch (Exception e) {
		e.printStackTrace();
		return "failed";
	}
	   
   }
   
   
   //getImage
   public byte[] getImage(int id) {
	   class DataMapper implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return rs.getBytes("image");
		}   
	   }
	   try {
		   String query = "select image from tree where id=? ";
		   byte[] image = (byte[]) jdbcTemplate.queryForObject(query,new DataMapper() , new Object[] {id});
		   return image;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}   
 }
   
   
   // update image with profile 
   
   public String UpdatewithImage(Tree tree , MultipartFile image) {
     
	   try {
		 String query = "update tree set name=? ,fruit=?, image=? where id=?";
		int x =  jdbcTemplate.update(query , new Object[] { tree.getName() , tree.getFruit(),image.getInputStream() , tree.getId()});
		
		if(x!=0) {
			return"success";
		}else {
			return"failed";
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return"failed";
	}
   }
   
   // delete Furniture 
   
 
   
   
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}