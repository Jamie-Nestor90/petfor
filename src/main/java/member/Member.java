package member;

import java.io.IOException;
import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/Member.do")
public class Member extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPro(request, response);
   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPro(request, response);
   }
   
   protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("name");
      String job = request.getParameter("job");
      String tel = request.getParameter("tel");
      
      Connection conn = null;
      PreparedStatement pstmt;
      
      try{
            //외부에서 데이터를 읽어 드려야 하기에 
          Context initctx = new InitialContext();
          //톰캣 서버에 정보를 담아 놓은 곳 으로 이동 
          Context envctx = (Context)initctx.lookup("java:comp/env");
          //데이터 베이스 객체를 선언 
          DataSource ds =  (DataSource)envctx.lookup("jdbc/pool");
          //데이터 소스를 기준으로 커넥션을 연결해 주시오
          conn =ds.getConnection();
               
       }catch(Exception e){
          e.printStackTrace();
       }
      
      try {
         String sql = "INSERT INTO MEMBER(name, job, phone) values(?,?,?)";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, name);
         pstmt.setString(2, job);
         pstmt.setString(3, tel);
         pstmt.executeUpdate();
      }catch (Exception e) {
         e.printStackTrace();
      }
   }

}

