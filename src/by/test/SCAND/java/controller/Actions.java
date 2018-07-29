package by.test.SCAND.java.controller;

enum Actions {
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
    PROFILE {
        {
            cmd = new CmdProfile();
        }
    },
    CREATEAD {
        {
            cmd = new CmdCreateAd();
        }
    },
    LOGOUT {
        {
            cmd = new CmdLogOut();

        }
    },
    SIGNUP {
        {
            cmd = new CmdSignUp();

        }
    },
    EDITUSERS{
        {
            cmd=new CmdEditUsers();
        }
    },
    EDITAD {
        {
            cmd = new CmdEditAd();

        }
    },
    BUY {
        {
            cmd = new CmdBuy();

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
