package co.micol.prj.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceplmpl.MemberServicelmpl;


//@WebServlet("/MemberSelect")
public class MemberSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�Ѹ� ��ȸ
		MemberService dao = new MemberServicelmpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id")); // ������ �Ѿ�� ���̵� ��� 
		vo = dao.memberSelect(vo); // �˻���� ���
		request.setAttribute("member", vo); // �������� �����ϱ�����
		String viewPage = "/WEB-INF/views/member/memberSelect.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
