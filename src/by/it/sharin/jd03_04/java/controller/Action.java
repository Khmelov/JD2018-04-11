package by.it.sharin.jd03_04.java.controller;

enum Action {
    INDEX {
        {
            cmd = new CmdIndex();
        }
    },
    CREATEAD {
        {
            cmd = new CmdCreateAd();
        }
    },
    LOGIN {
        {
            cmd = new CmdLogin();
        }
    },
    PROFILE {
        {
            cmd = new CmdProfile();
        }
    },
    SIGNUP {
        {
            cmd = new CmdSignUp();
        }
    },
    RESETDB {
        {
            cmd = new CmdResetDB();
        }
    },
    ERROR {
        {
            cmd = new CmdError();
        }
    };
    Cmd cmd = new CmdError();
    String jsp = "/"+this.toString().toLowerCase()+".jsp";

}
