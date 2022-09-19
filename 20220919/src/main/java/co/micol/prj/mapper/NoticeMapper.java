package co.micol.prj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.notice.service.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	void noticeHitUpdate(int id);  // 게시글 조회수 올리는거 
	// 매개변수가 2개일때는 각각 앞에 @Param을 붙여줘야함.
	List<NoticeVO> noticeSearchList(@Param("key") String key, @Param("val") String val); // 게시글 검색
	
	
	// 서비스 인터페이스와 mapper인터페이스의 차이는 @Param을 붙이는거다. Mapper.xml에서 인식을 할 수 있게 해줘야한다.
	// @Param("key") 라고 넘어오면 String key에 담아서 쓸거야. 알겠지 Mapper.xml아?
}
