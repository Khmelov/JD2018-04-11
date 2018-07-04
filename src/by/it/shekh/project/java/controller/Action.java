package by.it.shekh.project.java.controller;

public enum Action {
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
    }, PROFILE {
        {
            cmd = new CmdProfile();
        }
    }, CREATEFACADE {
        {
            cmd = new CmdAddFacade();
        }
    }, EDITUSER {
        {
            cmd = new CmdEditUsers();
        }
    }, EDITFACADE {
        {
            cmd = new CmdEditFacade();
        }
    }, ERROR {
        {
            cmd = new CmdError();
        }
    };
    Cmd cmd = new CmdError();
    String jsp = "/" + this.toString().toLowerCase() + ".jsp";
}
