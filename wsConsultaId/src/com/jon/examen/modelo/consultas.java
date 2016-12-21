package com.jon.examen.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.jon.examen.control.User;

public class consultas {
	
	
	public static Connection getConnection()
	{
		Connection con=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/examen","jona","1234");
		}catch (Exception e){System.out.println(e);}
		return con;
	}
	
	
	public static int save(User u)
	{
		int status=0;
		try
		{
			Connection con =getConnection();
			PreparedStatement ps =con.prepareStatement(
					"insert into infosyst(nombre,apellido_paterno,apellido_materno,email,edad,ingresos_mensuales,fecha_ingreso) values (?,?,?,?,?,?,?)");
			
			ps.setString(1,u.getNombre());
			ps.setString(2,u.getApellido_paterno());
			ps.setString(3,u.getApellido_materno());
			ps.setString(4,u.getEmail());
			ps.setInt(5,u.getEdad());
			ps.setInt(6,u.getIngresos_mensuales());
			ps.setString(7,u.getFecha());
			
			
			status=ps.executeUpdate();
			
		}catch (Exception e){System.out.println(e);}
		return status;
	}
	 
	public static int update(User u)
	{
		int status=0;
		try
		{
			Connection con =getConnection();
			PreparedStatement ps =con.prepareStatement(
					"update infosyst set nombre=?,apellido_paterno=?,apellido_materno=?,email=?,edad=?,ingresos_mensuales=?,fecha_ingreso=? where id=?");
			
			
			ps.setString(1,u.getNombre());
			ps.setString(2,u.getApellido_paterno());
			ps.setString(3,u.getApellido_materno());
			ps.setString(4,u.getEmail());
			ps.setInt(5,u.getEdad());
			ps.setInt(6,u.getIngresos_mensuales());
			ps.setString(7,u.getFecha());
			ps.setInt(8,u.getId());
			
			status=ps.executeUpdate();
			
		}catch (Exception e){System.out.println(e);}
		return status;
	}
	
	
	public static int delete(User u)
	{
		int status=0;
		try
		{
			Connection con =getConnection();
			PreparedStatement ps =con.prepareStatement(
					"delete from infosyst where id=?");
			
			
			ps.setInt(1,u.getId());
			status=ps.executeUpdate();
			
		}catch (Exception e){System.out.println(e);}
		return status;
	}
	
	
	public static List<User> getAllRecords()
	{
		
		List<User>list=new ArrayList<User>();
		
		try
		{
			Connection con =getConnection();
			PreparedStatement ps =con.prepareStatement(
					"select * from infosyst");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
			
			User u = new User();	
			
			u.setId(rs.getInt("id"));
			u.setNombre(rs.getString("nombre"));
			u.setApellido_paterno(rs.getString("apellido_paterno"));
			u.setApellido_materno(rs.getString("apellido_materno"));
			u.setEmail(rs.getString("email"));
			u.setEdad(rs.getInt("edad"));
			u.setIngresos_mensuales(rs.getInt("ingresos_mensuales"));
			u.setFecha(rs.getString("fecha_ingreso"));
			
			
			list.add(u);
			}
		}catch (Exception e){System.out.println(e);}
		return list;
	}
	
	public static User getRecordById(int id)
	{
		
		User u= new User();
		
		try
		{
			Connection con =getConnection();
			PreparedStatement ps =con.prepareStatement(
					"select * from infosyst where id=?");
			
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
			
		System.out.println("si");
			
				u.setId(rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido_paterno(rs.getString("apellido_paterno"));
				u.setApellido_materno(rs.getString("apellido_materno"));
				u.setEmail(rs.getString("email"));
				u.setEdad(rs.getInt("edad"));
				u.setIngresos_mensuales(rs.getInt("ingresos_mensuales"));
				u.setFecha(rs.getString("fecha_ingreso"));
			
			
			}
		}catch (Exception e){System.out.println(e);}
		return u;
	}
	
	public static void fecha(User u)
	{
		Calendar c = new GregorianCalendar();
		u.setDia(Integer.toString(c.get(Calendar.DATE)));
		u.setMes( Integer.toString(c.get(Calendar.MONTH)+1));
		u.setAño( Integer.toString(c.get(Calendar.YEAR)));
		
	}
	
	public static String getNomByid(int id)
	{
		
String u= "naruto";
		
		try
		{
			Connection con =getConnection();
			PreparedStatement ps =con.prepareStatement(
					"select nombre from infosyst where id=?");
			
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
			
		System.out.println("si");
			
				
				u=rs.getString("nombre");
				
			
			
			}
		}catch (Exception e){System.out.println(e);}
		return u;
		
	}
//jonathan
}
