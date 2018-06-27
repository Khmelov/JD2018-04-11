package by.it.mokhart.project.java.controller;

public enum Actions {
    INDEX {
        {
            cmd = new CmdIndex();
            //jsp = "/index.jsp";
        }
    },
    LOGIN {
        {
            cmd = new CmdLogin();
            //jsp = "/login.jsp";
        }
    },
    SIGNUP {
        {
            cmd = new CmdSignUp();
            //jsp = "/signup.jsp";
        }
    },
    ERROR {
        {
            cmd = new CmdError();
           // jsp = "/error.jsp";
        }
    };
    Cmd cmd = new CmdError();
    String jsp = "/"+this.toString().toLowerCase()+".jsp";
    //String jsp = "/error.jsp";

}
