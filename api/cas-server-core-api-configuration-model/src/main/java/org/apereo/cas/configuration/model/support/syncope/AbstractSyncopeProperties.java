package org.apereo.cas.configuration.model.support.syncope;

import com.fasterxml.jackson.annotation.JsonFilter;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apereo.cas.configuration.support.RequiredProperty;
import org.apereo.cas.configuration.support.RequiresModule;

/**
 * This is {@link AbstractLdapProperties}.
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-syncope-authentication")
@Getter
@Setter
@Accessors(chain = true)
@JsonFilter("AbstractSyncopeProperties")
public abstract class AbstractSyncopeProperties implements Serializable {

    private static final long serialVersionUID = 98513672245088L;

    /**
     * Syncope domain used for authentication, etc.
     * Multiple domains can be separated via comma.
     * Each domain entry results in a separate authentication attempt
     * and transaction by CAS.
     */
    @RequiredProperty
    private String domain = "Master";

    /**
     * Syncope instance URL primary used for REST.
     */
    @RequiredProperty
    private String url;

}