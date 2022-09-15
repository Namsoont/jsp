package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceplmpl.MemberServicelmpl;

public class MemberInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 멤버 추가
		MemberService dao = new MemberServicelmpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberAuthor(request.getParameter("memberAuthor"));
		int n = dao.memberInsert(vo);
		String viewPage = null; //돌려줄페이지
		if(n != 0) {
//			request.setAttribute("message", "정상적으로 입력이 완료.");
			viewPage = "memberSelectList.do";
		} else {
//			request.setAttribute("message", "정상적으로 입력이 실패.");
			viewPage = "member/memberMessage";
		}
//		return "member/memberMessage";
		return viewPage;
		
	}

}
