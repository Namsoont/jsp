package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class MemberInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 멤버 추가

		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberAuthor(request.getParameter("memberAuthor"));

		String viewPage = null; // 돌려줄 페이지

		if (dao.memberInsert(vo) != 0) {
//				request.setAttribute("message", "정상적으로 입력이 되었습니다.");
			viewPage = "memberSelectList.do";
		} else {
			request.setAttribute("message", "입력에 실패했습니다.");
			viewPage = "member/memberMessage";
		}
		return viewPage;
	}

}
