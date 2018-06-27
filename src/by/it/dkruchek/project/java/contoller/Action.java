package by.it.dkruchek.project.java.contoller;

enum Action {
    INDEX {
        {
            cmd = new CmdIndex();
        }
    }, LOGIN {
        {
            cmd = new CmdLogin();
        }
    }, SIGNUP {
        {
            cmd = new CmdSignUp();
        }
    }, ERROR {
        {
            cmd = new CmdError();
        }
    }, VACATION {
        {
            cmd = new CmdVacation();
        }
    };

    Cmd cmd = new CmdError();
    String jsp = "/" + this.toString().toLowerCase() + ".jsp";
}
