package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;

public class MemberLogout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// �α׾ƿ� ó��
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name"); //���ǿ� ��� �̸� ��������
		session.invalidate(); //������ ������ �����Ѵ�.
		request.setAttribute("message", name + "�� ���������� �α׾ƿ�");
		
		return "member/memberMessage";
	}

}
