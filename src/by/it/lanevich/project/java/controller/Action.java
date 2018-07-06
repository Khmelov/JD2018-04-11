package by.it.lanevich.project.java.controller;

enum Action {
    INDEX {
        {
            cmd = new CmdIndex();
        }
    },
    CREATEORDER {
        {
            cmd = new CmdCreateOrder();
        }
    },
    EDITORDER {
        {
            cmd = new CmdEditOrder();
        }
    },
    CREATEGOOD {
        {
            cmd = new CmdCreateGood();
        }
    },
    EDITGOOD {
        {
            cmd = new CmdEditGood();
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
