package hello.servlet.basic.reponse;

import com.sun.net.httpserver.HttpsServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.spec.RSAOtherPrimeInfo;

@WebServlet(name ="repsonseHeaderServlet", urlPatterns = "/reponse-header")
public class RepsonseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        response.setStatus(200);
        //[status-Line]
        response.setStatus(HttpServletResponse.SC_OK);

       // [reponse-headers]
        response.setHeader("content-type", "text/plain; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

//        content(response);
//        cookie(response);

        redirect(response);

        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성)
    }
    private void cookie(HttpServletResponse response) {
//        Set-Cookie: myCookie=good; Max-Age=600;
//        response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html
        response.setStatus(HttpServletResponse.SC_FOUND); //302
//        response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}
