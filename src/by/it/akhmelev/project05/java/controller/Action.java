package by.it.akhmelev.project05.java.controller;

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
    ERROR {
        {
            cmd = new CmdError();
        }
    };
    Cmd cmd = new CmdError();
    String jsp = "/"+this.toString().toLowerCase()+".jsp";

}
