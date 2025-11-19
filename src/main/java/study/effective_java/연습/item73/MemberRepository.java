package study.effective_java.연습.item73;

import study.effective_java.연습.Member;

import java.sql.SQLException;

public class MemberRepository {

    public Member findById(String id) {
        try {
            // 내부에서 JDBC등을 사용한다고 가정
            return queryFromDatabase(id);
        } catch (SQLException e) {
            // 추상화 수준에 맞는 예외로 번역
            throw new RepositoryException("Failed to find member : " + id, e);
        }
    }

    public Member badFindById(String id) throws SQLException {
        return queryFromDatabase(id);
    }

    private Member queryFromDatabase(String id) throws SQLException {
        return null;
    }
}
