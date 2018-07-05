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
    EDITUSERS{
        {
            cmd = new CmdEditUsers();

        }
    },
    CREATEAVTO {
        {
            cmd = new CmdCreateAvto();

        }
    },
    CREATEORDERS {
        {
            cmd = new CmdCreateOrder();

        }
    },
    PASSPORTS {
        {
            cmd = new CmdPassports();

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
