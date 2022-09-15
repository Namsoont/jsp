package co.micol.prj;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.command.MemberInsert;
import co.micol.prj.member.command.MemberSelect;
import co.micol.prj.member.command.MemberSelectList;
import co.micol.prj.member.command.memberJoinForm;

/**
 * Servlet implementation class FrontController
 * ��� .do ��û�� �м��ϰ� ó���Ѵ�.
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>(); //��û ���� �����ϱ� ����
    
    public FrontController() {
        super();
    
    }
    public void init(ServletConfig config) throws ServletException {
    	// ��� ��û�� ����ϴ� ��
    	map.put("/main.do", new MainCommand()); //ó�� �����ϴ�������
    	map.put("/memberSelectList.do", new MemberSelectList()); //������ ����
    	map.put("/memberSelect.do", new MemberSelect()); //���������
    	map.put("/memberJoinForm.do", new memberJoinForm()); //��� �Է� ȭ��
    	map.put("/memberInsert.do", new MemberInsert()); //��� �Է� ó��
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// ��û �м�, ó��, ��� �����ִ� ��
    	request.setCharacterEncoding("utf-8"); //�ѱ� ��������
    	String uri = request.getRequestURI(); //�������� ������ ���� ��û����
    	String contextPath = request.getContextPath(); // ContextPath ����
    	String page = uri.substring(contextPath.length()); //ó���� ��û�� ����
    	System.out.println(request.getRequestURI());
    	System.out.println(uri);
    	System.out.println(contextPath);
    	System.out.println(page);
    	System.out.println(request.getRemoteUser());
    	
    	
    	Command command = map.get(page); // ó���� Command�� ã��
    	String viewPage = command.exec(request, response); //Command�� �����ϰ� ������ �������� ����
    	
    	if(!viewPage.endsWith(".do"))	{
    		viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
    		dispatcher.forward(request, response);
    	} else {
    		response.sendRedirect(viewPage);
    	}
    	
    }

 }
