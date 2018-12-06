package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {

	private long nextId = 0;

	private Map<String, Member> mapMem = new HashMap<>();

	public Member selectByEmail(String email) {
		return mapMem.get(email);
	}

	public void insert(Member member) {
		member.setId(++this.nextId);
		mapMem.put(member.getEmail(), member);
	}

	public void update(Member member) {
		mapMem.put(member.getEmail(), member);
	}

	public Collection<Member> selectAll() {
		return mapMem.values();
	}
}
