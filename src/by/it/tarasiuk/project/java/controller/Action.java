package by.it.tarasiuk.project.java.controller;

enum Action {
    INDEX {
        {
            cmd = new CmdIndex();
//            jsp = "/index.jsp";
        }
    },
    LOGIN {
        {
            cmd = new CmdLogin();
//            jsp = "/login.jsp";
        }
    },
    SIGNUP {
        {
            cmd = new CmdSignUp();
//            jsp = "/signup.jsp";
        }
    },
    PROFILE {
        {
            cmd = new CmdProfile();
//            jsp = "/profile.jsp";
        }
    },
    CREATEADVERT {
        {
            cmd = new CmdCreateAdvert();
//            jsp = "/createadvert.jsp";
        }
    },
    RESETDB {
        {
            cmd = new CmdResetDb();
        }
    },
    ERROR {
        {
            cmd = new CmdError();
//            jsp = "/error.jsp";
        }
    };
    Cmd cmd = new CmdError();
    String jsp = "/" + this.toString().toLowerCase() + ".jsp";

}
