package co.micol.prj.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeSelectList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		List<NoticeVO> list = new ArrayList<>();

		NoticeService dao = new NoticeServiceImpl();
		list = dao.noticeSelectList();
		request.setAttribute("list", list);
		
		return "notice/noticeSelectList";
	}

}
