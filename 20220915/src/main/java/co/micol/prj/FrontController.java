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
 * 모든 .do 요청을 분석하고 처리한다.
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>(); //요청 값을 저장하기 위해
    
    public FrontController() {
        super();
    
    }
    public void init(ServletConfig config) throws ServletException {
    	// 모든 요청을 등록하는 곳
    	map.put("/main.do", new MainCommand()); //처음 시작하는페이지
    	map.put("/memberSelectList.do", new MemberSelectList()); //멤버목록 보기
    	map.put("/memberSelect.do", new MemberSelect()); //멤버상세정보
    	map.put("/memberJoinForm.do", new memberJoinForm()); //멤버 입력 화면
    	map.put("/memberInsert.do", new MemberInsert()); //멤버 입렵 처리
    	map.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck()); //아이디 중복체크
    	
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 요청 분석, 처리, 결과 돌려주는 곳
    	request.setCharacterEncoding("utf-8"); //한글 깨짐방지
    	String uri = request.getRequestURI(); //도메인을 제외한 실제 요청정보
    	String contextPath = request.getContextPath(); // ContextPath 구함
    	String page = uri.substring(contextPath.length()); //처리할 요청명 구함
    	System.out.println(request.getRequestURI());
    	System.out.println(uri);
    	System.out.println(contextPath);
    	System.out.println(page);
    	System.out.println(request.getRemoteUser());
    	
    	
    	Command command = map.get(page); // 처리할 Command를 찾음
    	String viewPage = command.exec(request, response); //Command를 실행하고 돌려줄 페이지를 받음
    	
    	if(!viewPage.endsWith(".do"))	{
    		if(viewPage.startsWith("ajax:")) { //ajax를 처리하기 위한 view Resolve
    			response.setContentType("text/html; charset=UTF-8");
    			response.getWriter().append(viewPage.substring(5));
    			System.out.println(viewPage.substring(5));
    			return;
    		}else { //리턴값이 보여줄 페이지를 가지고 올때
    		viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
    		dispatcher.forward(request, response);
    		}
    	} else {
    		response.sendRedirect(viewPage); //리턴값이 *.do로 올때 처리
    	}
    	
    }

 }
