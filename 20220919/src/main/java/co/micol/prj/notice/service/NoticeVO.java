package co.micol.prj.notice.service;


import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeSubject;
	private Date noticeDate;  // 시분초가중요하면 java.util, 안 중요하면 java.sql
	private String noticeAttech;
	private String noticeAttechDirectory;
	private int noticeHit;
}
