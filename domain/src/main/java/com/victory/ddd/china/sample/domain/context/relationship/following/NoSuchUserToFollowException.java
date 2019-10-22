package com.victory.ddd.china.sample.domain.context.relationship.following;

import com.victory.ddd.china.sample.domain.build.block.DomainBusinessException;

class NoSuchUserToFollowException extends DomainBusinessException {
    NoSuchUserToFollowException(String toFollow) {
        super(String.format("no such user to follow %s", toFollow));

    }
}

