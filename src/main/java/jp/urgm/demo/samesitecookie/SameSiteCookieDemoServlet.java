package jp.urgm.demo.samesitecookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class SameSiteCookieDemoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Cookieを返すためにセッションを作る
		req.getSession();

		// 明示的なCookieの追加もしておく
		Cookie cookie = new Cookie("demo", "foobar");
		resp.addCookie(cookie);

		resp.setContentType("text/plain");
		try (PrintWriter out = resp.getWriter()) {
			out.print("Hello, world!");
			out.flush();
		}
	}
}
