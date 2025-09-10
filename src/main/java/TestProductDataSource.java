
/** 自行取得DataSource的 servlet
 
 1.配合 web.xml 如下:
    <resource-ref>
      <description>DB Connection</description>
      <res-ref-name>jdbc/TestDB2</res-ref-name>
      <res-type>javax.sql.DataSource</res-type>
      <res-auth>Container</res-auth>
    </resource-ref>
 2.需配合 server.xml 或 context.xml
    -參考: http://localhost:8080/index.jsp 首頁
             之 Tomcat Documentation 之 JNDI DataSource HOW-TO 的說明
    -注意: 隨 servlet container 版本寫法會不同              
*/
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;

@WebServlet("/TestProductDataSource")
public class TestProductDataSource extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = res.getWriter();

		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CJA102G1test");
			Connection conn = ds.getConnection();

			if (conn != null) {
				out.println("Got Connection: " + conn.toString());
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from product");
				while (rs.next()) {
					out.println("商品編號 = " + rs.getInt(1));
					out.println("商品所屬小農 = " + rs.getInt(9));
					out.println("商品名稱 = " + rs.getString(2)+"\n");
					

				}
				conn.close();
			}

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}