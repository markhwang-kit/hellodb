package db;

import java.sql.*;

public class DBClass {
	// 연결
	public static Connection condb() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USER, DBConfig.DB_PW);
		System.out.println("연결 성공");
		return conn;
	}
	
	public static void conTest() {
		Connection conn = null;

		try {
			conn = DBClass.condb();

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 데이터 넣기
	public static void insert(String name, int price) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBClass.condb();
			String sql = "INSERT INTO food_tb (NAME, price) VALUES(?, ?)";
			pstmt = conn.prepareStatement(sql);
			// 4. 데이터 binding
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 데이터 보기
	public static void select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBClass.condb();
			String sql = "SELECT * FROM food_tb";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString("num") + ". ");
				System.out.print(rs.getString("name") + " ");
				System.out.println(rs.getString("price"));
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if( rs != null && !rs.isClosed()){
                    rs.close();
                }
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
