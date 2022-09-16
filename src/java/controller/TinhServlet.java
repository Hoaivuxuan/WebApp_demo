/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author vuxua
 */
//@WebServlet(name="TinhServlet", urlPatterns = {"/tinh"})
public class TinhServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dai_raw=request.getParameter("dai");
        String rong_raw=request.getParameter("rong");
        String cv=request.getParameter("cv");
        String dt=request.getParameter("dt");
        double a,b;
        String box="";
        PrintWriter out = response.getWriter();
        try {
            a=Double.parseDouble(dai_raw);
            b=Double.parseDouble(rong_raw);
            //
            if((cv==null) && (dt==null)){
                box="Chua chon";
            }else if((cv!=null) && (dt==null)){
                box="Chu vi:"+((a+b)*2);
            }else if((cv==null) && (dt!=null)){
                box="Dien tich:"+ (a*b);
            }else{
                box="Chu vi:"+(a+b)*2 + " Dien tich:"+ (a*b);
            }
            out.println("<h1>"+box+"</h1>");
        }catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("checkbox.html").forward(request, response);
    }
    
}
