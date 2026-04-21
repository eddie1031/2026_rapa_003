package mapper.s4;

import domain.Member;
import domain.MemberDto;

import java.util.List;

public interface MemberMapper {

    List<MemberDto> findAll();

}
