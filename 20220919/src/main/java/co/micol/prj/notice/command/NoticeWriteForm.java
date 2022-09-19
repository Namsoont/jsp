package co.micol.prj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;

public class NoticeWriteForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 글쓰기 form 호출
		return "notice/noticeWriteForm";
	}

}
