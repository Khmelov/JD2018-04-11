package by.it.kasiyanov.project.java.controller;

public enum Action {
    INDEX{
        {
            cmd = new CmdIndex();
        }
    },
    CREATEOFFER{
        {
            cmd = new CmdCreateOffer();
        }
    },
    LOGIN{
        {
            cmd = new CmdLogin();
        }
    },
    PROFILE {
        {
            cmd = new CmdProfile();
        }
    },
    SIGNUP{
        {
            cmd = new CmdSignUp();
        }
    },
    RESETDB {
        {
            cmd = new CmdResetDB();
        }
    },
    ERROR{
        {
            cmd = new CmdError();
        }
    };

    Cmd cmd = new CmdError();
    String jsp = "/"+this.toString().toLowerCase()+".jsp";
}
