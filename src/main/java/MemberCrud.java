import domain.Member;
import mapper.s2.MemberMapper;
import org.apache.ibatis.session.SqlSession;
import util.HikariMyBatisConnector;
import util.IbatisPooledCpConnector;
import util.MyBatisSessionConnector;

public class MemberCrud {

    static void main() throws Exception {

        MyBatisSessionConnector connector = new HikariMyBatisConnector(
                "mapper.s2",
                "domain"
        );

        try (SqlSession conn = connector.openSession()) {

            MemberMapper memberMapper = conn.getMapper(MemberMapper.class);

            Member member1 = new Member(
                    null, "user_" + genRandomNumber(), "1234", "user%d@email.com".formatted(genRandomNumber()), genRandomNumber()
            );

            Member member2 = new Member(
                    null, "user_" + genRandomNumber(), "1234", "user%d@email.com".formatted(genRandomNumber()), genRandomNumber()
            );

            memberMapper.save(member1);
            memberMapper.save(member2);

            System.out.println("member1 id = " + member1.getId());
            System.out.println("member2 id = " + member2.getId());

        }

    }


    private static int genRandomNumber() {
        return (int) (Math.random() * 1000000);
    }

}
