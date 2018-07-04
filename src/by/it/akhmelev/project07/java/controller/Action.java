package by.it.akhmelev.project07.java.controller;

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
    EDITUSERS{
        {
            cmd=new CmdEditUsers();
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
