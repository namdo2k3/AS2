package com.example.AS2.controller;

import com.example.AS2.model.HocSinh;
import com.example.AS2.model.LopHoc;
import com.example.AS2.repo.HocSinhRepository;
import com.example.AS2.repo.LopHocRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletHocSinh", value = {"/ServletHocSinh"
    ,"/hoc-sinh/hien-thi"
    ,"/hoc-sinh/view-update"
    ,"/hoc-sinh/xoa"
    ,"/hoc-sinh/them"
    ,"/hoc-sinh/sua"
})
public class ServletHocSinh extends HttpServlet {
   LopHocRepository lopHocRepository = new LopHocRepository();
   HocSinhRepository hocSinhRepository = new HocSinhRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String uri = request.getRequestURI();
if(uri.contains("/hoc-sinh/hien-thi")) {
    hienThi(request,response);
}else if(uri.contains("/hoc-sinh/view-update")) {
    viewUpdate(request,response);
}
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        request.setAttribute("hs",hocSinhRepository.getById(id));
        request.setAttribute("listHocSinh", hocSinhRepository.getAll());
        request.setAttribute("listLopHoc", lopHocRepository.getAll());
        request.getRequestDispatcher("/view/view-update.jsp").forward(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listHocSinh", hocSinhRepository.getAll());
        request.setAttribute("listLopHoc", lopHocRepository.getAll());
        request.getRequestDispatcher("/view/hien-thi.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/hoc-sinh/them")) {
            them(request,response);
        }else if(uri.contains("/hoc-sinh/sua")) {
            sua(request,response);
        }
    }

    private void sua(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String hoTen = request.getParameter("hoTen");
        Boolean gioiTinh = Boolean.valueOf(request.getParameter("gioiTinh"));
        String diaChi = request.getParameter("diaChi");
        Integer idLopHoc = Integer.valueOf(request.getParameter("idLopHoc"));
        LopHoc lopHoc = lopHocRepository.getById(idLopHoc);
        HocSinh hocSinh = new HocSinh(id,hoTen,gioiTinh,diaChi,lopHoc);
        hocSinhRepository.HocSinhSua(hocSinh);
        response.sendRedirect("/hoc-sinh/hien-thi");
    }

    private void them(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String hoTen = request.getParameter("hoTen");
        Boolean gioiTinh = Boolean.valueOf(request.getParameter("gioiTinh"));
        String diaChi = request.getParameter("diaChi");
        Integer idLopHoc = Integer.valueOf(request.getParameter("idLopHoc"));
        LopHoc lopHoc = lopHocRepository.getById(idLopHoc);
        HocSinh hocSinh = new HocSinh(null,hoTen,gioiTinh,diaChi,lopHoc);
        hocSinhRepository.HocSinhThem(hocSinh);
        response.sendRedirect("/hoc-sinh/hien-thi");
    }
}
