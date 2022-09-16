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
import co.micol.prj.member.command.AjaxMemberIdCheck;
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
    	map.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck()); //���̵� �ߺ�üũ
    	
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
    		if(viewPage.startsWith("ajax:")) { //ajax�� ó���ϱ� ���� view Resolve
    			response.setContentType("text/html; charset=UTF-8");
    			response.getWriter().append(viewPage.substring(5));
    			System.out.println(viewPage.substring(5));
    			return;
    		}else { //���ϰ��� ������ �������� ������ �ö�
    		viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
    		dispatcher.forward(request, response);
    		}
    	} else {
    		response.sendRedirect(viewPage); //���ϰ��� *.do�� �ö� ó��
    	}
    	
    }

 }
