package by.it.tayanovskii.project.java.controller;

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
    LOGOUT {
        {
            cmd = new CmdLogout();
        }
    },
    READPUBLICATION{
        {
            cmd = new CmdReadPublication();
        }
    },
    CREATEPUBLICATION{
        {
            cmd = new CmdCreatePublication();
        }
    },
    SETPERMISSION{
        {
            cmd = new CmdSetPermission();
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
