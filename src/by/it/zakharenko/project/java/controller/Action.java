package by.it.zakharenko.project.java.controller;

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
            cmd = new CmdLogOut();
        }
    },
    CREATEBOOK {
        {
            cmd = new CmdCreateBook();
        }
    },
    READBOOK {
        {
            cmd = new CmdReadBook();
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