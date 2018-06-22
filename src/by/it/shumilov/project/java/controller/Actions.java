package by.it.shumilov.project.java.controller;

public enum Actions {
    INDEX {
        {
            cmd = new CmdIndex();
            String jsp = "/index.jsp";
        }
    },
    LOGIN {
        {
            cmd = new CmdLogin();
            String jsp = "/login.jsp";
        }
    },
    SIGNUP {
        {
            cmd = new CmdSignUp();
            String jsp = "/signup.jsp";
        }
    },
    ERROR {
        {
            Cmd cmd = new CmdError();
            String jsp = "/error.jsp";
        }
    };

    Cmd cmd = new CmdError();
    String jsp = "/error.jsp";
}
