package by.it.tarasiuk.project.java.controller;

enum Action {
    INDEX {
        {
            cmd = new CmdIndex();
        }
    },
    LOGIN {
        {
            cmd = new CmdLogin();
        }
    },
    SIGNUP {
        {
            cmd = new CmdSignUp();
        }
    },
    PROFILE {
        {
            cmd = new CmdProfile();
        }
    },
    CREATEADVERT {
        {
            cmd = new CmdCreateAdvert();
        }
    },
    EDITUSERS {
        {
            cmd = new CmdEditUsers();
        }
    },
    INITDB {
        {
            cmd = new CmdInitDb();
        }
    },
    RESETDB {
        {
            cmd = new CmdResetDb();
        }
    },
    ERROR {
        {
            cmd = new CmdError();
        }
    };
    Cmd cmd = new CmdError();
    String jsp = "/" + this.toString().toLowerCase() + ".jsp";

}
