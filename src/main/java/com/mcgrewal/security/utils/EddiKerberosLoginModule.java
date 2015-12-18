package com.mcgrewal.security.utils;

import com.google.common.collect.Maps;
import com.sun.security.auth.module.Krb5LoginModule;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import java.util.Map;

public class EddiKerberosLoginModule
{
    private final String principalName;

    private final Subject subject = new Subject();
    private final Map<String, Object> sharedState = Maps.newHashMap();
    private final Map<String, Object> options = Maps.newHashMap();
    private final Krb5LoginModule krb5LoginModule;

    public EddiKerberosLoginModule(final String principalName)
    {
        this.principalName = principalName;
        this.krb5LoginModule = new Krb5LoginModule();
    }

    public void initialize()
    {
        options.put("debug", "false");
        options.put("storeKey", "false");
        options.put("doNotPrompt", "false");
        options.put("useTicketCache", "true");
        options.put("useKeyTab", "false");
        // options.put("ticketCache", "blah");
        // options.put("keyTab", "blah");
        options.put("principal", principalName);
        options.put("refreshKrb5Config", "false");
        options.put("renewTGT", "true");
        options.put("isInitiator", "true");
        options.put("tryFirstPass", "false");
        options.put("useFirstPass", "false");
        options.put("storePass", "false");
        options.put("clearPass", "false");
        this.krb5LoginModule.initialize(subject, null, sharedState, options);
    }

    public boolean login() throws LoginException
    {
        return krb5LoginModule.login();
    }

    public boolean commit() throws LoginException
    {
        return krb5LoginModule.commit();
    }

    public Subject getSubject()
    {
        return subject;
    }
}
