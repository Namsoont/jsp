package co.micol.prj.notice.service;

import java.util.List;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	void noticeHitUpdate(int id);  // 게시글 조회수 올리는거 
	// mybatis에서는 메서드 오버로딩 구분 못함. 그래서 noticeSelectList -> noticeSearchList
	List<NoticeVO> noticeSearchList(String key, String val); // 게시글 검색
}
