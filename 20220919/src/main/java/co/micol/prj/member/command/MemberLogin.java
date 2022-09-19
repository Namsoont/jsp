package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// �α���ó��
		HttpSession session = request.getSession(); //������ �ҷ��´�.
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo = dao.memberSelect(vo);
		
		if(vo != null) {
			//����ó���ϰ� ������ ������ ����
			session.setAttribute("id", vo.getMemberId()); //���ǰ�ü�� ���̵� ���
			session.setAttribute("author", vo.getMemberAuthor()); //���ǰ�ü�� ���� ���
			session.setAttribute("name", vo.getMemberName()); //���ǰ�ü�� �̸� ���
			request.setAttribute("message", vo.getMemberName() + "�� ȯ���մϴ�.");
			
		} else {
			//���и޼��� ����
			request.setAttribute("message","���̵� �Ǵ� �н����尡 Ʋ�Ƚ��ϴ�.");
		}
		return "member/memberMessage";
	}

}
