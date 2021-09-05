package org.geekbang.week.five.homework3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author lil
 */
public class JDBCDemo {

    /**
     * 获取连接
     */
    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://100.100.100.201:3306/geekbang";
        String username = "root";
        String password = "TTGMM77..";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static int insert(Student student) {
        Connection conn = getConn();
        if (conn == null) {
            System.out.println("获取连接错误");
            return -1;
        }
        int i = 0;
        String sql = "insert into student (name, age) values(?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    private static int update(Student student) {
        Connection conn = getConn();
        int i = 0;
        String sql = "update student set age= ? where `name`= ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, student.getAge());
            pstmt.setString(2, student.getName());
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    private static List getAll() {
        Connection conn = getConn();
        String sql = "select `name`, age from student";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            // int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Student student = new Student();
                student.setName(rs.getString(1));
                student.setAge(rs.getInt(2));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
