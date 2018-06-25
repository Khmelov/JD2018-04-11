package by.it.dkruchek.project.java.contoller;

public enum Actions {
    INDEX {
        {
            cmd = new CmdIndex();
            jsp = "/index.jsp";
        }
    }, LOGIN {
        {
            cmd = new CmdLogin();
            jsp = "/login.jsp";
        }
    }, SIGNUP {
        {
            cmd = new CmdSignUp();
            jsp = "/signup.jsp";
        }
    }, ERROR {
        {
            cmd = new CmdError();
            jsp = "/error.jsp";
        }
    };

    Cmd cmd = new CmdError();
    String jsp = "/error.jsp";
}
