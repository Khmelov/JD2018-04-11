package by.it.mokhart.project.java.controller;

enum Actions {
    INDEX {
        {
            cmd = new CmdIndex();
            //jsp = "/index.jsp";
        }
    },
    CREATEAD {
        {
            cmd = new CmdCreateAd();
        }
    },
    LOGIN {
        {
            cmd = new CmdLogin();
            //jsp = "/login.jsp";
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
            //jsp = "/signup.jsp";
        }
    },
    RESETDB {
        {
            cmd = new CmdResetDB();
        }
    },
    ERROR {
        {
            cmd = new CmdError();
            // jsp = "/error.jsp";
        }
    };
    Cmd cmd = new CmdError();
    String jsp = "/" + this.toString().toLowerCase() + ".jsp";
    //String jsp = "/error.jsp";

}
