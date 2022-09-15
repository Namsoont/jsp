package co.micol.prj.member.service;

import java.util.List;

public interface MemberService {
	List<MemberVO> memberSelectList();  //��ü��� ��������
	MemberVO memberSelect(MemberVO vo); //�Ѹ��� ������ ��������, �α��� �� ���
	int memberInsert(MemberVO vo);  //������ �߰�
	int memberUpdate(MemberVO vo);  //������ ����
	int memberDelete(MemberVO vo);  //������ ����
	
	boolean isMemberIdCheck(String id);  //���̵� �ߺ�üũ �����ϸ� false
	
	
}
