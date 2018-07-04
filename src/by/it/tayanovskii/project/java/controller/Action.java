package by.it.tayanovskii.project.java.controller;

enum Action {
    INDEX {
        {
            cmd = new CmdIndex();
        }
    },
    RESETDB {
        {
            cmd = new CmdResetDB();
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
    CREATEPUBLICATION{
        {
            cmd = new CmdCreatePublication();
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
