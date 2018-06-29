package by.it.shumilov.project.java.controller;

public enum Action {
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
    SIGNUP {
        {
            cmd = new CmdSignUp();

        }
    },
    RESETDB {
        {
            cmd = new CmdResetBD();

        }
    },
    LOGOUT{
        {
        cmd = new CmdLogOut();

    }
    },
    CREATEAVTO {
        {
            cmd = new CmdCreateAvto();

        }
    },
    CREATEORDER {
        {
            cmd = new CmdCreateOrder();

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
