package org.orcid.core.manager;

import org.orcid.pojo.ajaxForm.Member;

public interface MembersManager {

    Member createMember(Member member) throws IllegalArgumentException;

    Member updateMemeber(Member member) throws IllegalArgumentException;

    Member getMember(String memberId);

    void clearCache();
}
