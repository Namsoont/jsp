package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceplmpl.MemberServicelmpl;

public class MemberSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// �⼭ �󼼺���
		MemberService dao = new MemberServicelmpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id")); // ������ �Ѿ�� ���̵� ��� 
		vo = dao.memberSelect(vo); // �˻���� ���
		request.setAttribute("member", vo); // �������� �����ϱ�����
		return "member/memberSelect";
	}

}
