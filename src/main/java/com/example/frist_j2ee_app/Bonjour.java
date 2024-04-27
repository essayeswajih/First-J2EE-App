package com.example.frist_j2ee_app;

import com.example.frist_j2ee_app.models.Student;
import com.example.frist_j2ee_app.models.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "Bonjour", value = "/Bonjour")
public class Bonjour extends HttpServlet {
    List<Student> students = new ArrayList<Student>();
    StudentDao stdDao = new StudentDao();
    String Message;
    int StudentCount;

    public Bonjour(){
        StudentCount=0;
        Message="StudentList";
        students = stdDao.listStudents();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        this.students=this.stdDao.listStudents();
        this.StudentCount=this.students.size();
        System.out.print(this.students);
        request.setAttribute("Message", this.Message);
        request.setAttribute("StudentCount", this.StudentCount);
        request.setAttribute("Students",this.students);

        this.getServletContext().getRequestDispatcher("/Bonjour.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        stdDao.addStudent(new Student(req.getParameter("Nom"),
                Integer.parseInt(req.getParameter("Age"))));
        this.students=this.stdDao.listStudents();
        this.StudentCount=this.students.size();
        req.setAttribute("Message", this.Message);
        req.setAttribute("Students", this.students);
        req.setAttribute("StudentCount", this.StudentCount);
        HttpSession session = req.getSession();
        session.setAttribute("nom",req.getParameter("Nom"));
        this.getServletContext().getRequestDispatcher("/Bonjour.jsp").forward(req, resp);
    }
}
