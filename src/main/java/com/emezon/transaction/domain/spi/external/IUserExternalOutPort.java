package com.emezon.transaction.domain.spi.external;

import com.emezon.transaction.domain.models.external.User;

public interface IUserExternalOutPort {

    User findByEmail(String email);

}
