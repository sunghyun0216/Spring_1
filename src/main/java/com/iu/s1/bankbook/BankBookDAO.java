package com.iu.s1.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BankBookDAO {

	public int setWrite(BankBookDTO bankBookDTO)throws Exception{
		//1. 로그인 정보 
		String user="user01";
		String password="user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		//2. 클래스 로딩
		Class.forName(driver);

		//3. 로그인 Connection
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql ="insert into bankbook values(bank_seq.nextval,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, bankBookDTO.getBookName());
		st.setDouble(2, bankBookDTO.getBookRate());
		st.setString(3, bankBookDTO.getBookSale());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;

	}


	public BankBookDTO getSelect(BankBookDTO bankBookDTO)throws Exception{
		//1. 로그인 정보 
		String user="user01";
		String password="user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		//2. 클래스 로딩
		Class.forName(driver);

		//3. 로그인 Connection
		Connection con = DriverManager.getConnection(url, user, password);

		String sql =" select * from bankbook where booknumber = ?";

		PreparedStatement st = con.prepareStatement(sql);

		st.setLong(1, bankBookDTO.getBookNumber());

		ResultSet rs = st.executeQuery();

		

		if(rs.next()) {
			bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNumber(rs.getLong("bookNumber"));
			bankBookDTO.setBookName(rs.getString("bookName"));
			bankBookDTO.setBookRate(rs.getDouble("bookRate"));
			bankBookDTO.setBookSale(rs.getString("bookSale"));

		}else {
			bankBookDTO=null;
		}

		rs.close();
		st.close();
		con.close();

		return bankBookDTO;

	}	


	//getList
	//bankbook table의 모든 데이트 조회 후 리턴
	public List<BankBookDTO> getList()throws Exception{
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();

		//1. 로그인 정보 
		String user="user01";
		String password="user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		//2. 클래스 로딩
		Class.forName(driver);

		//3. 로그인 Connection
		Connection con = DriverManager.getConnection(url, user, password);

		String sql ="select * from bankbook";

		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();
		System.out.println("executeQuery----------");
		while(rs.next()) {
			System.out.println("count");
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNumber(rs.getLong("bookNumber"));
			bankBookDTO.setBookName(rs.getString("bookName"));
			bankBookDTO.setBookRate(rs.getDouble("bookRate"));
			bankBookDTO.setBookSale(rs.getString("bookSale"));
			ar.add(bankBookDTO);
		}

		rs.close();
		st.close();
		con.close();

		return ar;
	}

}