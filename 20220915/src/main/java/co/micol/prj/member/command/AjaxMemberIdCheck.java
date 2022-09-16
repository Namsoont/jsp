package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceplmpl.MemberServicelmpl;

public class AjaxMemberIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// Ajax�� ���̵� �ߺ� üũ�� �ϴ� �κ�.
		// ���ϰ��� true�� ��밡���� ���̵�
		MemberService dao = new MemberServicelmpl();
		String id = request.getParameter("id");
		boolean b = dao.isMemberIdCheck(id);
		String str = "ajax:0"; //�������� ������ ���� ���� ����
		if(b) {
			str = "ajax:1"; // view Resolv�� Ajaxȣ���̶�� ���� �˷��ֱ� ����
		}
		return str; 
	}

}
