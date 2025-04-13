package com.bichpormak.data;

import com.bichpormak.model.Credentials;

public class CredentialsProvider {

    public static Credentials getValidCredentials() {
        return new Credentials("technopol60", "technopolisPassword");
    }

    public static Credentials getInvalidCredentials() {
        return new Credentials("*****", "*****");
    }

}
