package com.bishe.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MysqlUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String sql = "insert into userinfo (id,`name`,age,otherinfo) values (1500,'鍚村己3',20,'寰堣嫳淇婏紝鍗佸垎甯呮皵')";
		//add(sql);
		
		//String sqldel = "delete from userinfo where id = 1500";
		//del(sqldel);
		
		//String[] col = {"id","username","age"};
		//String sql = "select * from t_userinfo ";
		//String strJson = MysqlUtil.getJsonBySql(sql, col);
		String[] col = {"id","username","realname","available"};
		String sql = "select * from t_table where id in (1,2,3)";
		String strJson = MysqlUtil.getJsonBySql(sql, col);
		System.out.println(strJson);
//		ArrayList< String[] > data = MysqlUtil.showUtil(sql, col);
//		System.out.println(  data.get(3)[2] );
//		
//		String str = MysqlUtil.show(sql, col);
//		
//		System.out.println(  str );
	}
	
	/**
	 * 
	 * @param sql insert
	 * @return
	 */
	public static int add(String sql) {
		// System.out.println("" + sql);
        int i=0;
        //
        DBConnection db = new DBConnection();
        try {        
            PreparedStatement preStmt = (PreparedStatement) db.conn.prepareStatement(sql);
            preStmt.executeUpdate();
            preStmt.close();
            db.close();//
            i = 1;
           // System.out.println("" + sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;//
    }
    //
    public static ArrayList<String[]> showUtil( String sql, String[] colums){
        
    	 ArrayList<String[]>  result = new  ArrayList<String[]>();
         DBConnection db = new DBConnection();
         try {
            Statement stmt = (Statement) db.conn.createStatement();
            ResultSet rs = (ResultSet) stmt.executeQuery(sql);
           
            while(rs.next()){
               String[] dataRow = new String[colums.length];
               for( int i = 0; i < dataRow.length; i++ ) {
            	   dataRow[i] = rs.getString( colums[i] );
               }
               result.add(dataRow);
            }
            rs.close();
            db.close();//
        } catch (SQLException e) {
            e.printStackTrace();
        } 
         
         return result;
    }
    
    public static int getCount(String sql) {
		int sum = 0;
		DBConnection db = new DBConnection();
		try {
			Statement stmt = (Statement) db.conn.createStatement();
            ResultSet rs = (ResultSet) stmt.executeQuery(sql);
            while (rs.next()) {
            	sum += rs.getInt(1);
            	}
            rs.close();
            db.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sum;
	}
    
    public static String getJsonBySql( String sql, String[] colums){
        
     System.err.println("sql:" + sql);
   	 ArrayList<String[]>  result = new  ArrayList<String[]>();
        DBConnection db = new DBConnection();
        try {
           Statement stmt = (Statement) db.conn.createStatement();
           ResultSet rs = (ResultSet) stmt.executeQuery(sql);
           while(rs.next()){
              String[] dataRow = new String[colums.length];
              for( int i = 0; i < dataRow.length; i++ ) {
           	   dataRow[i] = rs.getString( colums[i] );
              }
              result.add(dataRow);
           }
           rs.close();
           db.close();//
       } catch (SQLException e) {
           e.printStackTrace();
       } 
        
        return listToJson(result,colums);
   }
    
    public static String getLayuiBySql( String sql, String[] colums){
        
        System.err.println("sql:" + sql);
      	 ArrayList<String[]>  result = new  ArrayList<String[]>();
           DBConnection db = new DBConnection();
           try {
              Statement stmt = (Statement) db.conn.createStatement();
              ResultSet rs = (ResultSet) stmt.executeQuery(sql);
              while(rs.next()){
                 String[] dataRow = new String[colums.length];
                 for( int i = 0; i < dataRow.length; i++ ) {
              	   dataRow[i] = rs.getString( colums[i] );
                 }
                 result.add(dataRow);
              }
              rs.close();
              db.close();//
          } catch (SQLException e) {
              e.printStackTrace();
          } 
           
           return listToJsonLayui(result,colums);
      }

    public static int update(String sql) {
        int i =0;
        DBConnection db = new DBConnection();
        try {
            PreparedStatement preStmt = (PreparedStatement) db.conn.prepareStatement(sql);
            preStmt.executeUpdate();
            preStmt.close();
            db.close();
            i = 1;
            System.out.println("  " + sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    

    /**
     *  
     * @param sql select * from 
     * @param params [id,name,sex,age] 
     * @return
     */
    public static String show(String sql, String[] params){
    	
    	List< Map<String,String> > listmap = new ArrayList<>();
    	
         DBConnection db = new DBConnection();
         ResultSet rs = null;
         try {
            Statement stmt = (Statement) db.conn.createStatement();
            rs = (ResultSet) stmt.executeQuery(sql);
            while(rs.next()){
            	Map<String,String> map = new HashMap<String,String>();
            	for(int i = 0; i < params.length; i++) {
            		map.put(params[i], rs.getString(params[i]));
            	}
            	listmap.add(map);
            }
            rs.close();
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
		return mapToJson(listmap); 
         
     
    }
    
  
    
  
    public static int del(String delstr) {
        int i=0;
        DBConnection db = new DBConnection();
        try {    
            PreparedStatement preStmt = (PreparedStatement) db.conn.prepareStatement(delstr);
            preStmt.executeUpdate();
            
            preStmt.close();
            db.close();
            i = 1;
            System.out.println("" + delstr);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    
    /**
     * map
     * @param maplist
     * @return
     */
    public static String mapToJson( List<Map<String,String>> maplist ) {
    	String jsonData = "{ \"data\":[";
		for(int i = 0; i < maplist.size(); i++) {
			String outstr = "[\"" ;
			int size = 0;
			for(String value : maplist.get(i).values()){
				size += 1;
				outstr += value;
				if( size < maplist.get(i).values().size() ) {
				     outstr += "\",\"";
				}
			}
		    outstr += "\"]";
		    
		    if(i < maplist.size() -1) {
		    	outstr += ",";
		    }
			jsonData += outstr;
			
		}
		jsonData += "]}";
		
		return jsonData;
    }
    
    
    
    public static String listToJsonLayui( ArrayList<String[]> list,String[] colums) {

    	String jsonStr = "[{\"status\":0}, {\"message\": \"\" }, {\"count\": 1000},{\"rows\":{\"item\":[";
    			for(int i = 0; i < list.size(); i++) {
    				String arr = "{";
    				for( int j = 0; j < list.get(0).length; j++) {
    					
    					if( list.get(i)[j] == null || "NULL".equals(list.get(i)[j])) {
    						arr += "\"\"";
    					}else {
    						arr += "\"" + colums[j] + "\""+":" ;
    						arr +=  "\"" + list.get(i)[j].replace("\"","\\\"") + "\"";
    					}
    					
    					if( j < list.get(0).length - 1 ) {
    						arr += ",";
    					}
    				}
    				arr += "}";
    				if( i < list.size() - 1 ) {
						arr += ",";
					}
    				
    				jsonStr += arr;
    			}
    			jsonStr += "]}}]";
    	
    	return jsonStr;
    }
    

    public static String listToJson( ArrayList<String[]> list,String[] colums) {

    	String jsonStr = "{ \"data\":[";
    			for(int i = 0; i < list.size(); i++) {
    				String arr = "{";
    				for( int j = 0; j < list.get(0).length; j++) {
    					
    					if( list.get(i)[j] == null || "NULL".equals(list.get(i)[j])) {
    						arr += "\"\"";
    					}else {
    						arr += "\"" + colums[j] + "\""+":" ;
    						arr +=  "\"" + list.get(i)[j].replace("\"","\\\"") + "\"";
    					}
    					
    					if( j < list.get(0).length - 1 ) {
    						arr += ",";
    					}
    				}
    				arr += "}";
    				if( i < list.size() - 1 ) {
						arr += ",";
					}
    				
    				jsonStr += arr;
    			}
    			jsonStr += "]}";
    	
    	return jsonStr;
    }

}
