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
    SIGNUP {
        {
            cmd = new CmdSignUp();

        }
    },
    LOGOUT{
        {
        cmd = new CmdLogOut();

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
