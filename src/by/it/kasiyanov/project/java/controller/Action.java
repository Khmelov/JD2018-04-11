package by.it.kasiyanov.project.java.controller;

enum Action {
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
    EDITUSERS{
        {
            cmd=new CmdEditUsers();
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
