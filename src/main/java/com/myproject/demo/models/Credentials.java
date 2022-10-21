package com.myproject.demo.models;

public class Credentials {
    private Password password;

    private RecoveryQuestion recovery_question;
    private Provider provider;

    public Credentials() {
    }

    public Credentials(Password password, RecoveryQuestion recovery_question, Provider provider) {
        this.password = password;
        this.recovery_question = recovery_question;
        this.provider = provider;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
    public RecoveryQuestion getRecoveryQuestion() {
        return recovery_question;
    }

    public void setRecoveryQuestion(RecoveryQuestion recovery_question) {
        this.recovery_question = recovery_question;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
