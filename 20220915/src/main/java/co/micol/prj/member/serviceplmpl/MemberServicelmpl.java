package co.micol.prj.member.serviceplmpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.prj.common.DataSource;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;

public class MemberServicelmpl implements MemberService {
	private DataSource dao = new DataSource();
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	@Override
	public List<MemberVO> memberSelectList() {
		// ��ü ��� ��� ��������
		List<MemberVO> list = new ArrayList<>();
		MemberVO vo;
		String sql = "SELECT * FROM MEMBER";
		try {
			psmt = dao.conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberTel(rs.getString("member_tel"));
				vo.setMemberAuthor(rs.getString("member_author"));
				list.add(vo);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(); //connection�� �����ش�
		}
		
		return list;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// �Ѹ��� ����� ��ȸ �Ѵ�.
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
		try {
			psmt = dao.conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberTel(rs.getString("member_tel"));
				vo.setMemberAuthor(rs.getString("member_author"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// �Ѹ��� ������ �߰�
		int n = 0;
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?)";
		try {
			psmt = dao.conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			psmt.setString(3, vo.getMemberName());
			psmt.setString(4, vo.getMemberTel());
			psmt.setString(5, vo.getMemberAuthor());
			n = psmt.executeUpdate(); //�����ϸ� 1, �����ϸ� 0
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// �Ѹ��� ������ ����, ���̵� ������ ��簪�� ���� ���� ��.
		int n = 0;
		String sql = "UPDATE MEMBER SET MEMBER_PASSWORD = ?, MEMBER_NAME = ?, MEMBER_TEL = ?"
				+ "MEMBER_AUTHOR = ? WHERE MEMBER_ID = ?";
		try {
			psmt = dao.conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberPassword());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getMemberTel());
			psmt.setString(4, vo.getMemberAuthor());
			psmt.setString(5, vo.getMemberId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// ��� ����
		int n = 0;
		String sql ="DELETE FROM WHERE MEMBER_ID = ?";
		try {
			psmt = dao.conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}

	@Override
	public boolean isMemberIdCheck(String id) {
		// ���̵� �ߺ� üũ �����ϸ� false,
		boolean b = true;
		String sql = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_ID = ?";
		try {
			psmt = dao.conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(!rs.next()) {
				b = false; // �����ϸ�
			}
		} catch (SQLException e) {
			
		} finally {
			close();
		}
		return b;
	}
	
	private void close() { // DBMS �� ������ �����ش�.
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(dao.conn != null) dao.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
