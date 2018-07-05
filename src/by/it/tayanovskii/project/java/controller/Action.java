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
    EDITUSERS{
        {
            cmd=new CmdEditUsers();
        }
    },
    SIGNUP {
        {
            cmd = new CmdSignUp();
        }
    },
    EDITPUBLICATION {
        {
            cmd = new CmdEditPublication();
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
    BUYPUBLICATION{
        {
            cmd = new CmdBuyPublication();
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
